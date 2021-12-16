package loan;

import model.Bank;
import model.currency.CurrencyType;

/**
 * LoanFactory to create loan
 * Singleton
 */
public class LoanFactory {
    private static LoanFactory loanFactory;

    private LoanFactory() {

    }

    public static LoanFactory getInstance() {
        if(loanFactory == null) {
            loanFactory = new LoanFactory();
        }
        return loanFactory;
    }

    public Loan createLoan(int customerId, double loanAmount, CurrencyType currencyType, Collateral collateral) {
        Loan loan = new Loan(customerId, loanAmount, currencyType, collateral);
        Bank.getInstance().getBankDatabase().addLoan(loan);
        return loan;
    }
    
}
