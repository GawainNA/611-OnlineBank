package model.user;

import java.util.ArrayList;
import java.util.List;

import model.Collateral;
import model.ErrCode;
import model.Loan;
import model.account.AccountFactory;
import model.account.CheckingAccount;
import model.account.SavingAccount;
import model.account.SecurityAccount;
import model.currency.Currency;
import model.currency.CurrencyType;

public class Customer extends User{
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private SecurityAccount securityAccount;
    private List<Loan> loanList;

    
    Customer(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        loanList = new ArrayList<>();
    }

    
    /**
     * 
     * @return if already have checking account, return false. else return true.
     */
    public ErrCode openCheckingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        if(checkingAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "checking account already exist";
            return errCode;
        }
        checkingAccount = AccountFactory.getInstance().createCheckingAccount();
        return errCode;
    }

    /**
     * 
     * @return if already have saving account, return false. else return true.
     */
    public ErrCode openSavingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        if(savingAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "saving account already exist";
            return errCode;
        }
        savingAccount = AccountFactory.getInstance().createSavingAccount();
        return errCode;
    }

    /**
     * 
     * @return if already have security account 
     *          or do not have enough money in saving account, return false. else return true.
     */
    public ErrCode openSecurityAccount() {
        // TODO:
        ErrCode errCode = new ErrCode(true, "success");
        // security account already exist, cannot open
        if(securityAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "security account already exist";
            return errCode;
        }
        // no saving account, cannot open
        if(savingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have saving account yet. please open saving account first.";
            return errCode;
        }
        // do not have enough money in saving account, cannot open
        Currency dollars = savingAccount.getCurrencyByType(CurrencyType.DOLLAR);
        double leaseMoneyNeeded = 5000;
        if(dollars == null || dollars.getAmount() < leaseMoneyNeeded) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("do not have %.2f dollars in saving account", leaseMoneyNeeded);
            return errCode;
        }

        // sucessfully open security account
        securityAccount = AccountFactory.getInstance().createSecurityAccount();
        return errCode;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public ErrCode closeCheckingAccount() {
        // TODO:

        return null;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public ErrCode closeSavingAccount() {
        // TODO:
        
        return null;
    }

    /**
     * 
     * @return security account can be closed only if: 
     *  1. the deposit of account is 0;
     *  2. no more stock.
     */
    public ErrCode closeSecurityAccount() {
        // TODO:

        return null;
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
    public ErrCode redeemLoan(Loan loan, double amount) {
        // TODO:

        return null;
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