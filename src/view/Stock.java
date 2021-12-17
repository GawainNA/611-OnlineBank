package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Realized;
	private JTextField textField_Unrealized;
	JTextArea textArea_availiableStocks;
	JTextArea textArea_yourStocks;
	JButton btnBuy;
	JButton btnSell;
	JButton btnBack;
	private JTextField textField_stockName;
	private JTextField textField_stockAmount;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Stocks Management");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(134, 10, 176, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblYourStocks = new JLabel("Your Stocks");
		lblYourStocks.setBounds(31, 48, 82, 15);
		contentPane.add(lblYourStocks);

		JLabel lblRealizedProfit = new JLabel("Realized Profit");
		lblRealizedProfit.setBounds(144, 48, 96, 15);
		contentPane.add(lblRealizedProfit);
		
		textField_Realized = new JTextField();
		textField_Realized.setEditable(false);
		textField_Realized.setBounds(244, 45, 66, 21);
		contentPane.add(textField_Realized);
		textField_Realized.setColumns(10);
		
		JLabel lblUnrealized = new JLabel("Unrealized Profit");
		lblUnrealized.setBounds(221, 168, 114, 15);
		contentPane.add(lblUnrealized);
		
		textField_Unrealized = new JTextField();
		textField_Unrealized.setEditable(false);
		textField_Unrealized.setBounds(336, 165, 66, 21);
		contentPane.add(textField_Unrealized);
		textField_Unrealized.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Availiable Stocks");
		lblNewLabel.setBounds(31, 199, 119, 15);
		contentPane.add(lblNewLabel);
		
		btnBuy = new JButton("Buy");
		btnBuy.setBounds(106, 396, 89, 23);
		contentPane.add(btnBuy);
		
		btnSell = new JButton("Sell");
		btnSell.setBounds(221, 396, 89, 23);
		contentPane.add(btnSell);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(309, 452, 93, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 73, 371, 82);
		contentPane.add(scrollPane);
		
		textArea_yourStocks = new JTextArea();
		textArea_yourStocks.setEditable(false);
		scrollPane.setViewportView(textArea_yourStocks);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 235, 371, 97);
		contentPane.add(scrollPane_1);
		
		textArea_availiableStocks = new JTextArea();
		textArea_availiableStocks.setEditable(false);
		scrollPane_1.setViewportView(textArea_availiableStocks);
		
		JLabel lbStockID = new JLabel("Stock Name");
		lbStockID.setBounds(31, 360, 66, 15);
		contentPane.add(lbStockID);
		
		textField_stockName = new JTextField();
		textField_stockName.setBounds(107, 357, 88, 21);
		contentPane.add(textField_stockName);
		textField_stockName.setColumns(10);
		
		textField_stockAmount = new JTextField();
		textField_stockAmount.setBounds(269, 357, 66, 21);
		contentPane.add(textField_stockAmount);
		textField_stockAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(220, 360, 54, 15);
		contentPane.add(lblAmount);
	}

	/*
	private JTextField textField_Realized;
	private JTextField textField_Unrealized;
	private JTextArea txtrAvailiableStocks;
	private JTextArea txtrYourStocks;
	private String currentAccountID;
	JButton btnBuy;
	JButton btnSell;
	JButton btnNewBack;
	 */

	public void setTextField_Realized(String profit){
		textField_Realized.setText(profit);
	}

	public void setTextField_Unrealized(String profit){
		textField_Unrealized.setText(profit);
	}

	public void setTxtrAvailiableStocks(String profit){
		textArea_availiableStocks.setText(profit);
	}

	public void setTxtrYourStocks(String profit){
		textArea_yourStocks.setText(profit);
	}

	public String getStockName(){
		return textField_stockName.getText();
	}

	public String getStockAmount(){
		return textField_stockAmount.getText();
	}

	public void addBuyListener(ActionListener actionListener){
		btnBuy.addActionListener(actionListener);
	}

	public void addSellListener(ActionListener actionListener){
		btnSell.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this,message);
	}
}
