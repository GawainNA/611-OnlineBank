package model.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ErrCode;
import model.Persistable;
import model.currency.Currency;

/**
 * class of StockMarket, singleton
 */
public class StockMarket implements Persistable, StockMarketSubject{
    private static StockMarket stockMarket;

    private Map<String, Stock> nameStockMap;    // key: stock name; value: stock obj
    private List<StockMarketObserver> stockMarketObserverList;  // use in observer pattern

    private StockMarket() {
        nameStockMap = new HashMap<>();
        stockMarketObserverList = new ArrayList<>();
    }

    public Stock getStockByName(String stockName) {
        return nameStockMap.get(stockName);
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

    public void addStockToMarket(Stock stock) {
        // TODO:
    }

    public ErrCode removeStockFromMarket(Stock stock) {
        // TODO:

        return null;
    }

    public void updateStocksInfo() {
        // TODO:
    }

    @Override
    public void register(StockMarketObserver observer) {
        stockMarketObserverList.add(observer);
    }

    @Override
    public void unregister(StockMarketObserver observer) {
        stockMarketObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(StockMarketObserver observer : stockMarketObserverList) {
            observer.update();
        }
    }

}