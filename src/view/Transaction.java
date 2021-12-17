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

public class Transaction extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextArea textArea_Log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
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
	public Transaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transactions Log");
		lblNewLabel.setBounds(10, 34, 118, 15);
		contentPane.add(lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(331, 257, 93, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 414, 159);
		contentPane.add(scrollPane);
		
		textArea_Log = new JTextArea();
		textArea_Log.setEditable(false);
		scrollPane.setViewportView(textArea_Log);
	}

	public void setLog(String info){
		textArea_Log.setText(info);
	}

	public void addBackListener(ActionListener actionListener){
		btnBack.addActionListener(actionListener);
	}
}
