package loan;


import model.Persistable;
import model.currency.Currency;
import model.currency.CurrencyType;
import util.IdCreator;

public class Loan implements Persistable{
    private int uid;
    private int customerId;
    private Currency loanCurrency;
    private Collateral collateral;
    private LoanStatus loanStatus;

    public Loan(int customerId, double loanAmount, CurrencyType currencyType, Collateral collateral) {
        this.uid = IdCreator.createRandomInt();
        this.customerId = customerId;
        this.collateral = collateral;
        this.loanCurrency = new Currency(currencyType, loanAmount);
        this.loanStatus = LoanStatus.LOAN_PENDING;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Loan(int customerId, Currency loanPrice, Collateral collateral) {
        this(customerId, loanPrice.getAmount(), loanPrice.getCurrencyType(), collateral);
    }

    public int getUid() {
        return uid;
    }

    public Currency getLoanCurrency() {
        return loanCurrency;
    }

    public void setLoanPrice(Currency loanPrice) {
        this.loanCurrency = loanPrice;
    }

    public Collateral getCollateral() {
        return collateral;
    }

    public void setCollateral(Collateral collateral) {
        this.collateral = collateral;
    }


}
