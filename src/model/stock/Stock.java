package model.stock;

import model.Persistable;
import model.currency.Currency;
import model.currency.CurrencyType;

public class Stock implements Persistable {
    private String name;
    private Currency unitPrice;
    private int numberOfStock; // amount of stocks
    private Currency totalPrice;

    public Stock(String name, double unitPriceAmount, CurrencyType currencyType, int numberOfStock) {
        this.name = name;
        this.unitPrice = new Currency(currencyType, unitPriceAmount);
        this.numberOfStock = numberOfStock;
        this.totalPrice = new Currency(currencyType, unitPriceAmount * numberOfStock);
    }

    public Stock(String name, Currency unitPrice, int numberOfStock) {
        this(name, unitPrice.getAmount(), unitPrice.getCurrencyType(), numberOfStock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Currency price) {
        this.unitPrice = price;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    /**
     * if buy the same stock with different price, we can use addStock to update
     * price and amount
     * 
     * @param stock
     * @return false if two stocks' name are different. else true
     */
    public boolean addStock(Stock stock) {
        if(!stock.getName().equals(this.name)) {
            return false;
        }

        CurrencyType currencyType = this.unitPrice.getCurrencyType();

        // current stock info
        double currentTotalPriceAmount = totalPrice.getAmount();
        int currentNumStock = numberOfStock;

        // added stock info
        double addedTotalPriceAmount = stock.totalPrice.getAmount();
        int addedNumStock = stock.numberOfStock;

        // after addition, new stock info
        double newTotalPriceAmount = currentTotalPriceAmount + addedTotalPriceAmount;
        int newNumStock = currentNumStock + addedNumStock;
        double newUnitPriceAmount =  newTotalPriceAmount / newNumStock;

        this.numberOfStock = newNumStock;
        this.unitPrice = new Currency(currencyType, newUnitPriceAmount);
        this.totalPrice = new Currency(currencyType, newTotalPriceAmount);
        
        return true;
    }

    /**
     * if sell the same stock with different price, we can use minusStock to update
     * price and amount
     * 
     * when we minus stock, unit price do not change!
     * 
     * @param stock
     * @return return false if two stock's name are different
     */
    public boolean minusStock(Stock stock) {
        if(!stock.getName().equals(this.name)) {
            return false;
        }

        CurrencyType currencyType = this.unitPrice.getCurrencyType();

        // current stock info
        int currentNumStock = numberOfStock;

        // minus stock info
        int minusNumStock = stock.numberOfStock;

        // after minus, new stock info
        int newNumStock = currentNumStock - minusNumStock;
        double newTotalPriceAmount = this.unitPrice.getAmount() * newNumStock;

        this.numberOfStock = newNumStock;
        this.totalPrice = new Currency(currencyType, newTotalPriceAmount);
        
        return true;
    }

    public Currency getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Currency totalPrice) {
        this.totalPrice = totalPrice;
    }

}