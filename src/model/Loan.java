package model;

import java.util.Currency;

import util.IdCreator;

public class Loan implements Persistable{
    private int id;
    private Currency loanPrice;
    private Collateral collateral;
    private boolean isReedemed;
    private boolean isAgreed;

    public Loan(Currency loanPrice, Collateral collateral) {
        this.id = IdCreator.createRandomInt();
        this.loanPrice = loanPrice;
        this.collateral = collateral;
        isAgreed = false;
        isReedemed = false;
    }

    public int getId() {
        return id;
    }

    public Currency getLoanPrice() {
        return loanPrice;
    }

    public void setLoanPrice(Currency loanPrice) {
        this.loanPrice = loanPrice;
    }

    public Collateral getCollateral() {
        return collateral;
    }

    public void setCollateral(Collateral collateral) {
        this.collateral = collateral;
    }

    public boolean isReedemed() {
        return isReedemed;
    }

    public void setReedemed(boolean isReedemed) {
        this.isReedemed = isReedemed;
    }

    public boolean isAgreed() {
        return isAgreed;
    }

    public void setAgreed(boolean isAgreed) {
        this.isAgreed = isAgreed;
    }

}
