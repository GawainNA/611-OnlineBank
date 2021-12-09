package model;

import java.util.List;
import java.util.Map;

import model.account.Account;
import model.user.Customer;

/**
 * This class stores all objects that needed to be persisted. 
 * Also it can search object through id.
 * Just use this class as a database interface.
 * Singleton.
 */
public class BankDatabaseByDisk implements BankDatabase{
    // TODO:
    // list of objects, use to persistence
    private List<Account> accountList;
    private List<Customer> customerList;
    private List<Loan> loanList;

    // map of objects, use to accelerate search speed
    // key: object id; value: object
    private transient Map<Integer, Account> idAccountMap;
    private transient Map<Integer, Customer> idCustomerMap;
    private transient Map<Integer, Loan> idLoanMap;

    private static BankDatabaseByDisk bankDatabase;

    private BankDatabaseByDisk() {
        // TODO: initialize lists and maps
        
    }

    /**
     * 
     * @param id: customer id
     * @return customer object if id exist. or null if no customer with such id.
     */
    public Customer getCustomerById(int id) {
        // TODO:
        
        return null;
    }


    /**
     * 
     * @param id account id
     * @return account object if id exist. or null if no account with such id
     */
    public Account getAccountById(int id) {
        // TODO:

        return null;
    }


    /**
     * 
     * @param id loan id
     * @return loan object if id exist. or null if no loan with such id
     */
    public Loan getLoanById(int id) {
        // TODO:

        return null;
    }

    public static BankDatabaseByDisk getInstance() {
        if(bankDatabase == null) {
            bankDatabase = new BankDatabaseByDisk();
        }
        return bankDatabase;
    }
}
