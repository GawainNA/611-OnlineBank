package loan;

import model.Persistable;
import model.currency.Currency;
import util.IdCreator;

public class Collateral implements Persistable{
    private int id;
    private String name;
    private Currency price;

    public Collateral(String name, Currency price) {
        this.id = IdCreator.createRandomInt();
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
    
    
}
