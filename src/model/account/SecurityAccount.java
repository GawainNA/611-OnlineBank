package model.account;

import java.util.List;

import model.ErrCode;
import model.stock.Stock;
import model.stock.StockMarket;

public class SecurityAccount extends Account {
    private StockMarket stockMarket;
    private List<Stock> stockList;
    private double realizedProfit;
    private double unrealizedProfit;

    public ErrCode buyStock(Stock stock) {
        // TODO:

        return null;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public ErrCode sellStock(Stock stock) {
        // TODO:

        return null;
    }

    /**
     * update realized and unrealized profit after buy or sell stocks
     */
    private void updateProfit() {

    }
    
}