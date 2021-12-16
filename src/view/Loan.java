package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Loan extends JFrame {

	private JPanel contentPane;
	JButton btnNewLoan;
	JButton btnRepayment;
	JButton btnBack;
	JTextArea textArea_CurrentLoan;
	private JTextField textField_RepaymentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan frame = new Loan();
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
	public Loan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Loan Info");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(151, 10, 115, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblNewLabel = new JLabel("Current Loan");
		lblNewLabel.setBounds(35, 51, 77, 15);
		contentPane.add(lblNewLabel);
		
		btnNewLoan = new JButton("New Loan");
		btnNewLoan.setBounds(35, 300, 93, 31);
		contentPane.add(btnNewLoan);
		
		btnRepayment = new JButton("Repayment");

		btnRepayment.setBounds(296, 246, 103, 24);
		contentPane.add(btnRepayment);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(306, 300, 93, 31);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 76, 364, 143);
		contentPane.add(scrollPane);
		
		textArea_CurrentLoan = new JTextArea();
		textArea_CurrentLoan.setEditable(false);
		scrollPane.setViewportView(textArea_CurrentLoan);
		
		textField_RepaymentID = new JTextField();
		textField_RepaymentID.setBounds(103, 248, 183, 21);
		contentPane.add(textField_RepaymentID);
		textField_RepaymentID.setColumns(10);
		
		JLabel lblRepaymentID = new JLabel("Loan ID");
		lblRepaymentID.setBounds(35, 251, 58, 15);
		contentPane.add(lblRepaymentID);
	}

	public void setCurrentLoan(String loanInfo){
		textArea_CurrentLoan.setText(loanInfo);
	}

	public String getLoanID(){
		return textField_RepaymentID.getText();
	}

	public String getCurrentLoan(){
		return textArea_CurrentLoan.getText();
	}
	/*
	JButton btnNewLoan;
	JButton btnRepayment;
	JButton btnBack;
	 */
	public void addNewLoanListener(ActionListener actionListener){
		btnNewLoan.addActionListener(actionListener);
	}

	public void addRepaymentListener(ActionListener actionListener){
		btnRepayment.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this, message);
	}
}
