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
import model.AUTEUR;
import model.GENRE;
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
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListModel;

public class View_ListLivres {

	private JFrame frame;
	private JTextField textField_ISBN_searchbar;
	private JTextField textField_inf_price;
	private JTextField textField_sup_price;
	private JTextField textField;
	private JTextField textField_Auteur_Nom;
	private JTextField textField_Auteur_Prenom;
	private static model model;
	private JTextField textField_3;
	private JTextField textField_4;	
	private DefaultListModel<String> listModel;
    private JList<String> list;


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
	 * @wbp.parser.entryPoint
	 */

	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(550, 150, 909, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		textField_ISBN_searchbar = new JTextField();
		textField_ISBN_searchbar.setBounds(88, 95, 164, 20);
		frame.getContentPane().add(textField_ISBN_searchbar);
		textField_ISBN_searchbar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN :");
		lblNewLabel.setBounds(29, 95, 37, 19);
		frame.getContentPane().add(lblNewLabel);
		
		textField_inf_price = new JTextField();
		textField_inf_price.setBounds(88, 185, 40, 20);
		frame.getContentPane().add(textField_inf_price);
		textField_inf_price.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prix min :");
		lblNewLabel_1.setBounds(29, 185, 55, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix max :");
		lblNewLabel_1_1.setBounds(147, 185, 60, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_sup_price = new JTextField();
		textField_sup_price.setBounds(212, 185, 40, 20);
		textField_sup_price.setColumns(10);
		frame.getContentPane().add(textField_sup_price);
		
		textField = new JTextField();
		textField.setBounds(88, 140, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_title_searchBar = new JLabel("Titre :");
		lblNewLabel_title_searchBar.setBounds(29, 143, 37, 14);
		frame.getContentPane().add(lblNewLabel_title_searchBar);
		
		JLabel lblNewLabel_2 = new JLabel("Auteurs");
		lblNewLabel_2.setBounds(108, 255, 84, 32);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom :");
		lblNewLabel_3.setBounds(29, 300, 55, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom :");
		lblNewLabel_4.setBounds(29, 330, 55, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_Auteur_Nom = new JTextField();
		textField_Auteur_Nom.setBounds(88, 296, 164, 20);
		frame.getContentPane().add(textField_Auteur_Nom);
		textField_Auteur_Nom.setColumns(10);
		
		textField_Auteur_Prenom = new JTextField();
		textField_Auteur_Prenom.setBounds(88, 328, 164, 20);
		textField_Auteur_Prenom.setColumns(10);
		frame.getContentPane().add(textField_Auteur_Prenom);
		
		JLabel lblNewLabel_2_1 = new JLabel("Livres");
		lblNewLabel_2_1.setBounds(118, 50, 65, 32);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_genre = new JLabel("Genre :");
		lblNewLabel_genre.setBounds(29, 231, 46, 14);
		frame.getContentPane().add(lblNewLabel_genre);
		

		JComboBox<String> comboBox_genre = new JComboBox<>();
		comboBox_genre.setBounds(88, 227, 164, 22);
		frame.getContentPane().add(comboBox_genre);
		comboBox_genre.addItem("");
		ArrayList<GENRE> genres = mainMVC.getM().getListGenre();

		for (GENRE genre : genres) {
		    comboBox_genre.addItem(genre.getLibelle());
		}
		
		JButton btnNewButton_Search = new JButton("Chercher");
		btnNewButton_Search.setBounds(103, 385, 95, 31);
		frame.getContentPane().add(btnNewButton_Search);
		btnNewButton_Search.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        String isbn = textField_ISBN_searchbar.getText();
		        String titre = textField.getText().toLowerCase();
		        String minPrixStr = textField_inf_price.getText();
		        String maxPrixStr = textField_sup_price.getText();
		        String AuteurNom = textField_Auteur_Nom.getText();
		        String AuteurPrenom = textField_Auteur_Prenom.getText();
		        String selectedGenre = (String) comboBox_genre.getSelectedItem();
	        
		        ArrayList<LIVRE> filteredList = new ArrayList<>();
		        for (LIVRE livre : mainMVC.getM().getListLivre()) {
		        	AUTEUR auteur = livre.getauteur();
		        	GENRE genre = livre.getGenre();
		            if ((isbn.isEmpty() || livre.getISBN().contains(isbn))
		            	&& (titre.isEmpty() || livre.getTitre().toLowerCase().contains(titre))
		                && (minPrixStr.isEmpty() || livre.getPrix() >= Integer.parseInt(minPrixStr))
		                && (maxPrixStr.isEmpty() || livre.getPrix() <= Integer.parseInt(maxPrixStr))
		                && (AuteurNom.isEmpty() || (auteur != null && auteur.getNom().toLowerCase().contains(AuteurNom.toLowerCase())))
		                && (AuteurPrenom.isEmpty() || (auteur != null && auteur.getPrenom().toLowerCase().contains(AuteurPrenom.toLowerCase())))
		                && (selectedGenre == null || selectedGenre.isEmpty() || genre.getLibelle().equals(selectedGenre))) {
	                    filteredList.add(livre);
		            }
		        }
		        
		        // Update JList 
		        SwingUtilities.invokeLater(() -> {
		            listModel.clear();
		            for (LIVRE livre : filteredList) {
		                listModel.addElement(livre.Ligne());
		            }
		        });
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

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setBounds(275, 29, 593, 315);
		
		for (int i = 0; i != mainMVC.getM().getListLivre().size(); i++) {
            listModel.addElement(mainMVC.getM().getListLivre().get(i).Ligne());
        }
		
		frame.getContentPane().add(list);
		
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
		
		
	
		// Limiter Livres
		
		int nbLivres = (int) Session.getAttribute("nbLivres");
		if(nbLivres>=5) {
			
		}else {
		
		JButton btnNewButton_Emprunter = new JButton("Emprunter");
		btnNewButton_Emprunter.setBounds(757, 390, 105, 31);
		btnNewButton_Emprunter.setVisible(true);
		btnNewButton_Emprunter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String Adherent = textField_4.getText();
		        String ISBN = textField_3.getText();
		        boolean livreDisponible = true;
		        boolean livreExiste = false;

		        try {
		            for (int i = 0; i < mainMVC.getM().getListLivre().size(); i++) {
		                LIVRE livre = mainMVC.getM().getListLivre().get(i);

		                if (livre.getadherent() != null) {
		                    livreDisponible = true;
		                }

		                if (livre.getISBN().equals(ISBN)) {
		                    livreExiste = true;
		                }
		            }

		            if (livreExiste) {
		                if (livreDisponible) {
		                    mainMVC.getM().emprunterLivre(ISBN, Adherent);
		                    mainMVC.getM().historique_Livre_emprunter(ISBN);
		                    model.getall();
		                    System.out.println("Livre emprunté avec succès");
		                    
		                    
		                    SwingUtilities.invokeLater(() -> {
		                        listModel.clear();
		                        for (int i = 0; i != mainMVC.getM().getListLivre().size(); i++) {
		                            listModel.addElement(mainMVC.getM().getListLivre().get(i).Ligne());
		                        }
		                    });
		                    
		                } else {
		                    System.out.println("Livre non disponible, déjà emprunté");
		                }
		            } else {
		                System.out.println("Livre n'existe pas");
		            }

		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
	    });
		frame.getContentPane().add(btnNewButton_Emprunter);
		}
	} 
}
