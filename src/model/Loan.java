package model;

import java.util.Currency;

import util.IdCreator;

public class Loan {
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

}
