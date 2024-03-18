package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import com.mysql.jdbc.Connection;

import controller.mainMVC;
import model.LIVRE;
import model.Session;
import model.model;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

public class AdminView_ListLivres {

	private JFrame frame;
	private JTextField textField_ISBN_in;
	private JTextField textField_Prix_in;
	private JTextField textField_titre_in;
	private static model model;
	private DefaultListModel<String> listModel;
    private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView_ListLivres window = new AdminView_ListLivres();
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
	public AdminView_ListLivres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(550, 150, 909, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_ISBN_in = new JTextField();
		textField_ISBN_in.setBounds(88, 165, 164, 20);
		frame.getContentPane().add(textField_ISBN_in);
		textField_ISBN_in.setColumns(10);
		
		JLabel lblNewLabel_ISBN = new JLabel("ISBN :");
		lblNewLabel_ISBN.setBounds(29, 166, 37, 19);
		frame.getContentPane().add(lblNewLabel_ISBN);
		
		textField_Prix_in = new JTextField();
		textField_Prix_in.setBounds(88, 265, 64, 20);
		frame.getContentPane().add(textField_Prix_in);
		textField_Prix_in.setColumns(10);
		
		JLabel lblNewLabel_Prix = new JLabel("Prix :");
		lblNewLabel_Prix.setBounds(29, 265, 55, 20);
		frame.getContentPane().add(lblNewLabel_Prix);
		
		textField_titre_in = new JTextField();
		textField_titre_in.setBounds(88, 215, 164, 20);
		frame.getContentPane().add(textField_titre_in);
		textField_titre_in.setColumns(10);
		
		JLabel lblNewLabel_titre = new JLabel("Titre :");
		lblNewLabel_titre.setBounds(29, 218, 37, 14);
		frame.getContentPane().add(lblNewLabel_titre);
		
		JLabel lblNewLabel_2_1 = new JLabel("Livres");
		lblNewLabel_2_1.setBounds(120, 100, 65, 32);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton_Search = new JButton("Creer Livre");
		btnNewButton_Search.setBounds(95, 325, 110, 31);
		frame.getContentPane().add(btnNewButton_Search);
		btnNewButton_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	String ISBN = textField_ISBN_in.getText();
            	String titre = textField_titre_in.getText();
            	float prix = Float.parseFloat(textField_Prix_in.getText()) ;
            	
            	try {
					mainMVC.getM().creer_livre(ISBN, titre, prix);
					model.getall();
					
					SwingUtilities.invokeLater(() -> {
                        listModel.clear();
                        for (int i = 0; i != mainMVC.getM().getListLivre().size(); i++) {
                            listModel.addElement(mainMVC.getM().getListLivre().get(i).Ligne());
                        }
                    });
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		
		
		JButton btnNewButton_Back = new JButton("<=");
		btnNewButton_Back.setBounds(20, 11, 50, 25);
		btnNewButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage_Compte f1 = new AdminPage_Compte();
                AdminPage_Compte.main(null);
			}
		});
		btnNewButton_Back.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(btnNewButton_Back);

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setBounds(302, 24, 566, 392);
		
		for (int i = 0; i != mainMVC.getM().getListLivre().size(); i++) {
            listModel.addElement(mainMVC.getM().getListLivre().get(i).Ligne());
        }
		
		frame.getContentPane().add(list);
			
	}

}
