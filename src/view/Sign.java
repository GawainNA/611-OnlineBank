package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Sign {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textfield_username;
	private JButton button_sign_in;
	private JButton button_sign_up;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign window = new Sign();
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
	public Sign() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_welcome = new JLabel("Welcome to Auto Online Bank");
		label_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		label_welcome.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		label_welcome.setBounds(10, 10, 414, 38);
		frame.getContentPane().add(label_welcome);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName.setBounds(41, 86, 77, 15);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(41, 142, 77, 15);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 140, 213, 21);
		frame.getContentPane().add(passwordField);
		
		textfield_username = new JTextField();
		textfield_username.setBounds(115, 84, 213, 21);
		frame.getContentPane().add(textfield_username);
		textfield_username.setColumns(10);
		
		button_sign_in = new JButton("Sign in");
		button_sign_in.setBounds(115, 195, 93, 23);
		frame.getContentPane().add(button_sign_in);
		
		button_sign_up = new JButton("Sign up");
		button_sign_up.setBounds(235, 195, 93, 23);
		frame.getContentPane().add(button_sign_up);
	}

	public void addSignListener(ActionListener actionListener){
		button_sign_in.addActionListener(actionListener);
	}

	public void addSignUpListener(ActionListener actionListener){
		button_sign_up.addActionListener(actionListener);
	}

	public String getUsername(){
		return textfield_username.getText();
	}

	public String getPassword(){
		return String.valueOf(passwordField.getPassword());
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(frame, message);
	}



}
