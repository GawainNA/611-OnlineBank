package model.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Bank;
import model.ErrCode;
import model.Persistable;
import model.currency.Currency;
import model.currency.CurrencyType;
import util.IdCreator;

/**
 * abstract class of account
 */
public abstract class Account implements Persistable{
    private int id;
    private Map<CurrencyType, Currency> currencyMap;
    private boolean isClosed;

    public Account() {
        id = IdCreator.createRandomInt();
        currencyMap = new HashMap<>();
        isClosed = false;
    }

    /**
     * 
     * @param destId: destinate account id.
     * @param amount: amount of money to transfer.
     * @param currencyType: currency type
     * @return if destId doesn't exist, or do not have enough money to transfer, return false. else return true.
     */
    public ErrCode transferTo(int destId, double amount, CurrencyType currencyType) {
        ErrCode errCode = new ErrCode(true, "success");
        // check whether have enough money
        if(!currencyMap.containsKey(currencyType) || 
            currencyMap.get(currencyType).getAmount() < amount) {

            errCode.errMsg = String.format("do not have enough money on type %s", currencyType.getName());
            errCode.isSuccess = false;
            return errCode;
        }

        // check whether destId is valid
        Account destAccount = Bank.getInstance().getBankDatabase().getAccountById(destId);
        if(destAccount == null) {
            errCode.errMsg = "destinate account does not exist";
            errCode.isSuccess = false;
            return errCode;
        }

        // check whether destAccount has closed already
        if(destAccount.isClosed) {
            errCode.errMsg = "destinate account has been closed, cannot transfer to";
            errCode.isSuccess = false;
            return errCode;
        }

        // if all valid, transfer
        Currency transferCurrency = new Currency(currencyType, amount);
        destAccount.addCurrency(transferCurrency);
        this.minusCurrency(transferCurrency);

        // update database
        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    protected void addCurrency(Currency currency) {
        CurrencyType currencyType = currency.getCurrencyType();
        if(!currencyMap.containsKey(currencyType)) {
            currencyMap.put(currencyType, new Currency(currencyType, 0));
        }
        currencyMap.get(currencyType).add(currency);
    }

    protected void minusCurrency(Currency currency) {
        currencyMap.get(currency.getCurrencyType()).minus(currency);
    }

    /**
     * 
     * @param destId: destinate account id
     * @param currency: currency to transfer
     * @return if destId doesn't exist, or do not have enough money to transfer, return false. else return true.
     */
    public ErrCode transferTo(int destId, Currency currency) {
        return transferTo(destId, currency.getAmount(), currency.getCurrencyType());
    }


    /**
     * 
     * @return all currencyType that in user account
     */
    public Set<CurrencyType> getAllCurrencyType() {
        return currencyMap.keySet();
    }


    /**
     * 
     * @param currencyType: type of currency to get
     * @return: currency of specific currency type. if currency type does not exist, return null
     */
    public Currency getCurrencyByType(CurrencyType currencyType) {
        return currencyMap.get(currencyType);
    }

    public int getId() {
        return id;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

}