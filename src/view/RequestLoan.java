package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestLoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_amount;
	private JTextField textField_collateral;
	private JTextField textField_TimeLimt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestLoan frame = new RequestLoan();
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
	public RequestLoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Request A New Loan");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(115, 10, 196, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(49, 74, 54, 15);
		contentPane.add(lblAmount);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(100, 71, 66, 21);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(201, 74, 54, 15);
		contentPane.add(lblCurrency);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(277, 70, 54, 23);
		contentPane.add(comboBox);
		
		JLabel lblCollateral = new JLabel("Collateral");
		lblCollateral.setBounds(49, 119, 76, 15);
		contentPane.add(lblCollateral);
		
		textField_collateral = new JTextField();
		textField_collateral.setBounds(120, 116, 66, 21);
		contentPane.add(textField_collateral);
		textField_collateral.setColumns(10);
		
		JLabel lblTimeLimit = new JLabel("Time Limt");
		lblTimeLimit.setBounds(201, 119, 66, 15);
		contentPane.add(lblTimeLimit);
		
		JComboBox comboBox_TimeUnit = new JComboBox();
		comboBox_TimeUnit.setModel(new DefaultComboBoxModel(new String[] {"Month(s)", "Year(s)"}));
		comboBox_TimeUnit.setBounds(348, 115, 76, 23);
		contentPane.add(comboBox_TimeUnit);
		
		textField_TimeLimt = new JTextField();
		textField_TimeLimt.setBounds(263, 116, 66, 21);
		contentPane.add(textField_TimeLimt);
		textField_TimeLimt.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(93, 174, 93, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(249, 174, 93, 23);
		contentPane.add(btnCancel);
	}

}
