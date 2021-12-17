package model.user;

import java.util.ArrayList;
import java.util.List;

import model.Bank;
import model.ErrCode;
import model.account.Account;
import model.account.AccountFactory;
import model.account.CheckingAccount;
import model.account.SavingAccount;
import model.account.SecurityAccount;
import model.currency.Currency;
import model.currency.CurrencyType;
import model.loan.Collateral;
import model.loan.CollateralFactory;
import model.loan.Loan;
import model.loan.LoanFactory;
import model.loan.LoanStatus;

public class Customer extends User {
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private SecurityAccount securityAccount;
    private List<Loan> loanList;

    Customer(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        loanList = new ArrayList<>();
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    /**
     * 
     * @return if already have checking account, return false. else return true.
     */
    public ErrCode openCheckingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        if (checkingAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "checking account already exist";
            return errCode;
        }
        checkingAccount = AccountFactory.getInstance().createCheckingAccount();
        checkingAccount.setUserId(this.getUid());

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @return if already have saving account, return false. else return true.
     */
    public ErrCode openSavingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        if (savingAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "saving account already exist";
            return errCode;
        }
        savingAccount = AccountFactory.getInstance().createSavingAccount();
        savingAccount.setUserId(this.getUid());

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @return if already have security account
     *         or do not have enough money in saving account, return false. else
     *         return true.
     */
    public ErrCode openSecurityAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        // security account already exist, cannot open
        if (securityAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "security account already exist";
            return errCode;
        }
        // no saving account, cannot open
        if (savingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have saving account yet. please open saving account first.";
            return errCode;
        }
        // do not have enough money in saving account, cannot open
        Currency dollars = savingAccount.getCurrencyByType(CurrencyType.DOLLAR);
        double leaseMoneyNeeded = 5000;
        if (dollars == null || dollars.getAmount() < leaseMoneyNeeded) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("do not have %.2f dollars in saving account", leaseMoneyNeeded);
            return errCode;
        }

        // sucessfully open security account
        securityAccount = AccountFactory.getInstance().createSecurityAccount();
        securityAccount.setUserId(this.getUid());

        // should immediately transfer 1000 dollars to this new security account
        double activateMoney = 1000;
        errCode = savingAccount.transferTo(securityAccount.getId(), activateMoney, CurrencyType.DOLLAR);
    

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public ErrCode closeCheckingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        // check whether has checking account
        if (checkingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have checking account, cannot close";
            return errCode;
        }
        // check whether deposit is 0
        List<CurrencyType> notZeroCurrencyType = getNotZeroCurrencyType(checkingAccount);
        if (!notZeroCurrencyType.isEmpty()) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("%s currency is not 0. please withdraw before close",
                    notZeroCurrencyType.get(0).getName());
            return errCode;
        }

        // close account
        checkingAccount.setClosed(true);
        checkingAccount = null;

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @return account can be closed only if the deposit of account is 0.
     */
    public ErrCode closeSavingAccount() {
        ErrCode errCode = new ErrCode(true, "success");
        // check whether has saving account
        if (savingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have saving account, cannot close";
            return errCode;
        }
        // check whether deposit is 0
        List<CurrencyType> notZeroCurrencyType = getNotZeroCurrencyType(savingAccount);
        if (!notZeroCurrencyType.isEmpty()) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("%s currency is not 0. please withdraw before close",
                    notZeroCurrencyType.get(0).getName());
            return errCode;
        }

        // check whether has security account
        // cannot close saving account if there is security account
        if (securityAccount != null) {
            errCode.isSuccess = false;
            errCode.errMsg = "there is security account. close security account before close saving accouint";
            return errCode;
        }

        // close account
        savingAccount.setClosed(true);
        savingAccount = null;

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @return security account can be closed only if:
     *         1. the deposit of account is 0;
     *         2. no more stock.
     */
    public ErrCode closeSecurityAccount() {
        // TODO:
        ErrCode errCode = new ErrCode(true, "success");
        // check whether there is security account
        if (securityAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have security account, cannot close";
            return errCode;
        }
        // check whether the deposit is 0
        List<CurrencyType> notZeroCurrencyType = getNotZeroCurrencyType(securityAccount);
        if (!notZeroCurrencyType.isEmpty()) {
            errCode.isSuccess = false;
            errCode.errMsg = String.format("%s currency is not 0. please withdraw before close",
                    notZeroCurrencyType.get(0).getName());
            return errCode;
        }

        // check whether there is stock not sell
        if(!securityAccount.getStockList().isEmpty()) {
            errCode.isSuccess = false;
            errCode.errMsg = "please sell all stocks before closing.";
            return errCode;
        }

        // close account
        securityAccount.setClosed(true);
        securityAccount = null;

        Bank.getInstance().getBankDatabase().update();
        return errCode;
    }

    /**
     * 
     * @param account account to check
     * @return given an account, return all currency types that the amount of
     *         specific currency amount is not 0
     */
    private List<CurrencyType> getNotZeroCurrencyType(Account account) {
        List<CurrencyType> res = new ArrayList<>();
        for (CurrencyType currencyType : account.getAllCurrencyType()) {
            if (account.getCurrencyByType(currencyType).getAmount() != 0) {
                res.add(currencyType);
            }
        }
        return res;
    }


    /**
     * 
     * @param loanAmount amount of money loan have
     * @param collateralPrice money that collateral worth
     * @param collateralName collateral name
     * @param currencyType money currency type
     */
    public ErrCode applyForLoan(double loanAmount, double collateralPrice, String collateralName, CurrencyType currencyType) {
        Collateral collateral = CollateralFactory.getInstance().createCollateral(collateralName, new Currency(currencyType, collateralPrice));
        return applyForLoan(loanAmount, currencyType, collateral);
    }

    /**
     * 
     * @param currency:   currency of loan
     * @param collateral: collateral of currency
     */
    public ErrCode applyForLoan(Currency currency, Collateral collateral) {
        return applyForLoan(currency.getAmount(), currency.getCurrencyType(), collateral);
    }

    /**
     * 
     * @param amount:       amount of currency
     * @param currencyType: type of currency
     * @param collateral:   collateral of currency
     */
    public ErrCode applyForLoan(double amount, CurrencyType currencyType, Collateral collateral) {
        ErrCode errCode = new ErrCode(true, "success");
        // check whether customer has checking account
        // only have checking account, then I can apply for loan
        if(checkingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have checking account, please open checking account first";
            return errCode;
        }
        Loan loan = LoanFactory.getInstance().createLoan(this.getUid(), amount, currencyType, collateral);
        // just add to list, do not add money now, because manager has not validate yet
        loanList.add(loan);
        // also add to manager requested loan list
        Bank.getInstance().getBankDatabase().getManager().addRequestedLoan(loan);

        Bank.getInstance().getBankDatabase().update();


        return errCode;
    }

    /**
     * 
     * @param loanId
     * @return if checking account does not have enough money, cannot redeem
     */
    public ErrCode repayLoan(int loanId) {
        Loan loan = Bank.getInstance().getBankDatabase().getLoanById(loanId);
        return repayLoan(loan);
    }

    /**
     * 
     * @param loan: the loan to be reedemd
     * @return if there are enough money in checking account, return true. else
     *         return false.
     */
    public ErrCode repayLoan(Loan loan) {
        ErrCode errCode = new ErrCode(true, "success");

        // check whether this loan is belong to this customer
        if(!loanList.contains(loan)) {
            errCode.isSuccess = false;
            errCode.errMsg = "this loan does not belong to this customer";
            return errCode;
        }

        // check whether have checking account or checking account has been closed
        // this should not happen!
        if(checkingAccount == null) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have checking account, this should not happen!";
            return errCode;
        }

        // check whether there are enough money in checking account
        Currency loanCurrency = loan.getLoanCurrency();
        if(checkingAccount.getCurrencyByType(loanCurrency.getCurrencyType()).getAmount() < loanCurrency.getAmount()) {
            errCode.isSuccess = false;
            errCode.errMsg = "do not have enough money in checing account";
            return errCode;
        }

        // repay this loan
        // minus money from account
        checkingAccount.getCurrencyByType(loanCurrency.getCurrencyType()).minus(loanCurrency);
        // remove current loan from manager activated loan list
        Bank.getInstance().getManager().removeActivatedLoan(loan);
        // change loan status
        loan.setLoanStatus(LoanStatus.LOAN_REPAYED);
        // remove from loan list
        loanList.remove(loan);

        
        Bank.getInstance().getBankDatabase().update();
        return errCode;
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