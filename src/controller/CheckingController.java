package controller;

import model.Bank;
import model.ErrCode;
import model.account.CheckingAccount;
import model.currency.CurrencyType;
import model.user.Customer;
import view.Checking;
import view.Transfer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class CheckingController {
    Bank bank;
    Checking checkingView;
    CheckingAccount checkingAccount;
    Customer customer;

    CheckingController(Bank bank,Customer customer,CheckingAccount checkingAccount,Checking checkingView){
        this.bank = bank;
        this.customer = customer;
        this.checkingAccount = checkingAccount;
        this.checkingView = checkingView;

        checkingView.addTransferListener(new TransferListener());
        checkingView.addCloseAccountListener(new CloseAccountListener());
        checkingView.addDepositListener(new DepositListener());
        checkingView.addWithdrawListener(new WithdrawListener());
        checkingView.addBackListener(new BackListener());

        refreshInfo();
    }

    private void refreshInfo(){
        String BalanceInfo = "";
        Set<CurrencyType> types = checkingAccount.getAllCurrencyType();
        for(CurrencyType type : types){
            Double amount = checkingAccount.getCurrencyByType(type).getAmount();
            BalanceInfo = BalanceInfo.concat(amount+"  "+type.getName()+"\n");
        }
        checkingView.setBalance(BalanceInfo);
    }
    /*
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBack;
	 */

    class TransferListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Transfer transferView = new Transfer();
            TransferController controller = new TransferController(bank,checkingAccount,transferView);
            transferView.showFrame();
        }
    }

    class CloseAccountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = customer.closeCheckingAccount();
            checkingView.showMessage(errCode.errMsg);
            if(errCode.isSuccess){
                checkingView.close();
            }
        }
    }

    class DepositListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            checkingAccount.deposit(Integer.parseInt(checkingView.getAmount()), CurrencyType.str2CurrencyType(checkingView.getCurrency()));
            checkingView.showMessage("Success!");
            refreshInfo();
        }
    }

    class WithdrawListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = checkingAccount.withdraw(Integer.parseInt(checkingView.getAmount()), CurrencyType.str2CurrencyType(checkingView.getCurrency()));
            checkingView.showMessage(errCode.errMsg);
            refreshInfo();
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            checkingView.close();
        }
    }
}
