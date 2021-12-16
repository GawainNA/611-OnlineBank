package view;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checking {

	private JFrame frame;
	private JTextField txtAmount;
	JLabel lblid_Display;
	JTextArea txtABalance;
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBack;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checking window = new Checking("827731");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Checking(String accountID) {
		initialize(accountID);
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void close() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String accountID) {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Checking Account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(167, 10, 151, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBalance.setBounds(26, 80, 75, 21);
		frame.getContentPane().add(lblBalance);
		
		txtABalance = new JTextArea();
		txtABalance.setEditable(false);
		txtABalance.setBounds(26, 112, 230, 222);
		frame.getContentPane().add(txtABalance);
		
		JLabel lblID = new JLabel("ID: ");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblID.setBounds(151, 41, 35, 15);
		frame.getContentPane().add(lblID);
		
		lblid_Display = new JLabel(accountID);
		lblid_Display.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblid_Display.setHorizontalAlignment(SwingConstants.CENTER);
		lblid_Display.setBounds(177, 41, 115, 15);
		frame.getContentPane().add(lblid_Display);
		
		btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(317, 109, 134, 30);
		frame.getContentPane().add(btnTransfer);
		
		btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.setBounds(317, 165, 134, 30);
		frame.getContentPane().add(btnCloseAccount);
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(26, 414, 105, 30);
		frame.getContentPane().add(btnDeposit);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(365, 414, 86, 30);
		frame.getContentPane().add(btnBack);
		
		btnWithdraw = new JButton("WithDraw");
		btnWithdraw.setBounds(213, 414, 105, 30);
		frame.getContentPane().add(btnWithdraw);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(26, 374, 59, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(94, 371, 75, 21);
		frame.getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Currency");
		lblNewLabel_2.setBounds(179, 374, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dollar","cny","pound"}));
		comboBox.setBounds(243, 370, 75, 23);
		frame.getContentPane().add(comboBox);
	}

	public void setBalance(String Info){
		txtABalance.setText(Info);
	}

	public String getAmount(){
		return txtAmount.getText();
	}

	public String getCurrency(){
		return String.valueOf(comboBox.getSelectedItem());
	}
	/*
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnDeposit;
	JButton btnWithdraw;
	JButton btnBack;
	 */

	public void addTransferListener(ActionListener actionListener){
		btnTransfer.addActionListener(actionListener);
	}

	public void addCloseAccountListener(ActionListener actionListener){
		btnCloseAccount.addActionListener(actionListener);
	}

	public void addDepositListener(ActionListener actionListener){
		btnDeposit.addActionListener(actionListener);
	}

	public void addWithdrawListener(ActionListener actionListener){
		btnWithdraw.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(frame, message);
	}
}
