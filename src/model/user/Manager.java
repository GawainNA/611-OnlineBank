package model.user;

import java.util.ArrayList;
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
        activatedLoan = new ArrayList<>();
        requestedLoan = new ArrayList<>();
    }

    public static Manager getInstance() {
        if(manager == null) {
            String managerName = "admin";
            UserGender managerGender = UserGender.FEMALE;
            String passwd = "admin";
            String address = "Boston University, Boston USA";
            String phoneNum = "(123)456-7890";
            manager = new Manager(managerName, managerGender, passwd, address, phoneNum);
        }
        return manager;
    }

    public void handleRequestedLoan(int loanId, boolean accept) {
        // TODO:
    }

    public List<Loan> getActivatedLoan() {
        return activatedLoan;
    }

    public void setActivatedLoan(List<Loan> activatedLoan) {
        this.activatedLoan = activatedLoan;
    }

    public List<Loan> getRequestedLoan() {
        return requestedLoan;
    }

    public void setRequestedLoan(List<Loan> requestedLoan) {
        this.requestedLoan = requestedLoan;
    }

    public void addRequestedLoan(Loan loan) {
        requestedLoan.add(loan);
    }

    public void addActivatedLoan(Loan loan) {
        activatedLoan.add(loan);
    }

}