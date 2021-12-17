package controller;

import model.ErrCode;
import model.account.SecurityAccount;
import model.currency.CurrencyType;
import model.user.Customer;
import view.Security;
import view.Transfer;
import view.TransferInside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.database.BankDatabaseByDisk;

public class TransferInsideController {
    Customer customer;
    SecurityAccount securityAccount;
    TransferInside transferView;

    TransferInsideController(Customer customer, SecurityAccount securityAccount,TransferInside transferView){
        this.customer = customer;
        this.securityAccount = securityAccount;
        this.transferView = transferView;

        transferView.addConfirmListener(new ConfirmListener());
        transferView.addCancelListener(new CancelListener());
    }

    class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(transferView.isCheckingSelected()){
                String amount = transferView.getAmount();
                String ctype = transferView.getCurrency();
                ErrCode errCode = securityAccount.transferTo(customer.getCheckingAccount().getId(),Double.parseDouble(amount), CurrencyType.str2CurrencyType(ctype));
                transferView.showMessage(errCode.errMsg);
            }else if (transferView.isSavingSelected()){
                String amount = transferView.getAmount();
                String ctype = transferView.getCurrency();
                ErrCode errCode = securityAccount.transferTo(customer.getSavingAccount().getId(),Double.parseDouble(amount), CurrencyType.str2CurrencyType(ctype));
                transferView.showMessage(errCode.errMsg);
            }else {
                transferView.showMessage("Please select one Account");
            }
        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            transferView.dispose();
        }
    }
}
