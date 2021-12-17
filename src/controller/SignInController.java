package controller;
import model.*;
import model.user.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignInController {
    Bank bank;
    Sign sign;
    //test
    public SignInController(Bank bank, Sign sign){
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
            }else if (user instanceof Customer customer){
                //Open CustomerMain
                CustomerMain customerMain = new CustomerMain(customer.getUsername(),String.valueOf(customer.getUid()));
                CustomerMainController customerMainController = new CustomerMainController(bank,customer,customerMain);
                customerMain.showFrame();
                sign.close();
            }else {
                //open ManagerMain
                Manager manager = (Manager) user;
                ManagerMain managerMain = new ManagerMain(String.valueOf(user.getUid()));
                ManagerMainController controller = new ManagerMainController(bank,manager,managerMain);
                managerMain.setVisible(true);
                sign.close();
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
