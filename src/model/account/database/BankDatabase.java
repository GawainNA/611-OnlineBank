package model.account.database;

import model.Loan;
import model.account.Account;
import model.user.Customer;

// TODO: add add***() methods   C
// TODO: add delete***() methods    D
// TODO: add update***() methods    U
// TODO: add flush() methods
// TODO: add read() methods

/**
 * BankDatabase interface
 * Should support functions to CRUD
 */
public interface BankDatabase {
    /**
     * 
     * @param id: customer id
     * @return customer object if id exist. or null if no customer with such id.
     */
    public Customer getCustomerById(int id);


    /**
     * 
     * @param id account id
     * @return account object if id exist. or null if no account with such id
     */
    public Account getAccountById(int id);


    /**
     * 
     * @param id loan id
     * @return loan object if id exist. or null if no loan with such id
     */
    public Loan getLoanById(int id);
    
}
