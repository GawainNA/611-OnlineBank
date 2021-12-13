package controller;

import view.Transfer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.database.BankDatabaseByDisk;

public class TransferController {
    BankDatabaseByDisk database;
    Transfer transfer;

    TransferController(BankDatabaseByDisk database, Transfer transfer){
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
