package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.mainMVC;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Restituer {

	private JFrame frame;
	private JTextField textField_isbn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Restituer window = new View_Restituer();
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
	public View_Restituer() {
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
		
		JLabel lblNewLabel_resultat = new JLabel("");
		lblNewLabel_resultat.setBounds(344, 288, 179, 29);
		frame.getContentPane().add(lblNewLabel_resultat);
		
		
		
		textField_isbn = new JTextField();
		textField_isbn.setBounds(326, 196, 213, 20);
		frame.getContentPane().add(textField_isbn);
		textField_isbn.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn.setBounds(344, 156, 179, 29);
		frame.getContentPane().add(lblIsbn);
		
		JButton btnNewButton = new JButton("Restituer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = textField_isbn.getText();
				
				try {
					mainMVC.getM().restituer_livre(ISBN);
					mainMVC.getM().historique_Livre_restituer(ISBN);
					lblNewLabel_resultat.setText("Livre Restitue");
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();	
				}
				

			}
		});
		btnNewButton.setBounds(389, 241, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
