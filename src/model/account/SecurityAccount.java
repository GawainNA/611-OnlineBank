package model.account;

import java.util.List;

import model.stock.Stock;
import model.stock.StockMarket;

public class SecurityAccount extends Account {
    private StockMarket stockMarket;
    private List<Stock> stocks;
    private double realizedProfit;
    private double unrealizedProfit;
    
}