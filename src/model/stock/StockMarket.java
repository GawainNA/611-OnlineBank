package model.stock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Bank;
import model.Persistable;
import model.currency.Currency;
import model.currency.CurrencyType;
import model.user.Customer;
import util.FileUtil;

/**
 * class of StockMarket, singleton
 */
public class StockMarket implements Persistable, StockMarketSubject{
    public static final String STOCKS_INFO_FILEPATH = System.getProperty("user.dir") + "/stocks.csv";
    private static StockMarket stockMarket;

    private Map<String, Stock> nameStockMap;    // key: stock name; value: stock obj
    private Set<StockMarketObserver> stockMarketObserverSet;  // use in observer pattern

    private StockMarket() {
        nameStockMap = new HashMap<>();
        stockMarketObserverSet = new HashSet<>();
        updateObserverSet();
        updateStocksInfo();
    }

    public Stock getStockByName(String stockName) {
        return nameStockMap.get(stockName);
    }

    public Set<String> getAllStockNames() {
        return nameStockMap.keySet();
    }

    public Currency getStockUnitPrice(String stockName) {
        Stock stock = getStockByName(stockName);
        if(stock == null) {
            return null;
        }
        return stock.getUnitPrice();
    }

    public static StockMarket getInstance() {
        if(stockMarket == null) {
            stockMarket = new StockMarket();
        }
        return stockMarket;
    }


    public void updateStocksInfo() {
        List<String> stocksInfo = FileUtil.readFileByLine(STOCKS_INFO_FILEPATH);
        nameStockMap.clear();
        for(String stockInfo : stocksInfo) {
            Stock stock = parseStockInfoStr(stockInfo);
            nameStockMap.put(stock.getName(), stock);
        }
        notifyObservers();
    }

    private Stock parseStockInfoStr(String stockInfo) {
        // name,unitPrice,currencyType
        String[] splits = stockInfo.split(",");
        String name = splits[0];
        double unitPrice = Double.parseDouble(splits[1]);
        CurrencyType currencyType = CurrencyType.str2CurrencyType(splits[2]);

        return new Stock(name, unitPrice, currencyType, Integer.MAX_VALUE);
    }

    private void updateObserverSet() {
        List<Customer> customerList = Bank.getInstance().getBankDatabase().getAllCustomer();
        for(Customer customer : customerList) {
            if(customer.getSecurityAccount() != null) {
                register(customer.getSecurityAccount());
            }
        }
    }

    @Override
    public void register(StockMarketObserver observer) {
        stockMarketObserverSet.add(observer);
    }

    @Override
    public void unregister(StockMarketObserver observer) {
        stockMarketObserverSet.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(StockMarketObserver observer : stockMarketObserverSet) {
            observer.update();
        }
    }

}