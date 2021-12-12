package view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Security {

	private JFrame frame;
	JLabel lblid_Display;
	JTextArea txtBalance;
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnBack;
	JButton btnStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security window = new Security("3123454");
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
	public Security(String accountID) {
		initialize(accountID);
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
	private void initialize(String accountID) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeadline = new JLabel("Security Account");
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHeadline.setBounds(141, 10, 151, 21);
		frame.getContentPane().add(lblHeadline);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBalance.setBounds(26, 80, 75, 21);
		frame.getContentPane().add(lblBalance);
		
		txtBalance = new JTextArea();
		txtBalance.setEditable(false);
		txtBalance.setBounds(26, 112, 162, 233);
		frame.getContentPane().add(txtBalance);
		
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
		btnTransfer.setBounds(290, 113, 134, 30);
		frame.getContentPane().add(btnTransfer);
		
		btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.setBounds(290, 275, 134, 30);
		frame.getContentPane().add(btnCloseAccount);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(290, 315, 134, 30);
		frame.getContentPane().add(btnBack);
		
		btnStock = new JButton("Stock");
		btnStock.setBounds(290, 169, 134, 30);
		frame.getContentPane().add(btnStock);
	}
	/*
	JLabel lblid_Display;
	JTextArea txtBalance;
	JButton btnTransfer;
	JButton btnCloseAccount;
	JButton btnBack;
	JButton btnStock;
	 */
	public void addTransferListener(ActionListener actionListener){
		btnTransfer.addActionListener(actionListener);
	}

	public void addCloseAccountListener(ActionListener actionListener){
		btnCloseAccount.addActionListener(actionListener);
	}

	public void addStockListener(ActionListener actionListener){
		btnStock.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}
}
