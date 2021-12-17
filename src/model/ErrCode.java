package model;

public class ErrCode {
    public boolean isSuccess;
    public String errMsg;

    public ErrCode() {

    }

    public ErrCode(boolean isSuccess, String errMsg) {
        this.isSuccess = isSuccess;
        this.errMsg = errMsg;
    }
}
