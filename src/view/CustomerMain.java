package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain window = new CustomerMain();
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
	public CustomerMain() {
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
		frame.setBounds(100, 100, 450, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Gawain!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 10, 190, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnChecking = new JButton("Checking Account");
		btnChecking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checking n = new Checking();
				n.showFrame();
			}
		});
		btnChecking.setBounds(0, 206, 145, 33);
		frame.getContentPane().add(btnChecking);
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loan tmp = new Loan();
				tmp.setVisible(true);
			}
		});
		btnLoan.setBounds(289, 187, 145, 33);
		frame.getContentPane().add(btnLoan);
		
		JButton btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock tmp = new Stock();
				tmp.setVisible(true);
			}
		});
		btnStock.setBounds(289, 242, 145, 33);
		frame.getContentPane().add(btnStock);
		
		JButton btnSavings = new JButton("Savings Account");
		btnSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Savings n = new Savings();
				n.showFrame();
			}
		});
		btnSavings.setBounds(0, 263, 145, 33);
		frame.getContentPane().add(btnSavings);
		
		JButton btnSecurityAccount = new JButton("Security Account");
		btnSecurityAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Security S = new Security();
				S.showFrame();
			}
		});
		btnSecurityAccount.setBounds(0, 321, 145, 33);
		frame.getContentPane().add(btnSecurityAccount);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sign s = new Sign();
				s.showFrame();
				close();
			}
		});
		btnSignOut.setBounds(175, 418, 93, 23);
		frame.getContentPane().add(btnSignOut);
		
		JLabel lblEmail = new JLabel("Email Address: ");
		lblEmail.setBounds(49, 58, 96, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblEmailDisplay = new JLabel("gawain7@bu.edu");
		lblEmailDisplay.setBounds(155, 58, 155, 15);
		frame.getContentPane().add(lblEmailDisplay);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(49, 83, 54, 15);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblPhoneDisplay = new JLabel("6178346244");
		lblPhoneDisplay.setBounds(155, 83, 155, 15);
		frame.getContentPane().add(lblPhoneDisplay);
		
		JButton btnPInfo = new JButton("Update Personal Info");
		btnPInfo.setBounds(137, 108, 173, 33);
		frame.getContentPane().add(btnPInfo);
		
		JButton btnOpenAccount = new JButton("Open Account");
		btnOpenAccount.setBounds(289, 295, 145, 33);
		frame.getContentPane().add(btnOpenAccount);
		
		JButton btnTranscationLog = new JButton("Transcation Log");
		btnTranscationLog.setBounds(289, 348, 145, 33);
		frame.getContentPane().add(btnTranscationLog);
	}
}
