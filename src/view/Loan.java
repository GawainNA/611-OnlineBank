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

public class Loan extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 343);
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
		
		JButton btnNewLoan = new JButton("New Loan");
		btnNewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestLoan Request = new RequestLoan();
				Request.setVisible(true);
			}
		});
		btnNewLoan.setBounds(35, 229, 93, 31);
		contentPane.add(btnNewLoan);
		
		JTextPane txtpnTest = new JTextPane();
		txtpnTest.setText("test");
		txtpnTest.setEditable(false);
		txtpnTest.setBounds(35, 76, 364, 119);
		contentPane.add(txtpnTest);
		
		JButton btnRepayment = new JButton("Repayment");
		btnRepayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Repayment tmp = new Repayment(txtpnTest.getSelectedText());
				tmp.setVisible(true);
			}
		});
		btnRepayment.setBounds(165, 229, 103, 31);
		contentPane.add(btnRepayment);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(306, 229, 93, 31);
		contentPane.add(btnBack);
		
		
	}

}
