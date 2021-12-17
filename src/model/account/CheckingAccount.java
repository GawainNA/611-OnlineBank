package model.account;

import model.Bank;
import model.ErrCode;
import model.Transaction;
import model.currency.Currency;
import model.currency.CurrencyType;

public class CheckingAccount extends Account{
    public void deposit(double amount, CurrencyType currencyType) {
        addCurrency(new Currency(currencyType, amount));
        
        // add transaction
        String desc = String.format("account %d deposit %.2f %s", 
                                    this.getId(),
                                    amount,
                                    currencyType.getName());
        Transaction transaction = new Transaction(desc);
        Bank.getInstance().getBankDatabase().getCustomerById(this.getUserId()).addTransaction(transaction);
        Bank.getInstance().getBankDatabase().getManager().addTransaction(transaction);

        Bank.getInstance().getBankDatabase().update();
    }

    public void deposit(Currency currency) {
        deposit(currency.getAmount(), currency.getCurrencyType());
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

        // add transaction
        String desc = String.format("account %d withdraw %.2f %s", 
                                    this.getId(),
                                    currency.getAmount(),
                                    currency.getCurrencyType().getName());
        Transaction transaction = new Transaction(desc);
        Bank.getInstance().getBankDatabase().getCustomerById(this.getUserId()).addTransaction(transaction);
        Bank.getInstance().getBankDatabase().getManager().addTransaction(transaction);


        Bank.getInstance().getBankDatabase().update(); 
        return errCode;
    }
}