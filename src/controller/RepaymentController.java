package controller;

import model.Bank;
import view.Repayment;
import view.RequestLoan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepaymentController {
    Bank bank;
    Repayment repaymentView;

    RepaymentController(Bank bank, Repayment repaymentView){
        this.bank = bank;
        this.repaymentView = repaymentView;

        repaymentView.addCancelListener(new CancelListener());
        repaymentView.addConfirmListener(new ConfirmListener());
    }

    class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
