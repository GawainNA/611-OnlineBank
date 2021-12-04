package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUP {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_Addr;
	private JTextField textField_Email;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_Phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP window = new SignUP();
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
	public SignUP() {
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
		frame.setBounds(100, 100, 450, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(169, 10, 86, 15);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(31, 42, 54, 15);
		frame.getContentPane().add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(79, 39, 93, 21);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(205, 42, 54, 15);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(31, 85, 54, 15);
		frame.getContentPane().add(lblAddress);
		
		textField_Addr = new JTextField();
		textField_Addr.setBounds(117, 82, 249, 21);
		frame.getContentPane().add(textField_Addr);
		textField_Addr.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 131, 54, 15);
		frame.getContentPane().add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(117, 128, 249, 21);
		frame.getContentPane().add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(31, 177, 71, 15);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 174, 249, 21);
		frame.getContentPane().add(passwordField);
		
		JRadioButton rdbtn_Male = new JRadioButton("Male");
		buttonGroup.add(rdbtn_Male);
		rdbtn_Male.setBounds(251, 38, 54, 23);
		frame.getContentPane().add(rdbtn_Male);
		
		JRadioButton rdbtn_Female = new JRadioButton("Female");
		buttonGroup.add(rdbtn_Female);
		rdbtn_Female.setBounds(307, 38, 71, 23);
		frame.getContentPane().add(rdbtn_Female);
		
		JLabel lblNewLabel = new JLabel("Accounts: ");
		lblNewLabel.setBounds(31, 254, 71, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbx_Checking = new JCheckBox("Checking");
		chckbx_Checking.setBounds(117, 250, 80, 23);
		frame.getContentPane().add(chckbx_Checking);
		
		JCheckBox chckbx_Savings = new JCheckBox("Savings");
		chckbx_Savings.setBounds(222, 250, 71, 23);
		frame.getContentPane().add(chckbx_Savings);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(31, 220, 54, 15);
		frame.getContentPane().add(lblPhone);
		
		textField_Phone = new JTextField();
		textField_Phone.setBounds(117, 217, 249, 21);
		frame.getContentPane().add(textField_Phone);
		textField_Phone.setColumns(10);
		
		JButton btn_confirm = new JButton("Confirm");
		btn_confirm.setBounds(79, 310, 93, 23);
		frame.getContentPane().add(btn_confirm);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_cancel.setBounds(273, 310, 93, 23);
		frame.getContentPane().add(btn_cancel);
	}
}
