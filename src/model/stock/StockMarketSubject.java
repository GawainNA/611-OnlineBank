package model.stock;

/**
 * use observer pattern on stock market
 */
public interface StockMarketSubject {
    public void register(StockMarketObserver observer);

    public void unregister(StockMarketObserver observer);

    public void notifyObservers();
}
