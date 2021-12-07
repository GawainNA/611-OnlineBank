package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Realized;
	private JTextField textField_Unrealized;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Stocks Management");
		lblHeadline.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHeadline.setBounds(134, 10, 176, 24);
		contentPane.add(lblHeadline);
		
		JLabel lblYourStocks = new JLabel("Your Stocks");
		lblYourStocks.setBounds(31, 48, 82, 15);
		contentPane.add(lblYourStocks);
		
		JTextArea txtrYourStocks = new JTextArea();
		txtrYourStocks.setText("Apple  1000  USD");
		txtrYourStocks.setEditable(false);
		txtrYourStocks.setBounds(31, 75, 371, 80);
		contentPane.add(txtrYourStocks);
		
		JLabel lblRealizedProfit = new JLabel("Realized Profit");
		lblRealizedProfit.setBounds(144, 48, 96, 15);
		contentPane.add(lblRealizedProfit);
		
		textField_Realized = new JTextField();
		textField_Realized.setText("1000");
		textField_Realized.setEditable(false);
		textField_Realized.setBounds(244, 45, 66, 21);
		contentPane.add(textField_Realized);
		textField_Realized.setColumns(10);
		
		JLabel lblUnrealized = new JLabel("Unrealized Profit");
		lblUnrealized.setBounds(221, 168, 114, 15);
		contentPane.add(lblUnrealized);
		
		textField_Unrealized = new JTextField();
		textField_Unrealized.setText("122");
		textField_Unrealized.setEditable(false);
		textField_Unrealized.setBounds(336, 165, 66, 21);
		contentPane.add(textField_Unrealized);
		textField_Unrealized.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Availiable Stocks");
		lblNewLabel.setBounds(31, 241, 119, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(168, 376, 93, 23);
		contentPane.add(btnBuy);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(168, 193, 93, 23);
		contentPane.add(btnSell);
		
		JButton btnNewBack = new JButton("Back");
		btnNewBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewBack.setBounds(309, 443, 93, 23);
		contentPane.add(btnNewBack);
		
		JTextArea txtrAvailiableStocks = new JTextArea();
		txtrAvailiableStocks.setEditable(false);
		txtrAvailiableStocks.setText("Apple  878  USD");
		txtrAvailiableStocks.setBounds(31, 276, 371, 86);
		contentPane.add(txtrAvailiableStocks);
	}

}
