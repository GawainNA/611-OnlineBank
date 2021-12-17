package controller;

import model.Bank;
import model.ErrCode;
import model.account.Account;
import model.currency.CurrencyType;
import view.Transfer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferController {
    Account account;
    Transfer transferView;
    Bank bank;

    TransferController(Bank bank,Account account, Transfer transfer){
        this.account = account;
        this.transferView = transfer;
        this.bank = bank;

        transfer.addConfirmListener(new ConfirmListener());
        transfer.addCancelListener(new CancelListener());
    }

    class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String toId = transferView.getToId();
            String amount = transferView.getAmount();
            String type = transferView.getCurrency();
            ErrCode errCode = account.transferTo(Integer.parseInt(toId),Double.parseDouble(amount), CurrencyType.str2CurrencyType(type));
            transferView.showMessage(errCode.errMsg);
        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            transferView.close();
        }
    }
}
