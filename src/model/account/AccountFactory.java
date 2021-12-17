package model.account;

import model.Bank;

/**
 * use factory pattern to create account. AccountFactory is a singleton
 */
public class AccountFactory{
    private static AccountFactory accountFactory;

    private AccountFactory() {

    }

    public static AccountFactory getInstance() {
        if(accountFactory == null) {
            accountFactory = new AccountFactory();
        }
        return accountFactory;
    }

    public CheckingAccount createCheckingAccount() {
        CheckingAccount checkingAccount = new CheckingAccount();
        Bank.getInstance().getBankDatabase().addAccount(checkingAccount);
        return checkingAccount;
    }

    public SavingAccount createSavingAccount() {
        SavingAccount savingAccount = new SavingAccount(Bank.SAVING_ACCOUNT_INTEREST);
        Bank.getInstance().getBankDatabase().addAccount(savingAccount);
        return savingAccount;
    }

    public SecurityAccount createSecurityAccount() {
        SecurityAccount securityAccount = new SecurityAccount();
        Bank.getInstance().getBankDatabase().addAccount(securityAccount);
        return securityAccount;
    }

    public ManagerAccount createManagerAccount() {
        ManagerAccount managerAccount = new ManagerAccount();
        return managerAccount;
    }
}