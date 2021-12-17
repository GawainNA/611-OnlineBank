package model.currency;

import model.Persistable;

public class Currency implements Persistable{
    private CurrencyType currencyType;
    private double amount;

    public Currency(CurrencyType currencyType, double amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void add(Currency addition) {
        amount += addition.amount;
    }

    public void minus(Currency minus) {
        amount -= minus.amount;
    }
}