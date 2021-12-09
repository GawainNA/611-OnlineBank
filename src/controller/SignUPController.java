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


    }

    class SignUPActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserGender()
            bank.addCustomer(signUP.getName(), UserGender.signUP.getGender(),signUP.getAddress(), signUP.getEmail(), signUP.getPassword(), signUP.isOpenChecking(), signUP.isOpenSavings();
        }
    }

}
