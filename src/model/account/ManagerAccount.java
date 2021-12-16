package model.account;

import model.Bank;
import model.ErrCode;
import model.currency.Currency;
import model.currency.CurrencyType;

public class ManagerAccount extends Account {

    @Override
    public ErrCode transferTo(int destId, double amount, CurrencyType currencyType) {
        ErrCode errCode = new ErrCode(true, "success");
        // for manager account, we assume that there is infinite amount of money of
        // every type. thus we do not need check whether there is enough money before
        // transfer

        // check whether destId is valid
        Account destAccount = Bank.getInstance().getBankDatabase().getAccountById(destId);
        if (destAccount == null) {
            errCode.errMsg = "destinate account does not exist";
            errCode.isSuccess = false;
            return errCode;
        }

        // check whether destAccount has closed already
        if(destAccount.isClosed()) {
            errCode.errMsg = "destinate account has been closed, cannot transfer to";
            errCode.isSuccess = false;
            return errCode;
        }

        Currency transferCurrency = new Currency(currencyType, amount);
        destAccount.addCurrency(transferCurrency);

        // update database
        Bank.getInstance().getBankDatabase().update();

        return errCode;
    }

    @Override
    public ErrCode transferTo(int destId, Currency currency) {
        return this.transferTo(destId, currency.getAmount(), currency.getCurrencyType());
    }

}
