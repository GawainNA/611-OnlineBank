package model;

import java.util.List;
import java.util.Map;

import model.user.Customer;
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
    private List<Customer> customerList;
    private Manager manager;
    private transient Map<String, Customer> username2CustomerMap;
    private transient Map<String, Manager> username2ManagerMap;

    private Bank() {
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
    public boolean addCustomer(String userName, 
                                UserGender gender, 
                                String address, 
                                String email,
                                String passwd,
                                String phone,
                                boolean openChecking,
                                boolean openSaving) {
        // TODO:

        return true;
    }
}