package model.account;

import model.Bank;
import model.ErrCode;
import model.currency.Currency;
import model.currency.CurrencyType;

public class SavingAccount extends Account {
    private double interest;

    public SavingAccount(double interest) {
        this.setInterest(interest);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void deposit(double amount, CurrencyType currencyType) {
        deposit(new Currency(currencyType, amount));
    }

    public void deposit(Currency currency) {
        addCurrency(currency);
        Bank.getInstance().getBankDatabase().update();
    }

    public ErrCode withdraw(double amount, CurrencyType currencyType) {
        return withdraw(new Currency(currencyType, amount));
    }

    public ErrCode withdraw(Currency currency) {
        ErrCode errCode = new ErrCode(true, "success");

        Currency deposit = this.getCurrencyByType(currency.getCurrencyType());
        // check whether has specific currency type
        if(deposit == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have specific type of currency";
            return errCode;
        }
        // check whether has enough money
        if(deposit.getAmount() < currency.getAmount()) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have enough money";
            return errCode;
        }

        minusCurrency(currency);  
        Bank.getInstance().getBankDatabase().update(); 

        return errCode;
    }
    
}