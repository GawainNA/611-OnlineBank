package model.loan;

public enum LoanStatus {
    LOAN_PENDING("pending"),    // submit, wait for manager to deal
    LOAN_AGREED("agreed"),  // manager pass this loan
    LOAN_REFUSED("refused"),    // manager refuse this loan
    LOAN_REPAYED("repayed"),  // customer redeem this loan
    UNDEFINED("undefined"); // undefine status, use to handle invalid input
    
    private String status;

    private LoanStatus(String status) {
        this.status = status;
    }

    public String getStr() {
        return this.status;
    }

    /**
     * 
     * @param status now supporting: pending, agreed, refused, redeemed
     * @return enum of loan status
     */
    public static LoanStatus str2LoanStatus(String status) {
        if(LOAN_PENDING.getStr().equalsIgnoreCase(status)) {
            return LOAN_PENDING;
        } else if(LOAN_AGREED.getStr().equalsIgnoreCase(status)) {
            return LOAN_AGREED;
        } else if(LOAN_REFUSED.getStr().equalsIgnoreCase(status)) {
            return LOAN_REFUSED;
        } else if(LOAN_REPAYED.getStr().equalsIgnoreCase(status)) {
            return LOAN_REPAYED;
        }

        return UNDEFINED;
    }
}
