package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain frame = new ManagerMain();
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
	public ManagerMain() {
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
		
		JButton btnLog = new JButton("Transactions Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction log = new Transaction();
				log.setVisible(true);
			}
		});
		btnLog.setBounds(0, 74, 143, 33);
		contentPane.add(btnLog);
		
		JButton btnLoan = new JButton("Manage Loans");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLoan tmp = new ManageLoan();
				tmp.setVisible(true);
			}
		});
		btnLoan.setBounds(0, 158, 143, 33);
		contentPane.add(btnLoan);
		
		JButton btnManageStocks = new JButton("Manage Stocks");
		btnManageStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStock tmp = new ManageStock();
				tmp.setVisible(true);
			}
		});
		btnManageStocks.setBounds(291, 74, 143, 33);
		contentPane.add(btnManageStocks);
		
		JButton btnSignOut = new JButton("Sign Out");
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
}
