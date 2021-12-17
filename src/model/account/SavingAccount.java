package model.account;

import model.Bank;
import model.ErrCode;
import model.Transaction;
import model.currency.Currency;
import model.currency.CurrencyType;
import model.user.Customer;

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

        // add transaction
        String desc = String.format("Account %d deposit %.2f %s", 
                                    this.getId(),
                                    currency.getAmount(),
                                    currency.getCurrencyType().getName());
        Transaction transaction = new Transaction(desc);
        Bank.getInstance().getBankDatabase().getCustomerById(this.getUserId()).addTransaction(transaction);
        Bank.getInstance().getBankDatabase().getManager().addTransaction(transaction);

        Bank.getInstance().getBankDatabase().update();
    }

    public ErrCode withdraw(double amount, CurrencyType currencyType) {
        return withdraw(new Currency(currencyType, amount));
    }

    public ErrCode withdraw(Currency currency) {
        ErrCode errCode = new ErrCode(true, "success");

        Currency deposit = this.getCurrencyByType(currency.getCurrencyType());
        // check whether has specific currency type
        if (deposit == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have specific type of currency";
            return errCode;
        }
        // check whether has enough money
        if (deposit.getAmount() < currency.getAmount()) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have enough money";
            return errCode;
        }

        minusCurrency(currency);


        // add transaction
        String desc = String.format("Account %d withdraw %.2f %s", 
                                    this.getId(),
                                    currency.getAmount(),
                                    currency.getCurrencyType().getName());
        Transaction transaction = new Transaction(desc);
        Bank.getInstance().getBankDatabase().getCustomerById(this.getUserId()).addTransaction(transaction);
        Bank.getInstance().getBankDatabase().getManager().addTransaction(transaction);


        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    @Override
    public ErrCode transferTo(int destId, double amount, CurrencyType currencyType) {
        ErrCode errCode = new ErrCode(true, "success");
        // if current user have security account, make sure this saving account has 2500
        // dollars at least

        // if currencyType is not dollar, just transfer
        if(!currencyType.equals(CurrencyType.DOLLAR)) {
            return super.transferTo(destId, amount, currencyType);
        }

        Customer customer = Bank.getInstance().getBankDatabase().getCustomerById(this.getUserId());
        // if do not have security account, just transfer
        if(customer.getSecurityAccount() == null) {
            return super.transferTo(destId, amount, currencyType);
        }

        //if has security account, make sure to leave at least 2500 dollars
        if(this.getCurrencyByType(currencyType).getAmount() - amount < 2500) {
            errCode.isSuccess = false;
            errCode.errMsg = "cannot transfer, please leave at least 2500 dollars in saving account";
            return errCode;
        }
        

        return super.transferTo(destId, amount, currencyType);
    }

    @Override
    public ErrCode transferTo(int destId, Currency currency) {
        return this.transferTo(destId, currency.getAmount(), currency.getCurrencyType());
    }

}