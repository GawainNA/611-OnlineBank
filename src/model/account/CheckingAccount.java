package model.account;

import model.ErrCode;
import model.currency.Currency;
import model.currency.CurrencyType;

public class CheckingAccount extends Account{
    public void deposit(double amount, CurrencyType currencyType) {
        // TODO:
    }

    public void deposit(Currency currency) {
        // TODO:
    }

    public ErrCode withdraw(double amount, CurrencyType currencyType) {
        // TODO:

        return null;
    }

    public ErrCode withdraw(Currency currency) {
        // TODO:

        return null;
    }
}