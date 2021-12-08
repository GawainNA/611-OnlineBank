package model;

import model.account.Account;
import model.currency.Currency;

public class Transaction {
    private Account from;
    private Account to;
    private Currency amount;
    private String desc;
}
