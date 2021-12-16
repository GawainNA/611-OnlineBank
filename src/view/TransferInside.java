package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferInside extends JFrame {

	private JPanel contentPane;
	private JTextField textField_amount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox comboBox;
	JRadioButton rdbtnChecking;
	JRadioButton rdbtnSavings;
	JButton btnConfirm;
	JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferInside frame = new TransferInside();
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
	public TransferInside() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Transfer");
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setBounds(93, 10, 238, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblsubtitle = new JLabel("Can only transfer to your other accounts");
		lblsubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblsubtitle.setBounds(82, 44, 267, 15);
		contentPane.add(lblsubtitle);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(62, 91, 54, 15);
		contentPane.add(lblAmount);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(111, 88, 66, 21);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(197, 91, 54, 15);
		contentPane.add(lblCurrency);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dollar","cny","pound"}));
		comboBox.setBounds(261, 87, 54, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Transfer To");
		lblNewLabel.setBounds(62, 145, 73, 15);
		contentPane.add(lblNewLabel);
		
		rdbtnChecking = new JRadioButton("Checking");
		buttonGroup.add(rdbtnChecking);
		rdbtnChecking.setBounds(141, 141, 86, 23);
		contentPane.add(rdbtnChecking);
		
		rdbtnSavings = new JRadioButton("Savings");
		buttonGroup.add(rdbtnSavings);
		rdbtnSavings.setBounds(229, 141, 79, 23);
		contentPane.add(rdbtnSavings);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(99, 187, 93, 23);
		contentPane.add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(238, 187, 93, 23);
		contentPane.add(btnCancel);
	}

	/*
	private JTextField textField_amount;
	private String accountID;
	JComboBox comboBox;
	JRadioButton rdbtnChecking;
	JRadioButton rdbtnSavings;
	JButton btnConfirm;
	JButton btnCancel;
	 */

	public String getAmount(){
		return textField_amount.getText();
	}

	public String getCurrency(){
		return String.valueOf(comboBox.getSelectedItem());
	}

	public boolean isCheckingSelected(){
		return rdbtnChecking.isSelected();
	}

	public boolean isSavingSelected(){
		return rdbtnSavings.isSelected();
	}

	public void addConfirmListener(ActionListener actionListener){
		btnConfirm.addActionListener(actionListener);
	}

	public void addCancelListener(ActionListener actionListener){
		btnCancel.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this,message);
	}

}
