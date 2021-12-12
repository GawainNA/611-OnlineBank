package controller;

import model.*;
import model.account.CheckingAccount;
import model.user.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainController {

    Customer customer;
    CustomerMain customerMain;

    CustomerMainController(Customer customer,CustomerMain customerMain){
        this.customer = customer;
        this.customerMain = customerMain;

        customerMain.addCheckingListener(new CheckingActionLister());
        customerMain.addSavingsListener(new SavingsActionListener());
        customerMain.addSecurityListener(new SecurityActionListener());
        customerMain.addLoanListener(new LoanListener());
        customerMain.addTransactionListener(new TranscationListener());
        customerMain.addOpenAccountListener(new OpenAccountListener());
        customerMain.addSignOutListener(new SignOutListener());
    }

    class CheckingActionLister implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            Checking checkingView = new Checking(customer.getCheckingAccount().getID());
            CheckingAccount checkingAccount = customer.getCheckingAccount();
            CheckingController controller = new CheckingController(checkingAccount,checkingView);
            checkingView.showFrame();
             */
        }
    }

    class SavingsActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SecurityActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class OpenAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class LoanListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class TranscationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SignOutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
