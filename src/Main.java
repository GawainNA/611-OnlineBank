import controller.SignInController;
import model.*;
import view.Sign;


public class Main {
    public static void main(String[] args) {
        Sign sign = new Sign();
        Bank bank = Bank.getInstance();

        SignInController sample = new SignInController(bank,sign);

        sign.showFrame();
    }
}
