package controller;

import model.Bank;
import model.stock.StockMarket;
import model.user.Manager;
import view.ManageStock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class ManageStockController {
    StockMarket stockMarket;
    ManageStock manageStockView;

    ManageStockController(StockMarket stockMarket, ManageStock manageStockView){
        this.stockMarket = stockMarket;
        this.manageStockView = manageStockView;

        manageStockView.addBackListener(new BackListener());
        manageStockView.addUpdateInfoListener(new UpdateInfoListener());

        refresh();
    }

    private void refresh(){
        stockMarket.updateStocksInfo();

        Set<String> names = stockMarket.getAllStockNames();
        String Market = "Name   /   Price   /   Amount\n";
        for (String i : names){
            model.stock.Stock tmp = stockMarket.getStockByName(i);
            Market = Market.concat(tmp.getName()+"   /   "+tmp.getUnitPrice().getAmount()+"  "+tmp.getUnitPrice().getCurrencyType().getName()+"   /   "+tmp.getNumberOfStock()+"\n");
        }
        manageStockView.setStockMarket(Market);
    }
    /*
	private JButton btnUpdateInfo;
	private JButton btnActiveStock;
	private JButton btnRemove;
	private JButton btnBack;

     */
    class UpdateInfoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refresh();
        }
    }


    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            manageStockView.dispose();
        }
    }
}
