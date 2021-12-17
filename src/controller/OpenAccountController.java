package controller;

import model.ErrCode;
import model.user.Customer;
import view.OpenAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAccountController {
    Customer customer;
    OpenAccount openAccountView;

    OpenAccountController(Customer customer,OpenAccount openAccountView){
        this.customer = customer;
        this.openAccountView = openAccountView;

        openAccountView.addCancelListener(new CancelListener());
        openAccountView.addOpenListener(new OpenListener());
    }

    class OpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(openAccountView.isCheckingSelected()){
                ErrCode errCode = customer.openCheckingAccount();
                openAccountView.showMessage(errCode.errMsg);
            }else if(openAccountView.isSavingSelected()){
                ErrCode errCode = customer.openSavingAccount();
                openAccountView.showMessage(errCode.errMsg);
            }else if(openAccountView.isSecuritySelected()){
                ErrCode errCode = customer.openSecurityAccount();
                openAccountView.showMessage(errCode.errMsg);
            }else {
                openAccountView.showMessage("Please Select One Account!");
            }
        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            openAccountView.dispose();
        }
    }
}
