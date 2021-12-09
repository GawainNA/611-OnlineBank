package model.user;

import java.util.Currency;
import java.util.List;

import model.Collateral;
import model.Loan;
import model.account.CheckingAccount;
import model.account.SavingAccount;
import model.account.SecurityAccount;
import model.currency.CurrencyType;

public class Customer extends User{
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private SecurityAccount securityAccount;
    private List<Loan> loanList;

    
    Customer(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        //TODO Auto-generated constructor stub
    }

    

    

    /**
     * 
     * @return if already have checking account, return false. else return true.
     */
    public boolean openCheckingAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @return if already have saving account, return false. else return true.
     */
    public boolean openSavingAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @return if already have security account 
     *          or do not have enough money in saving account, return false. else return true.
     */
    public boolean openSecurityAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public boolean closeCheckingAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public boolean closeSavingAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @return security account can be closed only if: 
     *  1. the deposit of account is 0;
     *  2. no more stock.
     */
    public boolean closeSecurityAccount() {
        // TODO:

        return true;
    }

    /**
     * 
     * @param currency: currency of loan
     * @param collateral: collateral of currency
     */
    public void applyForLoan(Currency currency, Collateral collateral) {
        // TODO:

    }
    
    /**
     * 
     * @param amount: amount of currency
     * @param currencyType: type of currency
     * @param collateral: collateral of currency
     */
    public void applyForLoan(double amount, CurrencyType currencyType, Collateral collateral) {
        // TODO:

    }

    /**
     * 
     * @param loan: the loan to be reedemd
     * @return if there are enough money in checking account, return true. else return false.
     */
    public boolean redeemLoan(Loan loan) {
        // TODO:

        return true;
    }

    /***************** getter *********************/
    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public SecurityAccount getSecurityAccount() {
        return securityAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }
    
}