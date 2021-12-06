package model.currency;

public class Currency {
    private CurrencyType currencyType;
    private double amount;

    public Currency(CurrencyType currencyType, double amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }
}