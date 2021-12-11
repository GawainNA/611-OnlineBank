package model.stock;

import java.util.Map;

import model.ErrCode;
import model.Persistable;

/**
 * class of StockMarket, singleton
 */
public class StockMarket implements Persistable{
    private static StockMarket stockMarket;

    private Map<String, Stock> nameStockMap;    // key: stock name; value: stock obj

    public static StockMarket getInstance() {
        // TODO:

        return null;
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

}