package controller;

import model.Bank;
import model.user.Manager;
import view.ManageLoan;
import view.ManagerMain;
import view.Sign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMainController {
    Manager manager;
    ManagerMain managerMain;
    Bank bank;

    ManagerMainController(Bank bank,Manager manager, ManagerMain managerMain){
        this.manager = manager;
        this.managerMain = managerMain;
        this.bank = bank;

        managerMain.addLogListener(new LogListener());
        managerMain.addManageStockListener(new ManageStockListener());
        managerMain.addLoanListener(new LoanListener());
        managerMain.addSignOutListener(new SignOutListener());
    }
/*
    JButton btnLog;
    JButton btnLoan;
    JButton btnManageStocks;
    JButton btnSignOut;

 */

    class LogListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class LoanListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ManageLoan manageLoanView = new ManageLoan();
            ManageLoanController controller = new ManageLoanController(bank,manager,manageLoanView);
            manageLoanView.setVisible(true);
        }
    }

    class ManageStockListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SignOutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Sign sign = new Sign();
            Bank bank = Bank.getInstance();

            SignInController sample = new SignInController(bank,sign);
            sign.showFrame();
            managerMain.dispose();
        }
    }
}
