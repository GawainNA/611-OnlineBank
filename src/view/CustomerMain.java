package view;
import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMain {

	private JFrame frame;
	private JButton btnChecking;
	private JButton btnSavings;
	JButton btnLoan;
	JButton btnSecurityAccount;
	JButton btnSignOut;
	JButton btnOpenAccount;
	JButton btnTranscationLog;
	JLabel lblUserName;
	JLabel lblUIDDisplay;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain window = new CustomerMain("Gawain","123");
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
	public CustomerMain(String userName,String userId) {
		initialize(userName,userId);
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void close() {
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String userName,String userId) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeadline = new JLabel("Welcome");
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setBounds(133, 10, 93, 21);
		frame.getContentPane().add(lblHeadline);

		btnChecking = new JButton("Checking Account");
		btnChecking.setBounds(0, 102, 145, 33);
		frame.getContentPane().add(btnChecking);
		
		btnLoan = new JButton("Loan");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan tmp = new Loan();
				tmp.setVisible(true);
			}
		});
		btnLoan.setBounds(289, 102, 145, 33);
		frame.getContentPane().add(btnLoan);
		
		btnSavings = new JButton("Savings Account");
		btnSavings.setBounds(0, 167, 145, 33);
		frame.getContentPane().add(btnSavings);
		
		btnSecurityAccount = new JButton("Security Account");
		btnSecurityAccount.setBounds(0, 230, 145, 33);
		frame.getContentPane().add(btnSecurityAccount);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign s = new Sign();
				s.showFrame();
				close();
			}
		});
		btnSignOut.setBounds(168, 314, 93, 23);
		frame.getContentPane().add(btnSignOut);
		
		JLabel lblUserID = new JLabel("User ID : ");
		lblUserID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserID.setBounds(86, 58, 96, 15);
		frame.getContentPane().add(lblUserID);
		
		lblUIDDisplay = new JLabel(userId);
		lblUIDDisplay.setBounds(192, 58, 155, 15);
		frame.getContentPane().add(lblUIDDisplay);
		
		btnOpenAccount = new JButton("Open Account");
		btnOpenAccount.setBounds(289, 167, 145, 33);
		frame.getContentPane().add(btnOpenAccount);
		
		btnTranscationLog = new JButton("Transcation Log");
		btnTranscationLog.setBounds(289, 230, 145, 33);
		frame.getContentPane().add(btnTranscationLog);
		
		lblUserName = new JLabel(userName);
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUserName.setBounds(223, 10, 87, 20);
		frame.getContentPane().add(lblUserName);
	}

	public void addCheckingListener(ActionListener actionListener){
		btnChecking.addActionListener(actionListener);
	}

	public void addSavingsListener(ActionListener actionListener){
		btnSavings.addActionListener(actionListener);
	}

	public void addLoanListener(ActionListener actionListener){
		btnLoan.addActionListener(actionListener);
	}

	public void addSecurityListener(ActionListener actionListener){
		btnSecurityAccount.addActionListener(actionListener);
	}

	public void addSignOutListener(ActionListener actionListener){
		btnSignOut.addActionListener(actionListener);
	}

	public void addOpenAccountListener(ActionListener actionListener){
		btnOpenAccount.addActionListener(actionListener);
	}

	public void addTransactionListener(ActionListener actionListener){
		btnTranscationLog.addActionListener(actionListener);
	}

	public String getUserName(){
		return lblUserName.getText();
	}

	public String getUserId(){
		return lblUIDDisplay.getText();
	}

}
