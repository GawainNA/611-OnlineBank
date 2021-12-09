package model.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.ErrCode;
import model.currency.Currency;
import model.currency.CurrencyType;
import util.IdCreator;

/**
 * abstract class of account
 */
public abstract class Account {
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
    public ErrCode transfer(int destId, double amount, CurrencyType currencyType) {
        // TODO:
        
        return null;
    }

    /**
     * 
     * @param destId: destinate account id
     * @param currency: currency to transfer
     * @return if destId doesn't exist, or do not have enough money to transfer, return false. else return true.
     */
    public ErrCode transfer(int destId, Currency currency) {
        // TODO:
        
        return null;
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

}