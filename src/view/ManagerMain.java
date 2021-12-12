package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMain extends JFrame {

	private JPanel contentPane;
	private String userID;
	JButton btnLog;
	JButton btnLoan;
	JButton btnManageStocks;
	JButton btnSignOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain frame = new ManagerMain("31251");
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
	public ManagerMain(String userID) {
		this.userID = userID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Back Manager!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(104, 10, 229, 24);
		contentPane.add(lblNewLabel);
		
		btnLog = new JButton("Transactions Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction log = new Transaction();
				log.setVisible(true);
			}
		});
		btnLog.setBounds(0, 74, 143, 33);
		contentPane.add(btnLog);
		
		btnLoan = new JButton("Manage Loans");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLoan tmp = new ManageLoan();
				tmp.setVisible(true);
			}
		});
		btnLoan.setBounds(0, 158, 143, 33);
		contentPane.add(btnLoan);
		
		btnManageStocks = new JButton("Manage Stocks");
		btnManageStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStock tmp = new ManageStock();
				tmp.setVisible(true);
			}
		});
		btnManageStocks.setBounds(291, 74, 143, 33);
		contentPane.add(btnManageStocks);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign sign = new Sign();
				sign.showFrame();
				dispose();
			}
		});
		btnSignOut.setBounds(291, 158, 143, 33);
		contentPane.add(btnSignOut);
	}
	/*
	private String userID;
	JButton btnLog;
	JButton btnLoan;
	JButton btnManageStocks;
	JButton btnSignOut;
	 */

	public String getUserID(){
		return userID;
	}

	public void addLogListener(ActionListener actionListener){
		btnLog.addActionListener(actionListener);
	}

	public void addLoanListener(ActionListener actionListener){
		btnLoan.addActionListener(actionListener);
	}

	public void addManageStockListener(ActionListener actionListener){
		btnManageStocks.addActionListener(actionListener);
	}

	public void addSignOutListener(ActionListener actionListener){
		btnSignOut.addActionListener(actionListener);
	}
}
