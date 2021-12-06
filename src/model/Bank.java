package model;

import java.util.List;
import java.util.Map;

import model.user.Customer;
import model.user.Manager;

/**
 * Singleton
 */
public class Bank {
    private static Bank bank;
    
    // private Map<Integer, Customer> id2CustomerMap;
    // private Map<Integer, Manager> id2ManagerMap;
    private List<Customer> customerList;
    private Manager manager;
    private Map<String, Customer> username2CustomerMap;
    private Map<String, Manager> username2ManagerMap;

    private Bank() {
    }

    public static Bank getInstance() {
        if(bank == null) {
            bank = new Bank();
        }
        return bank;
    }
}