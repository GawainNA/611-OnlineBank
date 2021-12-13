package model.database;

import java.util.List;

import model.Loan;
import model.account.Account;
import model.user.Customer;
import model.user.Manager;
import view.ManageLoan;

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
    

    /**
     * temporarily use this interface to notify a modification to database
     */
    public void update();


    /**
     * 
     * @param customer new customer add to database
     */
    public void addCustomer(Customer customer);


    /**
     * 
     * @param account new account add to database
     */
    public void addAccount(Account account);


    /**
     * 
     * @param loan new loan add to database
     */
    public void addLoan(Loan loan);


    /**
     * 
     * @return manager of this bank
     */
    public Manager getManager();


    /**
     * 
     * @return all customers of this bank
     */
    public List<Customer> getAllCustomer();
}
