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
	private JButton btnConfirm;
	private JButton btnCancel;

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
		textField_Amount.setBounds(110, 122, 205, 21);
		contentPane.add(textField_Amount);
		textField_Amount.setColumns(10);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(110, 190, 93, 23);
		contentPane.add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(222, 190, 93, 23);
		contentPane.add(btnCancel);
		
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
	/*
	private JTextField textField_Amount;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtRmb;
	private JButton btnConfirm;
	private JButton btnCancel;
	 */

	public String getAmount(){
		return textField_Amount.getText();
	}

	public String getLoanInfo(){
		return txtRmb.getText();
	}

	public void addConfirmListener(ActionListener actionListener){
		btnConfirm.addActionListener(actionListener);
	}

	public void addCancelListener(ActionListener actionListener){
		btnCancel.addActionListener(actionListener);
	}

}
