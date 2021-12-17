package model.loan;

import model.currency.Currency;

/**
 * Collateral Factory to create collateral object
 */
public class CollateralFactory {
    private static CollateralFactory collateralFactory;

    private CollateralFactory() {

    }

    public static CollateralFactory getInstance() {
        if(collateralFactory == null) {
            collateralFactory = new CollateralFactory();
        }
        return collateralFactory;
    }

    public Collateral createCollateral(String name, Currency price) {
        return new Collateral(name, price);
    }
}
