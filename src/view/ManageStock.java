package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ManageStock extends JFrame {

	private JPanel contentPane;
	private JButton btnUpdateInfo;
	private JButton btnBack;
	private JTextArea textArea_StockMarket;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStock frame = new ManageStock();
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
	public ManageStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Stock Market");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(159, 10, 109, 15);
		contentPane.add(lblNewLabel_1);
		
		btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.setBounds(10, 260, 109, 23);
		contentPane.add(btnUpdateInfo);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(331, 260, 93, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 57, 414, 164);
		contentPane.add(scrollPane_1);
		
		textArea_StockMarket = new JTextArea();
		textArea_StockMarket.setEditable(false);
		scrollPane_1.setViewportView(textArea_StockMarket);
	}

	/*
	private JButton btnUpdateInfo;
	private JButton btnActiveStock;
	private JButton btnRemove;
	private JButton btnBack;
	private JTextArea textArea_activedStocks;
	private JTextArea textArea_StockMarket;
	 */

	public void addUpdateInfoListener(ActionListener actionListener){
		btnUpdateInfo.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void setStockMarket(String Info){
		textArea_StockMarket.setText(Info);
	}
}
