package controller;
import model.*;
import model.user.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SampleController {
    Bank bank;
    Sign sign;

    public SampleController(Bank bank, Sign sign){
        this.bank=bank;
        this.sign=sign;

        sign.addSignListener(new SignListener());
        sign.addSignUpListener(new SignUPListener());
    }

    class SignListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = bank.getUserByNameAndPasswd(sign.getUsername(), sign.getPassword());
            if(user == null){
                sign.showMessage("Cannot finder this user!");
            }else if (user instanceof Customer){
                sign.openCustomerMain();
            }else {
                sign.openManagerMain();
            }
        }
    }

    class SignUPListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SignUP signUP = new SignUP();
            SignUPController suController = new SignUPController(bank,signUP);
            signUP.showFrame();
        }
    }
}
