package view;
import controller.mainMVC;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import controller.mainMVC;
import model.ADHERENT;
import model.AUTEUR;
import model.LIVRE;
import model.Session;
import model.model;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JPasswordField;

public class View_Accueil {

	private JFrame frame;
	private JTextField textField_email;
	private JPasswordField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Accueil window = new View_Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Accueil() throws SQLException, ClassNotFoundException {
		mainMVC.getM();
		model.getall();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(550, 150, 909, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biblioteque");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 60));
		lblNewLabel.setBounds(291, 27, 281, 140);
		frame.getContentPane().add(lblNewLabel);
		
		textField_email = new JTextField();
		textField_email.setBounds(250, 194, 375, 43);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_email = new JLabel("email");
		lblNewLabel_email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_email.setBounds(209, 193, 31, 43);
		frame.getContentPane().add(lblNewLabel_email);
		
		textField_password = new JPasswordField();
		textField_password.setBounds(250, 265, 375, 43);
		frame.getContentPane().add(textField_password);
		
		JLabel lblNewLabel_password = new JLabel("password");
		lblNewLabel_password.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_password.setBounds(184, 264, 56, 43);
		frame.getContentPane().add(lblNewLabel_password);
		
		JLabel lblNewLabel_verify = new JLabel("");
		lblNewLabel_verify.setForeground(Color.RED);
		lblNewLabel_verify.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_verify.setBounds(291, 319, 281, 14);
		frame.getContentPane().add(lblNewLabel_verify);
		
		JButton btnConnection = new JButton("connection");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = textField_email.getText();
				String password = textField_password.getText();
				mainMVC.getM().compteconn(email, password);
				
				int typeAdherent = (int) Session.getAttribute("typeAdherent");
				if(typeAdherent == 0) {
					PageCompte f1 = new PageCompte();
					f1.main(null);
				} else {
					AdminPage_Compte f2 = new AdminPage_Compte();
					f2.main(null);
				}

			}
		});
		btnConnection.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnConnection.setBounds(360, 341, 138, 43);
		frame.getContentPane().add(btnConnection);
		
		
	}
}
