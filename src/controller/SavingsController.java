package controller;

import model.account.SavingAccount;
import view.Savings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavingsController {
    SavingAccount savingAccount;
    Savings savingsView;

    SavingsController(SavingAccount savingAccount, Savings savingsView){
        this.savingAccount = savingAccount;
        this.savingsView = savingsView;

        savingsView.addTransferListener(new TransferListener());
        savingsView.addCloseAccountListener(new CloseAccountListener());
        savingsView.addDepositListener(new DepositListener());
        savingsView.addWithdrawListener(new WithdrawListener());
        savingsView.addBackListener(new BackListener());
    }


    class TransferListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class CloseAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class DepositListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class WithdrawListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
