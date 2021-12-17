package controller;

import model.ErrCode;
import model.account.SecurityAccount;
import model.stock.StockMarket;
import view.Stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

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

        refresh();
    }

    private void refresh(){
        List<model.stock.Stock> yourStocks = securityAccount.getStockList();
        Set<String> names = stockMarket.getAllStockNames();

        String myStocks = "";
        String Market = "";
        for(model.stock.Stock i : yourStocks){
            myStocks = myStocks.concat(i.getName()+"     "+i.getUnitPrice().getAmount()+"  "+i.getUnitPrice().getCurrencyType().getName()+"    "+i.getNumberOfStock()+"\n");
        }

        for (String i : names){
            model.stock.Stock tmp = stockMarket.getStockByName(i);
            Market = Market.concat(tmp.getName()+"     "+tmp.getUnitPrice().getAmount()+"  "+tmp.getUnitPrice().getCurrencyType().getName()+"    "+tmp.getNumberOfStock()+"\n");
        }

        stockView.setTxtrYourStocks(myStocks);
        stockView.setTxtrAvailiableStocks(Market);
    }

    /*
    JButton btnBuy;
	JButton btnSell;
	JButton btnNewBack;
     */

    class BuyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = securityAccount.buyStock(stockView.getStockName(),Integer.parseInt(stockView.getStockAmount()));
            stockView.showMessage(errCode.errMsg);
        }
    }

    class SellListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ErrCode errCode = securityAccount.sellStock(stockView.getStockName(),Integer.parseInt(stockView.getStockAmount()));
            stockView.showMessage(errCode.errMsg);
        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            stockView.dispose();
        }
    }
}
