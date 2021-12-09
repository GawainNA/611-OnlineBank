package model.account;

/**
 * use factory pattern to create account. AccountFactory is a singleton
 */
public class AccountFactory {
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
        // TODO:
        return null;
    }

    public SavingAccount createSavingAccount() {
        // TODO:
        return null;
    }

    public SecurityAccount createSecurityAccount() {
        // TODO:
        return null;
    }
}