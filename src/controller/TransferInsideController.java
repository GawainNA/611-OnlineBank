package controller;

import view.Transfer;
import view.TransferInside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.account.database.BankDatabaseByDisk;

public class TransferInsideController {
    BankDatabaseByDisk database;
    Transfer transfer;

    TransferInsideController(BankDatabaseByDisk database, Transfer transfer){
        this.database = database;
        this.transfer = transfer;

        transfer.addConfirmListener(new ConfirmListener());
        transfer.addCancelListener(new CancelListener());
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
