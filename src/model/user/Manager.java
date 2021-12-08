package model.user;

import java.util.List;

import model.Loan;

/** 
 * Singleton (only one manager)
 */
public class Manager extends User{
    private static Manager manager;

    private List<Loan> activatedLoan;
    private List<Loan> requestedLoan;

    private Manager(String username, UserGender gender, String passwd, String address, String phoneNum) {
        super(username, gender, passwd, address, phoneNum);
        //TODO Auto-generated constructor stub
    }

    public static Manager getInstance() {
        // TODO:

        return null;
    }

    // view all transaction logs
    public String viewTransactionLogs() {
        // TODO: whether should return String???
        return "";
    }

    public void handleRequestedLoan(int loanId, boolean accept) {
        // TODO:
    }

}