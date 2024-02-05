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

public class View_ListLivres {

	private JFrame frame;
	private JTextField textField_ISBN_searchbar;
	private JTextField textField_inf_price;
	private JTextField textField_sup_price;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static model model;
	private JTextField textField_3;
	private JTextField textField_4;
    

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	View_ListLivres window = new View_ListLivres();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public View_ListLivres() {
		try {
			model.getall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
		textField_ISBN_searchbar = new JTextField();
		textField_ISBN_searchbar.setBounds(88, 106, 164, 20);
		frame.getContentPane().add(textField_ISBN_searchbar);
		textField_ISBN_searchbar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN :");
		lblNewLabel.setBounds(29, 107, 37, 19);
		frame.getContentPane().add(lblNewLabel);
		
		textField_inf_price = new JTextField();
		textField_inf_price.setBounds(88, 195, 40, 20);
		frame.getContentPane().add(textField_inf_price);
		textField_inf_price.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prix min :");
		lblNewLabel_1.setBounds(29, 195, 55, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix max :");
		lblNewLabel_1_1.setBounds(147, 195, 60, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_sup_price = new JTextField();
		textField_sup_price.setBounds(212, 195, 40, 20);
		textField_sup_price.setColumns(10);
		frame.getContentPane().add(textField_sup_price);
		
		textField = new JTextField();
		textField.setBounds(88, 153, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_title_searchBar = new JLabel("Titre :");
		lblNewLabel_title_searchBar.setBounds(29, 156, 37, 14);
		frame.getContentPane().add(lblNewLabel_title_searchBar);
		
		JLabel lblNewLabel_2 = new JLabel("Auteurs");
		lblNewLabel_2.setBounds(107, 240, 84, 32);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NOM :");
		lblNewLabel_3.setBounds(29, 300, 55, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom :");
		lblNewLabel_4.setBounds(20, 330, 64, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 296, 164, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 328, 164, 20);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Livres");
		lblNewLabel_2_1.setBounds(118, 57, 65, 32);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton_Search = new JButton("Chercher");
		btnNewButton_Search.setBounds(103, 385, 95, 31);
		frame.getContentPane().add(btnNewButton_Search);
		btnNewButton_Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
      
            }
        });
		
		
		
		JButton btnNewButton_Back = new JButton("<=");
		btnNewButton_Back.setBounds(20, 11, 50, 25);
		btnNewButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageCompte f1 = new PageCompte();
                PageCompte.main(null);
			}
		});
		btnNewButton_Back.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(btnNewButton_Back);
		
		JLabel lblNewLabel_emprunteYES = new JLabel("");
		lblNewLabel_emprunteYES.setBounds(724, 417, 138, 14);
		lblNewLabel_emprunteYES.setForeground(new Color(0, 128, 0));
		lblNewLabel_emprunteYES.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_emprunteYES);
		
		JLabel lblNewLabel_emprunteNO = new JLabel("");
		lblNewLabel_emprunteNO.setBounds(724, 417, 138, 14);
		lblNewLabel_emprunteNO.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_emprunteNO.setForeground(new Color(255, 0, 0));
		frame.getContentPane().add(lblNewLabel_emprunteNO);
		
		List list = new List();
		list.setBounds(333, 29, 535, 315);
		frame.getContentPane().add(list);
		
		for (int i=0; i!=mainMVC.getM().getListLivre().size()/3;i++) {
			list.add(
					mainMVC.getM().getListLivre().get(i).Ligne()
					);
		}
		
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(646, 396, 84, 20);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		

		
		textField_4 = new JTextField();
		textField_4.setBounds(460, 396, 84, 20);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("ISBN :");
		lblNewLabel_5.setBounds(413, 397, 37, 19);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_title_searchBar_1 = new JLabel("Adherent :");
		lblNewLabel_title_searchBar_1.setBounds(576, 399, 60, 14);
		frame.getContentPane().add(lblNewLabel_title_searchBar_1);
		
		
		
		JLabel lblNewLabel_requeteResultat = new JLabel("");
		lblNewLabel_requeteResultat.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_requeteResultat.setBounds(333, 350, 535, 24);
		frame.getContentPane().add(lblNewLabel_requeteResultat);
		
		JButton btnNewButton_Emprunter = new JButton("Emprunter");
		btnNewButton_Emprunter.setBounds(757, 390, 105, 31);
		btnNewButton_Emprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num = textField_3.getText();
				String ISBN = textField_4.getText();
				
				try {
					for (int i=0; i!=mainMVC.getM().getListLivre().size()/3;i++) {
						if(mainMVC.getM().getListLivre().get(i).getadherent() != null) {
							System.out.println("livre non disponible");
						}else {
							
						}
						if(mainMVC.getM().getListLivre().get(i).getISBN() != ISBN){
							System.out.println("livre non existe");
						}
							else {
							
							mainMVC.getM().emprunter_livre(num, ISBN);
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();	
				}

			}
		});
		frame.getContentPane().add(btnNewButton_Emprunter);
		       
    }
}
