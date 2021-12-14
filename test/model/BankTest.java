package model;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.account.CheckingAccount;
import model.account.SavingAccount;
import model.currency.Currency;
import model.currency.CurrencyType;
import model.database.BankDatabase;
import model.database.BankDatabaseByDisk;
import model.user.Customer;
import model.user.User;
import model.user.UserGender;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankTest {
    private static Bank bank;
    private static BankDatabase bankDatabase;

    private String username = "test1";
    private UserGender gender = UserGender.FEMALE;
    private String address = "address1";
    private String email = "email1";
    private String passwd = "passwd1";
    private String phoneNum = "123";
    private boolean openCheckingAccount = false;
    private boolean openSavingAccount = false;
    private static boolean readFromStorage;

    @BeforeClass
    public static void init() {
        bank = Bank.getInstance();
        bankDatabase = bank.getBankDatabase();
        File f = new File(BankDatabaseByDisk.STORAGE_FILEPATH);
        readFromStorage = f.exists();
    }

    @Test
    public void atestAddUser() {

        boolean isSuccess = bank.addCustomer(username,
                gender,
                address,
                email,
                passwd,
                phoneNum,
                openCheckingAccount,
                openSavingAccount);

        if (!readFromStorage) {
            // add user into a new bank, should successfully add
            Assert.assertTrue(isSuccess);
        } else {
            // should already have record, can not add
            Assert.assertFalse(isSuccess);
        }

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
        if (!readFromStorage) {
            Assert.assertTrue(errCode.isSuccess);
        } else {
            // read from storage, then should already have checking account
            Assert.assertFalse(errCode.isSuccess);
        }
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
        if (!readFromStorage) {
            Assert.assertTrue(errCode.isSuccess);
        } else {
            // read from storage, then should already have checking account
            Assert.assertFalse(errCode.isSuccess);
        }
    }

    @Test
    public void etestDeposit() {
        List<Customer> customers = bankDatabase.getAllCustomer();

        // this customer should have empty checking account and saving account
        Customer customer = customers.get(0);
        Assert.assertNotNull(customer.getCheckingAccount());
        Assert.assertNotNull(customer.getSavingAccount());

        CheckingAccount checkingAccount = customer.getCheckingAccount();
        SavingAccount savingAccount = customer.getSavingAccount();

        // save 50 dollars into checking accoun
        checkingAccount.deposit(50, CurrencyType.DOLLAR);
        // try to withdraw 60 dollars, should fail
        ErrCode errCode = checkingAccount.withdraw(60, CurrencyType.DOLLAR);
        Assert.assertFalse(errCode.isSuccess);
        // try to withdraw 30 dollars, should success
        errCode = checkingAccount.withdraw(30, CurrencyType.DOLLAR);
        Assert.assertTrue(errCode.isSuccess);

        // now checking account should have 20 dollars
    }

    @Test
    public void ftestTransfer() {
        // this customer should have checking account and saving accont,
        // also have 20 dollars in checking account now
        Customer customer = bankDatabase.getAllCustomer().get(0);
        CheckingAccount checkingAccount = customer.getCheckingAccount();
        SavingAccount savingAccount = customer.getSavingAccount();
        Assert.assertEquals(20, (int) checkingAccount.getCurrencyByType(CurrencyType.DOLLAR).getAmount());

        // try to transfer 20 CNY to saving account
        // should fail, because checking account do not have CNY
        ErrCode errCode = checkingAccount.transferTo(savingAccount.getId(), 20, CurrencyType.CNY);
        Assert.assertFalse(errCode.isSuccess);

        // try to transfer 30 dollars to saving account
        // should fail, because do not have enough money
        errCode = checkingAccount.transferTo(savingAccount.getId(), 30, CurrencyType.DOLLAR);
        Assert.assertFalse(errCode.isSuccess);

        // try to transfer 20 dollars to saving account
        // should success
        errCode = checkingAccount.transferTo(savingAccount.getId(), 20, CurrencyType.DOLLAR);
        Assert.assertTrue(errCode.isSuccess);

        // now saving account should have 20 dollars
        Currency savingAccountDollars = savingAccount.getCurrencyByType(CurrencyType.DOLLAR);
        Assert.assertNotNull(savingAccountDollars);
        Assert.assertEquals(20, (int) savingAccountDollars.getAmount());

        // withdraw 20 dollars from saving account
        // should success
        errCode = savingAccount.withdraw(20, CurrencyType.DOLLAR);
        Assert.assertTrue(errCode.isSuccess);

        // now checking account and saving account do not have money
    }

    @AfterClass
    public static void clearDatabase() {
        // delete file after test
        Bank.getInstance().getBankDatabase().clear();
    }
}
