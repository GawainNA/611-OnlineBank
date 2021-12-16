package controller;

import model.Bank;
import model.ErrCode;
import model.account.SecurityAccount;
import model.currency.CurrencyType;
import model.user.Customer;
import view.Security;
import view.TransferInside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class SecurityController {
    SecurityAccount securityAccount;
    Security securityView;
    Bank bank;
    Customer customer;

    SecurityController(Bank bank,Customer customer,SecurityAccount securityAccount, Security securityView){
        this.securityAccount = securityAccount;
        this.securityView = securityView;
        this.bank = bank;
        this.customer = customer;

        securityView.addTransferListener(new TransferListener());
        securityView.addCloseAccountListener(new CloseAccountListener());
        securityView.addStockListener(new StockListener());
        securityView.addBackListener(new BackListener());

        refreshInfo();
    }

    private void refreshInfo(){
        String BalanceInfo = "";
        Set<CurrencyType> types = securityAccount.getAllCurrencyType();
        for(CurrencyType type : types){
            Double amount = securityAccount.getCurrencyByType(type).getAmount();
            BalanceInfo = BalanceInfo.concat(amount+"  "+type.getName()+"\n");
        }

        securityView.setBalance(BalanceInfo);
    }

    class TransferListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TransferInside transferInsideView = new TransferInside();
            TransferInsideController controller = new TransferInsideController(customer,customer.getSecurityAccount(),transferInsideView);
            transferInsideView.setVisible(true);
        }
    }

    class CloseAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = customer.closeSecurityAccount();
            securityView.showMessage(errCode.errMsg);
            if(errCode.isSuccess){
                securityView.close();
            }
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
