package model.account;

import java.util.HashMap;
import java.util.Map;

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
    public boolean transfer(int destId, double amount, CurrencyType currencyType) {
        // TODO:
        
        return true;
    }

    /**
     * 
     * @param destId: destinate account id
     * @param currency: currency to transfer
     * @return if destId doesn't exist, or do not have enough money to transfer, return false. else return true.
     */
    public boolean transfer(int destId, Currency currency) {
        // TODO:

        return true;
    }

}