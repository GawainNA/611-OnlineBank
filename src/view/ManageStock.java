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

public class ManageStock extends JFrame {

	private JPanel contentPane;

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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 39, 414, 105);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Stock Market");
		lblNewLabel_1.setBounds(10, 187, 93, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 212, 414, 113);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Update Info");
		btnNewButton.setBounds(10, 367, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnActiveStock = new JButton("Active Stock");
		btnActiveStock.setBounds(159, 367, 109, 23);
		contentPane.add(btnActiveStock);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(159, 153, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(331, 367, 93, 23);
		contentPane.add(btnNewButton_2);
	}
}
