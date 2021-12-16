package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Realized;
	private JTextField textField_Unrealized;
	JTextArea textArea_availiableStocks;
	JTextArea textArea_yourStocks;
	private String currentAccountID;
	JButton btnBuy;
	JButton btnSell;
	JButton btnBack;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock("1231");
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
	public Stock(String currentAccountID) {
		this.currentAccountID = currentAccountID;
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
		textField_Realized.setText("1000");
		textField_Realized.setEditable(false);
		textField_Realized.setBounds(244, 45, 66, 21);
		contentPane.add(textField_Realized);
		textField_Realized.setColumns(10);
		
		JLabel lblUnrealized = new JLabel("Unrealized Profit");
		lblUnrealized.setBounds(221, 168, 114, 15);
		contentPane.add(lblUnrealized);
		
		textField_Unrealized = new JTextField();
		textField_Unrealized.setText("122");
		textField_Unrealized.setEditable(false);
		textField_Unrealized.setBounds(336, 165, 66, 21);
		contentPane.add(textField_Unrealized);
		textField_Unrealized.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Availiable Stocks");
		lblNewLabel.setBounds(31, 241, 119, 15);
		contentPane.add(lblNewLabel);
		
		btnBuy = new JButton("Buy");
		btnBuy.setBounds(168, 376, 93, 23);
		contentPane.add(btnBuy);
		
		btnSell = new JButton("Sell");
		btnSell.setBounds(168, 193, 93, 23);
		contentPane.add(btnSell);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(309, 443, 93, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 73, 371, 82);
		contentPane.add(scrollPane);
		
		textArea_yourStocks = new JTextArea();
		scrollPane.setViewportView(textArea_yourStocks);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 266, 371, 97);
		contentPane.add(scrollPane_1);
		
		textArea_availiableStocks = new JTextArea();
		scrollPane_1.setViewportView(textArea_availiableStocks);
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

	public String getCurrentAccountID(){
		return currentAccountID;
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
}
