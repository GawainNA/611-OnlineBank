package model.currency;

public class Currency {
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
}