package controller;

import model.user.User;
import view.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TransactionController {
    User user;
    Transaction transactionView;

    TransactionController(User user, Transaction transactionView){
        this.user = user;
        this.transactionView = transactionView;

        transactionView.addBackListener(new BackListener());

        refreshInfo();
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            transactionView.dispose();
        }
    }
    private void refreshInfo(){
        List<model.Transaction> logs = user.getTransactionList();

        String logInfo = "";

        for (model.Transaction i : logs){
            logInfo = logInfo.concat(i.getTimestampFormat()+"  "+i.getDesc()+"\n");
        }

        transactionView.setLog(logInfo);
    }
}
