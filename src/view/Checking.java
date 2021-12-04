package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checking {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checking window = new Checking();
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
	public Checking() {
		initialize();
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Checking Account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(141, 10, 151, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblBalance.setBounds(26, 80, 75, 21);
		frame.getContentPane().add(lblBalance);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(26, 112, 162, 233);
		frame.getContentPane().add(textArea);
		
		JLabel lblID = new JLabel("ID: ");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblID.setBounds(151, 41, 35, 15);
		frame.getContentPane().add(lblID);
		
		JLabel lblid_Display = new JLabel("817237331");
		lblid_Display.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblid_Display.setHorizontalAlignment(SwingConstants.CENTER);
		lblid_Display.setBounds(177, 41, 115, 15);
		frame.getContentPane().add(lblid_Display);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transfer n = new Transfer();
				n.showFrame();
			}
		});
		btnTransfer.setBounds(290, 113, 134, 30);
		frame.getContentPane().add(btnTransfer);
		
		JButton btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.setBounds(290, 275, 134, 30);
		frame.getContentPane().add(btnCloseAccount);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit D = new Deposit();
				D.setVisible(true);
			}
		});
		btnDeposit.setBounds(290, 165, 134, 30);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(290, 315, 134, 30);
		frame.getContentPane().add(btnBack);
		
		JButton btnWithdraw = new JButton("WithDraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw W = new Withdraw();
				W.setVisible(true);
			}
		});
		btnWithdraw.setBounds(290, 214, 134, 30);
		frame.getContentPane().add(btnWithdraw);
	}
}
