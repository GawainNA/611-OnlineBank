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

public class ManageStock extends JFrame {

	private JPanel contentPane;
	private JButton btnUpdateInfo;
	private JButton btnActiveStock;
	private JButton btnRemove;
	private JButton btnBack;
	private JTextArea textArea_activedStocks;
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
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actived Stocks");
		lblNewLabel.setBounds(10, 21, 93, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stock Market");
		lblNewLabel_1.setBounds(10, 187, 93, 15);
		contentPane.add(lblNewLabel_1);
		
		btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.setBounds(10, 367, 109, 23);
		contentPane.add(btnUpdateInfo);


		btnActiveStock = new JButton("Active Stock");
		btnActiveStock.setBounds(159, 367, 109, 23);
		contentPane.add(btnActiveStock);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(159, 153, 93, 23);
		contentPane.add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(331, 367, 93, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 105);
		contentPane.add(scrollPane);
		
		textArea_activedStocks = new JTextArea();
		scrollPane.setViewportView(textArea_activedStocks);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 215, 414, 127);
		contentPane.add(scrollPane_1);
		
		textArea_StockMarket = new JTextArea();
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

	public void addActiveStockListener(ActionListener actionListener){
		btnActiveStock.addActionListener(actionListener);
	}

	public void addRemoveListener(ActionListener actionListener){
		btnRemove.addActionListener(actionListener);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}

	public void setActiveStocks(String Info){
		textArea_activedStocks.setText(Info);
	}

	public void setStockMarket(String Info){
		textArea_StockMarket.setText(Info);
	}
}
