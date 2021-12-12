package controller;

import model.user.Manager;
import view.ManagerMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMainController {
    Manager manager;
    ManagerMain managerMain;

    ManagerMainController(Manager manager, ManagerMain managerMain){
        this.manager = manager;
        this.managerMain = managerMain;

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

        }
    }
}
