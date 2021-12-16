package view;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfer {

	private JFrame frame;
	private JTextField textField_AccountID;
	private JTextField textField_Amount;
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
					Transfer window = new Transfer();
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
	public Transfer() {
		initialize();
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeadLine = new JLabel("Transfer");
		lblHeadLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadLine.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadLine.setBounds(123, 10, 183, 24);
		frame.getContentPane().add(lblHeadLine);
		
		JLabel lblAccountID = new JLabel("Account ID");
		lblAccountID.setBounds(45, 76, 94, 24);
		frame.getContentPane().add(lblAccountID);
		
		textField_AccountID = new JTextField();
		textField_AccountID.setBounds(149, 78, 172, 21);
		frame.getContentPane().add(textField_AccountID);
		textField_AccountID.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(45, 137, 54, 15);
		frame.getContentPane().add(lblAmount);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(109, 134, 84, 21);
		frame.getContentPane().add(textField_Amount);
		textField_Amount.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dollar","cny","pound"}));
		comboBox.setBounds(287, 133, 70, 23);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(220, 137, 54, 15);
		frame.getContentPane().add(lblCurrency);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(109, 201, 93, 23);
		frame.getContentPane().add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(248, 201, 93, 23);
		frame.getContentPane().add(btnCancel);
	}

	public String getToId(){
		return textField_AccountID.getText();
	}

	public String getAmount(){
		return textField_Amount.getText();
	}

	public String getCurrency(){
		return String.valueOf(comboBox.getSelectedItem());
	}

	public void addConfirmListener(ActionListener actionListener){
		btnConfirm.addActionListener(actionListener);
	}

	public void addCancelListener(ActionListener actionListener){
		btnCancel.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(frame, message);
	}
}
