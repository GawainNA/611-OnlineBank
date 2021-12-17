package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class OpenAccount extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnChecking;
	private JRadioButton rdbtnSavings;
	private JRadioButton rdbtnSecurity;
	private JButton btnOpen;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenAccount frame = new OpenAccount();
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
	public OpenAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Open New Account");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(130, 10, 191, 24);
		contentPane.add(lblHeadline);
		
		rdbtnChecking = new JRadioButton("Checking Account");
		buttonGroup.add(rdbtnChecking);
		rdbtnChecking.setBounds(17, 57, 132, 23);
		contentPane.add(rdbtnChecking);
		
		rdbtnSavings = new JRadioButton("Savings Account");
		buttonGroup.add(rdbtnSavings);
		rdbtnSavings.setBounds(151, 57, 121, 23);
		contentPane.add(rdbtnSavings);
		
		rdbtnSecurity = new JRadioButton("Security Account");
		buttonGroup.add(rdbtnSecurity);
		rdbtnSecurity.setBounds(274, 57, 139, 23);
		contentPane.add(rdbtnSecurity);
		
		btnOpen = new JButton("Open");
		btnOpen.setBounds(73, 115, 93, 23);
		contentPane.add(btnOpen);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(258, 115, 93, 23);
		contentPane.add(btnCancel);
	}
	/*
		private JRadioButton rdbtnChecking;
	private JRadioButton rdbtnSavings;
	private JRadioButton rdbtnSecurity;
	private JButton btnOpen;
	private JButton btnCancel;
	 */

	public boolean isCheckingSelected(){
		return rdbtnChecking.isSelected();
	}

	public boolean isSavingSelected(){
		return rdbtnSavings.isSelected();
	}

	public boolean isSecuritySelected(){
		return rdbtnSecurity.isSelected();
	}

	public void addOpenListener(ActionListener actionListener){
		btnOpen.addActionListener(actionListener);
	}

	public void addCancelListener(ActionListener actionListener){
		btnCancel.addActionListener(actionListener);
	}

	public void showMessage(String message){
		JOptionPane.showMessageDialog(this,message);
	}
}
