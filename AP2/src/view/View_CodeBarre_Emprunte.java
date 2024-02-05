package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class View_CodeBarre_Emprunte {

	private JFrame frame;
	private JTable table_EmprunterLivre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_CodeBarre_Emprunte window = new View_CodeBarre_Emprunte();
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
	public View_CodeBarre_Emprunte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(550, 150, 909, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_Titre = new JLabel("Emprunter par code barre");
		lblNewLabel_Titre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Titre.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_Titre.setBounds(250, 25, 400, 90);
		frame.getContentPane().add(lblNewLabel_Titre);
		
		JLabel lblNewLabel_Description = new JLabel("Scannez le code Barre");
		lblNewLabel_Description.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_Description.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Description.setBounds(250, 126, 400, 30);
		frame.getContentPane().add(lblNewLabel_Description);
		
		table_EmprunterLivre = new JTable();
		table_EmprunterLivre.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		table_EmprunterLivre.setBounds(200, 225, 500, 100);
		frame.getContentPane().add(table_EmprunterLivre);
		
		JButton btnNewButton_Back = new JButton("<=");
		btnNewButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageCompte f1 = new PageCompte();
                PageCompte.main(null);
			}
		});
		btnNewButton_Back.setBounds(20, 11, 50, 25);
		frame.getContentPane().add(btnNewButton_Back);
		
		JButton btnNewButton_Emprunter = new JButton("Emprunter");
		btnNewButton_Emprunter.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_Emprunter.setBounds(550, 375, 125, 30);
		frame.getContentPane().add(btnNewButton_Emprunter);
		
		JButton btnNewButton_Reessayer = new JButton("Reessayer");
		btnNewButton_Reessayer.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_Reessayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Reessayer.setBounds(225, 375, 125, 30);
		frame.getContentPane().add(btnNewButton_Reessayer);
	}
}
