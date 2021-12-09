package controller;

import model.*;
import model.user.UserGender;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUPController {
    Bank bank;
    SignUP signUP;

    SignUPController(Bank bank, SignUP signUP){
        this.bank = bank;
        this.signUP = signUP;

        signUP.addConfirmListener(new SignUPActionListener());
    }

    class SignUPActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isSuccess = bank.addCustomer(signUP.getName(),
                    UserGender.Str2UserGender(signUP.getGender()),
                    signUP.getAddress(),
                    signUP.getEmail(),
                    signUP.getPassword(),
                    signUP.getPhoneNum(),
                    signUP.isOpenChecking(),
                    signUP.isOpenSavings());

            if (isSuccess){
                signUP.showMessage("Sign UP Successfully");
                signUP.close();
            }else {
                signUP.showMessage("Unsuccessful! Please check every input info.");
            }
        }
    }

}
