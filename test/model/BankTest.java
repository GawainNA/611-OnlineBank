package model;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
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
import model.loan.Loan;
import model.loan.LoanStatus;
import model.user.Customer;
import model.user.Manager;
import model.user.User;
import model.user.UserGender;

/**
 * WARNING: please run all unit tests together every time. DO NOT run each unit
 * seperately.
 */
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

    @Test
    public void gtestCloseAccount() {
        // this customer should have saving account and checking account
        // with no money inside
        Customer customer = bankDatabase.getAllCustomer().get(0);

        CheckingAccount checkingAccount = customer.getCheckingAccount();
        SavingAccount savingAccount = customer.getSavingAccount();

        // deposit 20 dollars into checking account
        checkingAccount.deposit(20, CurrencyType.DOLLAR);
        // then try to close checking account, should fail
        ErrCode errCode = customer.closeCheckingAccount();
        Assert.assertFalse(errCode.isSuccess);

        // withdraw 20 dollars from checking account, should success
        errCode = checkingAccount.withdraw(20, CurrencyType.DOLLAR);
        Assert.assertTrue(errCode.isSuccess);
        // then try to close checking account, should success
        errCode = customer.closeCheckingAccount();
        Assert.assertTrue(errCode.isSuccess);

        // deposit 20 dollars to saving account
        savingAccount.deposit(20, CurrencyType.DOLLAR);
        // try to transfer to checking account, should fail because checking account
        // already close
        errCode = savingAccount.transferTo(checkingAccount.getId(), 20, CurrencyType.DOLLAR);
        Assert.assertFalse(errCode.isSuccess);
        // withdraw money, should success
        errCode = savingAccount.withdraw(20, CurrencyType.DOLLAR);
        Assert.assertTrue(errCode.isSuccess);

        // reopen checking account, should success
        errCode = customer.openCheckingAccount();
        Assert.assertTrue(errCode.isSuccess);
    }

    @Test
    public void htestLoan() {
        // this customer should have saving account and checking account
        // with no money inside
        Customer customer = bankDatabase.getAllCustomer().get(0);
        Manager manager = bankDatabase.getManager();
        
        double loanAmount = 20;
        double collateralPrice = 30;
        String collateralName = "Book";
        CurrencyType currencyType = CurrencyType.DOLLAR;
        // apply for loan, should success
        ErrCode errCode = customer.applyForLoan(loanAmount, collateralPrice, collateralName, currencyType);
        Assert.assertTrue(errCode.isSuccess);
        // loan list of customer should not be empty
        Assert.assertFalse(customer.getLoanList().isEmpty());
        // loan status should be pending
        Loan loan = customer.getLoanList().get(0);
        Assert.assertEquals(LoanStatus.LOAN_PENDING, loan.getLoanStatus());
        // because manger has not agree this loan, checking account should be 0 dollar or do not have this currency type
        Currency depositCurrency = customer.getCheckingAccount().getCurrencyByType(currencyType);
        if(depositCurrency != null) {
            int depositAmount = (int)depositCurrency.getAmount();
            Assert.assertEquals(0, depositAmount);
        }


        // manager requested list should not be empty
        Assert.assertFalse(manager.getRequestedLoanList().isEmpty());
        // manager handle this requsted, should success
        errCode = manager.handleRequestedLoan(loan.getUid(), true);
        Assert.assertTrue(errCode.isSuccess);
        // activated loan list should not be empty, requested list should be empty
        Assert.assertFalse(manager.getActivatedLoanList().isEmpty());
        Assert.assertTrue(manager.getRequestedLoanList().isEmpty());
        

        // now check customer checking accout, should have loan money
        int depositAmount = (int)customer.getCheckingAccount().getCurrencyByType(currencyType).getAmount();
        Assert.assertEquals((int)loanAmount, depositAmount);


        // now try to repay loan, should success
        errCode = customer.repayLoan(loan.getUid());
        Assert.assertTrue(errCode.isSuccess);
        // loan status should be REPAY
        Assert.assertEquals(LoanStatus.LOAN_REPAYED, loan.getLoanStatus());
        // checking account should be empty
        depositAmount = (int)customer.getCheckingAccount().getCurrencyByType(currencyType).getAmount();
        Assert.assertEquals(0, depositAmount);
        // customer loan list should be empty
        Assert.assertTrue(customer.getLoanList().isEmpty());
        // manager activated list should be empty
        Assert.assertTrue(manager.getActivatedLoanList().isEmpty());
    }

    @AfterClass
    public static void clearDatabase() {
        // delete file after test
        Bank.getInstance().getBankDatabase().clear();
    }
}
