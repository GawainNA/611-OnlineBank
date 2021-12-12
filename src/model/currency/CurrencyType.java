package model.currency;

import model.Persistable;

public enum CurrencyType implements Persistable{
    DOLLAR("dollar", 1),
    CNY("cny", 6.5),
    POUND("pound", 0.75),
    NOT_SUPPORTED_TYPE("not supported currency type", Double.MAX_VALUE);

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


    /**
     * 
     * @param str currency type in string format
     * @return CurrencyType object corresponding to input string. 
     *          return NOT_SUPPORTED_TYPE if input string is not a support currency type.
     */
    public static CurrencyType str2CurrencyType(String str) {
        if(DOLLAR.getName().equalsIgnoreCase(str)) {
            return DOLLAR;
        } else if(CNY.getName().equalsIgnoreCase(str)) {
            return CNY;
        } else if(POUND.getName().equalsIgnoreCase(str)) {
            return POUND;
        }

        return NOT_SUPPORTED_TYPE;
    }
    
}
