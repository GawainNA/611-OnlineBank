package controller;

import model.Bank;
import model.account.SecurityAccount;
import view.Security;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecurityController {
    SecurityAccount securityAccount;
    Security securityView;
    Bank bank;

    SecurityController(Bank bank,SecurityAccount securityAccount, Security securityView){
        this.securityAccount = securityAccount;
        this.securityView = securityView;
        this.bank = bank;

        securityView.addTransferListener(new TransferListener());
        securityView.addCloseAccountListener(new CloseAccountListener());
        securityView.addStockListener(new StockListener());
        securityView.addBackListener(new BackListener());
    }

    class TransferListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class CloseAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class StockListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
