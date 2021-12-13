package model;

import org.junit.Assert;
import org.junit.Test;

import model.Bank;
import model.database.BankDatabase;
import model.user.Customer;
import model.user.User;
import model.user.UserGender;

public class BankTest {
    private Bank bank = Bank.getInstance();

    private String username = "test1";
    private UserGender gender = UserGender.FEMALE;
    private String address = "address1";
    private String email = "email1";
    private String passwd = "passwd1";
    private String phoneNum = "123";
    private boolean openCheckingAccount = false;
    private boolean openSavingAccount = false;

    @Test
    public void addUser() {
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

        Customer customer = bank.getBankDatabase().getCustomerById(user.getUid());
        // we should retrieve customer from database
        Assert.assertNotNull(customer);
    }

    
}   
