package model;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.database.BankDatabase;
import model.user.Customer;
import model.user.User;
import model.user.UserGender;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest {
    private Bank bank;
    private BankDatabase bankDatabase;

    private String username = "test1";
    private UserGender gender = UserGender.FEMALE;
    private String address = "address1";
    private String email = "email1";
    private String passwd = "passwd1";
    private String phoneNum = "123";
    private boolean openCheckingAccount = false;
    private boolean openSavingAccount = false;

    @Before
    public void init() {
        bank = Bank.getInstance();
        bankDatabase = bank.getBankDatabase();
    }
    
    @Test
    public void atestAddUser() {
        
        // bank = Bank.getInstance();
        boolean isSuccess = bank.addCustomer(username,
                gender,
                address,
                email,
                passwd,
                phoneNum,
                openCheckingAccount,
                openSavingAccount);

        // add user into bank, should successfully add
        Assert.assertTrue(isSuccess);

        User user = bank.getUserByNameAndPasswd(username, passwd);
        // user should not be null because we add inside successfully
        Assert.assertNotNull(user);

        Customer customer = bankDatabase.getCustomerById(user.getUid());
        // we should retrieve customer from database
        Assert.assertNotNull(customer);
    }

    @Test
    public void btestPersistence() {
        // after doing testAddUser(), customer should be store in file
        List<Customer> allCustomers = bankDatabase.getAllCustomer();
        // allCustomers should not be empty
        Assert.assertFalse(allCustomers.isEmpty());
    }

    @Test
    public void ctestFirstOpenAccount() {
        List<Customer> allCustomers = bankDatabase.getAllCustomer();

        // this customer should not have saving or checking account now
        Customer customer = allCustomers.get(0);

        // should open checking account successfully
        ErrCode errCode = customer.openCheckingAccount();
        Assert.assertTrue(errCode.isSuccess);
    }

    @Test
    public void dtestSecondOpenAccount() {
        List<Customer> allCustomers = bankDatabase.getAllCustomer();

        // this customer should already have checking account, but not saving account
        Customer customer = allCustomers.get(0);

        // should fail to open checking account again
        ErrCode errCode = customer.openCheckingAccount();
        Assert.assertFalse(errCode.isSuccess);

        // should succeed to open saving account
        errCode = customer.openSavingAccount();
        Assert.assertTrue(errCode.isSuccess);
    }

    @Test
    public void etestDeposit() {
        
    }

    @Test
    public void ftestTransfer() {

    }

    @AfterClass
    public static void clearDatabase() {
        // delete file after test
        Bank.getInstance().getBankDatabase().clear();
    }
}
