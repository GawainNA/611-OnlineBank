package model.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Bank;
import model.ErrCode;
import model.currency.Currency;
import model.currency.CurrencyType;
import model.stock.Stock;
import model.stock.StockMarket;
import model.stock.StockMarketObserver;

public class SecurityAccount extends Account implements StockMarketObserver {
    // private transient StockMarket stockMarket = StockMarket.getInstance();
    private Map<String, Stock> nameStockMap;
    private Currency realizedProfit;
    private Currency unrealizedProfit;

    public SecurityAccount() {
        super();
        // stockMarket = StockMarket.getInstance();
        nameStockMap = new HashMap<>();
        realizedProfit = new Currency(CurrencyType.DOLLAR, 0);
        unrealizedProfit = new Currency(CurrencyType.DOLLAR, 0);
        StockMarket.getInstance().register(this);
    }

    public ErrCode buyStock(String stockName, int numStock2Buy) {
        ErrCode errCode = new ErrCode(true, "success");

        // check whether stock market has this stock
        Stock stockToBuy = StockMarket.getInstance().getStockByName(stockName);
        if (stockToBuy == null) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("do not have stock name: ", stockName);
            return errCode;
        }

        // check whether this account has enough money
        // only allow to use DOLLAR to buy stocks
        double moneyNeeded = stockToBuy.getUnitPrice().getAmount() * numStock2Buy;
        CurrencyType currencyType = CurrencyType.DOLLAR;
        Currency depositDollar = getCurrencyByType(currencyType);
        if (depositDollar.getAmount() < moneyNeeded) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("should have %.2f in account, do not have enough money", moneyNeeded);
            return errCode;
        }

        // buy stock, first check whether we have the same stock
        if (!nameStockMap.containsKey(stockName)) {
            nameStockMap.put(stockName, new Stock(stockName, 0, currencyType, 0));
        }
        Stock stockInHand = nameStockMap.get(stockName);
        Stock stockToActualBuy = new Stock(stockName, stockToBuy.getUnitPrice(), numStock2Buy);
        stockInHand.addStock(stockToActualBuy);

        // minus money from security account
        this.minusCurrency(stockToActualBuy.getTotalPrice());


        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    public ErrCode sellStock(String stockName, int numStock2Sell) {
        ErrCode errCode = new ErrCode(true, "success");

        // check whether has this stock
        if (!nameStockMap.containsKey(stockName)) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("do not have stock with name: %s", stockName);
            return errCode;
        }

        Stock stockInHand = nameStockMap.get(stockName);
        // check whether has enough amount of stock to sell
        if (stockInHand.getNumberOfStock() < numStock2Sell) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have enough number of stock to sell";
            return errCode;
        }

        // sell and update realized and unrealized profit
        Stock stockInMarket = StockMarket.getInstance().getStockByName(stockName);
        CurrencyType currencyType = stockInHand.getUnitPrice().getCurrencyType();
        double unitPriceDiff = stockInHand.getUnitPrice().getAmount() - stockInMarket.getUnitPrice().getAmount();
        Currency profit = new Currency(currencyType, numStock2Sell * unitPriceDiff);
        realizedProfit.add(profit);
        unrealizedProfit.minus(profit);
        // add this sell price into security account
        this.addCurrency(new Currency(currencyType, numStock2Sell * stockInMarket.getUnitPrice().getAmount()));
        // update stock in hand
        Stock stock2Sell = new Stock(stockName, stockInMarket.getUnitPrice(), numStock2Sell);
        stockInHand.minusStock(stock2Sell);


        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    public List<Stock> getStockList() {
        List<Stock> stockList = new ArrayList<>();
        for (String name : nameStockMap.keySet()) {
            Stock stockInHand = nameStockMap.get(name);
            if (stockInHand.getNumberOfStock() > 0) {
                stockList.add(stockInHand);
            }
        }
        return stockList;
    }

    /**
     * observer pattern
     * update unrealized profit when stock market call this method
     */
    @Override
    public void update() {
        updateUnrealizedProfit();
    }

    /**
     * update realized and unrealized profit after buy or sell stocks
     */
    private void updateUnrealizedProfit() {
        // iterate over each stock in hand, calculate unrealized profit by comparing to
        // stock in market
        for (String stockName : nameStockMap.keySet()) {
            Stock stockInHand = nameStockMap.get(stockName);
            Stock stockInMarket = StockMarket.getInstance().getStockByName(stockName);
            double unitPriceDiff = stockInHand.getUnitPrice().getAmount() - stockInMarket.getUnitPrice().getAmount();
            unrealizedProfit.add(
                    new Currency(unrealizedProfit.getCurrencyType(), unitPriceDiff * stockInHand.getNumberOfStock()));
        }
    }

    public Currency getRealizedProfit() {
        return realizedProfit;
    }

    public void setRealizedProfit(Currency realizedProfit) {
        this.realizedProfit = realizedProfit;
    }

    public Currency getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(Currency unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

}