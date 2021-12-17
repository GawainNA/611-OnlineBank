package controller;

import model.*;
import model.account.CheckingAccount;
import model.account.SavingAccount;
import model.account.SecurityAccount;
import model.user.*;
import view.*;
import view.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainController {
    Bank bank;
    Customer customer;
    CustomerMain customerMain;

    CustomerMainController(Bank bank,Customer customer,CustomerMain customerMain){
        this.bank = bank;
        this.customer = customer;
        this.customerMain = customerMain;

        customerMain.addCheckingListener(new CheckingActionLister());
        customerMain.addSavingsListener(new SavingsActionListener());
        customerMain.addSecurityListener(new SecurityActionListener());
        customerMain.addLoanListener(new LoanListener());
        customerMain.addTransactionListener(new TransactionListener());
        customerMain.addOpenAccountListener(new OpenAccountListener());
        customerMain.addSignOutListener(new SignOutListener());
    }

    class CheckingActionLister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(customer.getCheckingAccount()==null){
                customerMain.showMessage("You don't have Checking Account!");
            }else {
                Checking checkingView = new Checking(String.valueOf(customer.getCheckingAccount().getId()));
                CheckingAccount checkingAccount = customer.getCheckingAccount();
                CheckingController controller = new CheckingController(bank,customer,checkingAccount,checkingView);
                checkingView.showFrame();
            }
        }
    }

    class SavingsActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(customer.getSavingAccount()==null){
                customerMain.showMessage("You don't have Savings Account!");
            }else {
                SavingAccount savingAccount = customer.getSavingAccount();
                Savings savingsView = new Savings(String.valueOf(customer.getSavingAccount().getId()));
                SavingsController controller = new SavingsController(bank,customer,savingAccount,savingsView);
                savingsView.showFrame();
            }

        }
    }

    class SecurityActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(customer.getSecurityAccount()==null){
                customerMain.showMessage("You don't have Security Account!");
            }else {
                SecurityAccount securityAccount = customer.getSecurityAccount();
                Security securityView = new Security(String.valueOf(customer.getSecurityAccount().getId()));
                SecurityController controller = new SecurityController(bank,customer,securityAccount,securityView);
                securityView.showFrame();
            }

        }
    }

    class OpenAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OpenAccount openAccountView = new OpenAccount();
            OpenAccountController controller = new OpenAccountController(customer,openAccountView);
            openAccountView.setVisible(true);
        }
    }

    class LoanListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Loan loanView = new Loan();
            LoanController controller = new LoanController(bank,customer,loanView);
            loanView.setVisible(true);
        }
    }

    class TransactionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Transaction transactionView = new Transaction();
            TransactionController controller = new TransactionController(customer,transactionView);
            transactionView.setVisible(true);
        }
    }

    class SignOutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Sign sign = new Sign();
            Bank bank = Bank.getInstance();

            SignInController sample = new SignInController(bank,sign);
            sign.showFrame();
            customerMain.close();
        }
    }

}
