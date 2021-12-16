package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestLoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_amount;
	private JTextField textField_collateral;
	private JTextField textField_Price;
	JComboBox comboBox;
	JButton btnConfirm;
	JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestLoan frame = new RequestLoan();
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
	public RequestLoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Request A New Loan");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(115, 10, 196, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(49, 74, 54, 15);
		contentPane.add(lblAmount);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(100, 71, 66, 21);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(201, 74, 54, 15);
		contentPane.add(lblCurrency);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dollar","cny","pound"}));
		comboBox.setBounds(277, 70, 54, 23);
		contentPane.add(comboBox);
		
		JLabel lblCollateral = new JLabel("Collateral");
		lblCollateral.setBounds(49, 119, 76, 15);
		contentPane.add(lblCollateral);
		
		textField_collateral = new JTextField();
		textField_collateral.setBounds(120, 116, 66, 21);
		contentPane.add(textField_collateral);
		textField_collateral.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(201, 119, 66, 15);
		contentPane.add(lblPrice);
		
		textField_Price = new JTextField();
		textField_Price.setBounds(263, 116, 66, 21);
		contentPane.add(textField_Price);
		textField_Price.setColumns(10);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(93, 174, 93, 23);
		contentPane.add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(249, 174, 93, 23);
		contentPane.add(btnCancel);
	}
/*
private JTextField textField_amount;
	private JTextField textField_collateral;
	private JTextField textField_TimeLimit;
	JComboBox comboBox;
	JComboBox comboBox_TimeUnit;
	JButton btnConfirm;
	JButton btnCancel;
 */
	public String getAmount(){
		return textField_amount.getText();
	}

	public String getCollateral(){
		return textField_collateral.getText();
	}

	public String getPrice(){
		return textField_Price.getText();
	}

	public String getCurrency(){
		return String.valueOf(comboBox.getSelectedItem());
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this, message);
	}

	public void addConfirmListener(ActionListener actionListener){
		btnConfirm.addActionListener(actionListener);
	}

	public void addCancelListener(ActionListener actionListener){
		btnCancel.addActionListener(actionListener);
	}
}
