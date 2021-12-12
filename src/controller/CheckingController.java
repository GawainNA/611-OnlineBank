package controller;

import model.account.CheckingAccount;
import view.Checking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckingController {
    Checking checkingView;
    CheckingAccount checkingAccount;

    CheckingController(CheckingAccount checkingAccount,Checking checkingView){
        this.checkingAccount = checkingAccount;
        this.checkingView = checkingView;

        checkingView.addTransferListener(new TransferListener());
        checkingView.addCloseAccountListener(new CloseAccountListener());
        checkingView.addDepositListener(new DepositListener());
        checkingView.addWithdrawListener(new WithdrawListener());
        checkingView.addBackListener(new BackListener());
    }

    /*
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBack;
	 */

    class TransferListener implements ActionListener{

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
