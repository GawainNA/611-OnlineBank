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

}