package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.user.Customer;
import model.user.CustomerFactory;
import model.user.Manager;
import model.user.User;
import model.user.UserGender;

/**
 * Singleton
 */
public class Bank {
    private static Bank bank;
    
    // private Map<Integer, Customer> id2CustomerMap;
    // private Map<Integer, Manager> id2ManagerMap;
    private Manager manager;
    private transient Map<String, Customer> username2CustomerMap;

    private Bank() {
        manager = Manager.getInstance();
        username2CustomerMap = new HashMap<>();
    }

    public static Bank getInstance() {
        if(bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public User getUserByNameAndPasswd(String userName, String passwd) {
        // first check whether is manager login
        if(manager.getUsername().equals(userName) &&
            manager.getPasswd().equals(passwd)) {
            return manager;
        }
        
        if(!username2CustomerMap.containsKey(userName)) {
            return null;
        }
        Customer customer = username2CustomerMap.get(userName);
        if(!customer.getPasswd().equals(passwd)) {
            return null;
        }

        return customer;
    }

    /**
     * 
     * @param userName
     * @param gender
     * @param address
     * @param email
     * @param passwd
     * @param phone
     * @param openChecking
     * @param openSaving
     * @return successful or not
     */
    public boolean addCustomer(String username, 
                                UserGender gender, 
                                String address, 
                                String email,
                                String passwd,
                                String phoneNum,
                                boolean openCheckingAccount,
                                boolean openSavingAccount) {
        // TODO: first to see whether already have customer with same username
        Customer newCustomer = CustomerFactory.getInstance().createCustomer(username, gender, email, passwd, address, phoneNum);
        if(openCheckingAccount) { 
            newCustomer.openCheckingAccount();
        }
        if(openSavingAccount) {
            newCustomer.openSavingAccount();
        }
        username2CustomerMap.put(username, newCustomer);
        return true;
    }
}