package controller;

import model.Bank;
import model.ErrCode;
import model.currency.CurrencyType;
import model.user.Customer;
import view.RequestLoan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestLoanController {
    Bank bank;
    Customer customer;
    RequestLoan requestLoanView;

    RequestLoanController(Bank bank, Customer customer,RequestLoan requestLoanView){
        this.bank = bank;
        this.customer = customer;
        this.requestLoanView = requestLoanView;

        requestLoanView.addCancelListener(new CancelListener());
        requestLoanView.addConfirmListener(new ConfirmListener());
    }

    class ConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String amount = requestLoanView.getAmount();
            String ctype = requestLoanView.getCurrency();
            String col = requestLoanView.getCollateral();
            String price = requestLoanView.getPrice();
            ErrCode errCode = customer.applyForLoan(Double.parseDouble(amount),Double.parseDouble(price),col, CurrencyType.str2CurrencyType(ctype));
            requestLoanView.showMessage(errCode.errMsg);
        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            requestLoanView.dispose();
        }
    }
}
