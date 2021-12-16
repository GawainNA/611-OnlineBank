package controller;

import model.Bank;
import model.ErrCode;
import model.account.SavingAccount;
import model.currency.CurrencyType;
import view.Savings;
import view.Transfer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class SavingsController {
    SavingAccount savingAccount;
    Savings savingsView;
    Bank bank;

    SavingsController(Bank bank,SavingAccount savingAccount, Savings savingsView){
        this.bank = bank;
        this.savingAccount = savingAccount;
        this.savingsView = savingsView;

        savingsView.addTransferListener(new TransferListener());
        savingsView.addCloseAccountListener(new CloseAccountListener());
        savingsView.addDepositListener(new DepositListener());
        savingsView.addWithdrawListener(new WithdrawListener());
        savingsView.addBackListener(new BackListener());

        refreshInfo();
    }

    private void refreshInfo(){
        String BalanceInfo = "";
        Set<CurrencyType> types = savingAccount.getAllCurrencyType();
        for(CurrencyType type : types){
            Double amount = savingAccount.getCurrencyByType(type).getAmount();
            BalanceInfo = BalanceInfo.concat(amount+"  "+type.getName()+"\n");
        }

        savingsView.setBalance(BalanceInfo);
    }

    class TransferListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Transfer transferView = new Transfer();
            TransferController controller = new TransferController(bank,savingAccount,transferView);
            transferView.showFrame();
        }
    }

    class CloseAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class DepositListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            savingAccount.deposit(Integer.parseInt(savingsView.getAmount()), CurrencyType.str2CurrencyType(savingsView.getCurrency()));
            savingsView.showMessage("Success!");
            refreshInfo();
        }
    }

    class WithdrawListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = savingAccount.withdraw(Integer.parseInt(savingsView.getAmount()), CurrencyType.str2CurrencyType(savingsView.getCurrency()));
            savingsView.showMessage(errCode.errMsg);
            refreshInfo();
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            savingsView.close();
        }
    }
}
