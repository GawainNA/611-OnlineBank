package model.currency;

public enum CurrencyType {
    DOLLAR("dollar", 1),
    CNY("cny", 6.5),
    POUND("pound", 0.75);

    private String name;
    private double coefficient; // coefficient of currency, use in transfer between two different currency.
                                // assume that the coefficient of Dollar is 1.

    private CurrencyType(String name, double coefficient) {
        this.setName(name);
        this.setCoefficient(coefficient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    
}
