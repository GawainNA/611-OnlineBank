package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(65, 70, 54, 15);
		contentPane.add(lblAmount);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(115, 67, 80, 21);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblHeadline = new JLabel("Deposit");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(166, 10, 96, 21);
		contentPane.add(lblHeadline);
		
		JLabel lblNewLabel = new JLabel("Currency");
		lblNewLabel.setBounds(219, 70, 54, 15);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"USD", "JPY", "RMB", "GBP", "EUR"}));
		comboBox.setBounds(283, 66, 54, 23);
		contentPane.add(comboBox);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(95, 132, 93, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(239, 132, 93, 23);
		contentPane.add(btnCancel);
	}

}
