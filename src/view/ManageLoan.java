package view;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageLoan extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea_RequestLoan;
	private JTextArea textArea_ActiveLoan;
	private JButton btnAccept;
	private JButton btnBack;
	private JButton btnDecline;
	private JTextField textField_LoanID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLoan frame = new ManageLoan();
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
	public ManageLoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Loan Management");
		lblHeadline.setBounds(128, 10, 176, 24);
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblHeadline);
		
		JLabel lblNewLabel_1 = new JLabel("Actived Loan");
		lblNewLabel_1.setBounds(10, 48, 89, 15);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 414, 96);
		contentPane.add(scrollPane);
		
		textArea_ActiveLoan = new JTextArea();
		textArea_ActiveLoan.setEditable(false);
		scrollPane.setViewportView(textArea_ActiveLoan);
		
		btnAccept = new JButton("Accept");
		
		btnAccept.setBounds(73, 403, 95, 24);
		contentPane.add(btnAccept);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(152, 453, 130, 33);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Requested Loan");
		lblNewLabel.setBounds(10, 207, 104, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 243, 414, 96);
		contentPane.add(scrollPane_1);
		
		textArea_RequestLoan = new JTextArea();
		textArea_RequestLoan.setEditable(false);
		scrollPane_1.setViewportView(textArea_RequestLoan);
		
		textField_LoanID = new JTextField();
		textField_LoanID.setBounds(117, 362, 216, 21);
		contentPane.add(textField_LoanID);
		textField_LoanID.setColumns(10);
		
		JLabel lblLoanID = new JLabel("Loan ID");
		lblLoanID.setBounds(48, 365, 66, 15);
		contentPane.add(lblLoanID);
		
		btnDecline = new JButton("Decline");
		btnDecline.setBounds(251, 404, 95, 24);
		contentPane.add(btnDecline);
	}

	/*
	private JTextArea textArea_RequestLoan;
	private JTextArea textArea_ActiveLoan;
	private JButton btnAccept;
	private JButton btnBack;
	 */

	public String getRequestLoan(){
		return textArea_RequestLoan.getText();
	}

	public String getActiveLoan(){
		return textArea_ActiveLoan.getText();
	}

	public String getLoanID(){
		return textField_LoanID.getText();
	}

	public void setRequestLoan(String Info){
		textArea_RequestLoan.setText(Info);
	}

	public void setActiveLoan(String Info){
		textArea_ActiveLoan.setText(Info);
	}

	public void addAcceptListener(ActionListener actionListener){
		btnAccept.addActionListener(actionListener);
	}

	public void addDeclineListener(ActionListener actionListener){
		btnDecline.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this,message);
	}
}
