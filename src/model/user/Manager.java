package model.user;

import java.util.ArrayList;
import java.util.List;

import model.Bank;
import model.ErrCode;
import model.account.AccountFactory;
import model.account.ManagerAccount;
import model.loan.Loan;
import model.loan.LoanStatus;

/**
 * Singleton (only one manager)
 */
public class Manager extends User {
    private static Manager manager;

    private List<Loan> activatedLoanList;
    private List<Loan> requestedLoanList;
    private ManagerAccount managerAccount;

    private Manager(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        activatedLoanList = new ArrayList<>();
        requestedLoanList = new ArrayList<>();
        managerAccount = AccountFactory.getInstance().createManagerAccount();
    }

    public static Manager getInstance() {
        if (manager == null) {
            String managerName = "admin";
            UserGender managerGender = UserGender.FEMALE;
            String passwd = "admin";
            String address = "Boston University, Boston USA";
            String phoneNum = "(123)456-7890";
            manager = new Manager(managerName, managerGender, passwd, address, phoneNum);
        }
        return manager;
    }

    public ErrCode handleRequestedLoan(int loanId, boolean accept) {
        // TODO:
        ErrCode errCode = new ErrCode(true, "success");
        Loan loan = Bank.getInstance().getBankDatabase().getLoanById(loanId);
        // check whether this loan is in requestedLoan
        if (!requestedLoanList.contains(loan)) {
            errCode.isSuccess = false;
            errCode.errMsg = "this loan id does not exist in requested list, please check again";
            return errCode;
        }

        // if not accept, change loan status
        if (!accept) {
            loan.setLoanStatus(LoanStatus.LOAN_REFUSED);
        } else {
            // if accept, change loan status, add to activated loan list
            loan.setLoanStatus(LoanStatus.LOAN_AGREED);
            addActivatedLoan(loan);

            // add money to checking account of the customer who apply the loan
            Customer customer = Bank.getInstance().getBankDatabase().getCustomerById(loan.getCustomerId());
            errCode = managerAccount.transferTo(customer.getCheckingAccount().getId(), loan.getLoanCurrency());
        }

        // remove from requested loan list
        removeRequestedLoan(loan);
        return errCode;
    }

    public List<Loan> getActivatedLoanList() {
        return activatedLoanList;
    }

    public List<Loan> getRequestedLoanList() {
        return requestedLoanList;
    }

    public void addRequestedLoan(Loan loan) {
        requestedLoanList.add(loan);
        Bank.getInstance().getBankDatabase().update();
    }

    private void addActivatedLoan(Loan loan) {
        activatedLoanList.add(loan);
        Bank.getInstance().getBankDatabase().update();
    }

    public void removeActivatedLoan(Loan loan) {
        activatedLoanList.remove(loan);
        Bank.getInstance().getBankDatabase().update();
    }

    public void removeRequestedLoan(Loan loan) {
        requestedLoanList.remove(loan);
        Bank.getInstance().getBankDatabase().update();
    }

    public ManagerAccount getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(ManagerAccount managerAccount) {
        this.managerAccount = managerAccount;
    }

}