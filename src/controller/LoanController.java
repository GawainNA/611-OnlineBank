package controller;

import model.Bank;
import model.ErrCode;
import model.user.Customer;
import view.Loan;
import view.RequestLoan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoanController {
    Bank bank;
    Customer customer;
    Loan loanView;

    LoanController(Bank bank,Customer customer,Loan loan){
        this.customer = customer;
        this.loanView = loan;

        loanView.addBackListener(new BackListener());
        loanView.addNewLoanListener(new NewLoanListener());
        loanView.addRepaymentListener(new RepaymentListener());

        refreshInfo();

    }

    /*
	JButton btnNewLoan;
	JButton btnRepayment;
	JButton btnBack;
	 */

    private void refreshInfo(){
        List<model.loan.Loan> loans = customer.getLoanList();

        String loanInfo = "Loan ID   /   Customer ID   /   Amount   /   Collateral\n";

        for(model.loan.Loan i : loans){
            loanInfo = loanInfo.concat(i.getUid()+"   /   "+i.getCustomerId()+"   /   "+i.getLoanCurrency().getAmount()+"  "+i.getLoanCurrency().getCurrencyType().getName()+"   /   "+i.getCollateral().getName()+"\n");
        }

        loanView.setCurrentLoan(loanInfo);
    }

    class NewLoanListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RequestLoan requestLoanView = new RequestLoan();
            RequestLoanController controller = new RequestLoanController(bank,customer,requestLoanView);
            requestLoanView.setVisible(true);
        }
    }

    class RepaymentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = customer.repayLoan(Integer.parseInt(loanView.getLoanID()));
            loanView.showMessage(errCode.errMsg);
            refreshInfo();
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            loanView.dispose();
        }
    }
}
