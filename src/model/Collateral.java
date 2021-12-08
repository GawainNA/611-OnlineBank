package model;

import model.currency.Currency;
import util.IdCreator;

public class Collateral {
    private int id;
    private String name;
    private Currency price;

    public Collateral(String name, Currency price) {
        this.id = IdCreator.createRandomInt();
        this.name = name;
        this.price = price;
    }
    
    
}
