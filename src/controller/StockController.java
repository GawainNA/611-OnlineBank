package controller;

import model.account.SecurityAccount;
import model.stock.StockMarket;
import view.Stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockController {
    StockMarket stockMarket;
    SecurityAccount securityAccount;
    Stock stockView;

    StockController(StockMarket stockMarket, SecurityAccount securityAccount, Stock stockView){
        this.stockMarket = stockMarket;
        this.securityAccount = securityAccount;
        this.stockView = stockView;

        stockView.addBuyListener(new BuyListener());
        stockView.addSellListener(new SellListener());
        stockView.addBackListener(new BackListener());
        stockView.addUpdateListener(new UpdateListener());


    }

    /*
    JButton btnBuy;
	JButton btnSell;
	JButton btnNewBack;
     */

    class UpdateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BuyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SellListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            stockView.dispose();
        }
    }
}
