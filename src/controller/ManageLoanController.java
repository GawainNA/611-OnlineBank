package controller;

import model.Bank;
import model.ErrCode;
import model.loan.Loan;
import model.user.Manager;
import view.ManageLoan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageLoanController {
    Bank bank;
    Manager manager;
    ManageLoan manageLoanView;

    ManageLoanController(Bank bank, Manager manager,ManageLoan manageLoanView){
        this.bank = bank;
        this.manager = manager;
        this.manageLoanView = manageLoanView;

        manageLoanView.addAcceptListener(new AcceptListener());
        manageLoanView.addDeclineListener(new DeclineListener());
        manageLoanView.addBackListener(new BackListener());

        refreshInfo();
    }

    private void refreshInfo(){
        List<Loan> activated = manager.getActivatedLoanList();
        List<Loan> requested = manager.getRequestedLoanList();

        String activatedInfo = "Loan ID   /   Customer ID   /   Amount   /   Collateral\n";
        String requestedInfo = "Loan ID   /   Customer ID   /   Amount   /   Collateral\n";

        for (Loan i : activated){
            activatedInfo = activatedInfo.concat(i.getUid()+"   /   "+i.getCustomerId()+"   /   "+i.getLoanCurrency().getAmount()+"  "+i.getLoanCurrency().getCurrencyType().getName()+"   /   "+i.getCollateral().getName()+"\n");
        }

        for (Loan i : requested){
            requestedInfo = requestedInfo.concat(i.getUid()+"   /   "+i.getCustomerId()+"   /   "+i.getLoanCurrency().getAmount()+"  "+i.getLoanCurrency().getCurrencyType().getName()+"   /   "+i.getCollateral().getName()+"\n");
        }

        manageLoanView.setActiveLoan(activatedInfo);
        manageLoanView.setRequestLoan(requestedInfo);
    }

    class AcceptListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = manager.handleRequestedLoan(Integer.parseInt(manageLoanView.getLoanID()),true);
            manageLoanView.showMessage(errCode.errMsg);
            refreshInfo();
        }
    }

    class DeclineListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = manager.handleRequestedLoan(Integer.parseInt(manageLoanView.getLoanID()),false);
            manageLoanView.showMessage(errCode.errMsg);
            refreshInfo();
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            manageLoanView.dispose();
        }
    }
}
