import controller.SampleController;
import model.*;
import view.Sign;


public class MVCtest {
    public static void main(String[] args) {
        Sign sign = new Sign();
        Bank bank = Bank.getInstance();

        SampleController sample = new SampleController(bank,sign);

        sign.showFrame();
    }
}
