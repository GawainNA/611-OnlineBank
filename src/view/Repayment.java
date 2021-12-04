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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Repayment extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Amount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtRmb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repayment frame = new Repayment("L");
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
	public Repayment(String L) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Repayment");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(166, 10, 98, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(46, 125, 54, 15);
		contentPane.add(lblAmount);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(110, 122, 66, 21);
		contentPane.add(textField_Amount);
		textField_Amount.setColumns(10);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(186, 125, 54, 15);
		contentPane.add(lblCurrency);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(242, 121, 54, 23);
		contentPane.add(comboBox);
		
		JLabel lblAccount = new JLabel("Payment Account: ");
		lblAccount.setBounds(46, 150, 107, 15);
		contentPane.add(lblAccount);
		
		JRadioButton rdbtnChecking = new JRadioButton("Checking");
		buttonGroup.add(rdbtnChecking);
		rdbtnChecking.setBounds(155, 146, 85, 23);
		contentPane.add(rdbtnChecking);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Savings");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(242, 146, 74, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(110, 190, 93, 23);
		contentPane.add(btnConfirm);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(222, 190, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Loan Info");
		lblNewLabel.setBounds(46, 59, 54, 15);
		contentPane.add(lblNewLabel);
		
		txtRmb = new JTextField();
		if(L==null) {
			L="NULL";
		}
		txtRmb.setText(L);
		txtRmb.setEditable(false);
		txtRmb.setBounds(110, 56, 206, 21);
		contentPane.add(txtRmb);
		txtRmb.setColumns(10);
	}

}
