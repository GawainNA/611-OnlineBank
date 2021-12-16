package controller;

import model.Bank;
import view.ManageStock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageStockController {
    Bank bank;
    ManageStock manageStockView;

    ManageStockController(Bank bank, ManageStock manageStockView){
        this.bank = bank;
        this.manageStockView = manageStockView;

        manageStockView.addBackListener(new BackListener());
        manageStockView.addActiveStockListener(new ActiveStockListener());
        manageStockView.addUpdateInfoListener(new UpdateInfoListener());
        manageStockView.addRemoveListener(new RemoveListener());
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

        }
    }

    class ActiveStockListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class RemoveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
