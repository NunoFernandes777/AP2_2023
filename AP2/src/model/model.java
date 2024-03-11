package model;

import java.awt.dnd.DropTargetContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

import controller.mainMVC;
import view.PageCompte;
import view.View_ListLivres;

public class model {
	

	private static final String id = null;
	private static ArrayList<LIVRE> ListLivre;
	private static ArrayList<AUTEUR> ListAuteur;
	private static ArrayList<ADHERENT> ListAdherent;

	public static ArrayList<LIVRE> getListLivre() {
		return ListLivre;
	}
	public static void setListLivre(ArrayList<LIVRE> listLivre) {
		ListLivre = listLivre;
	}
	public static ArrayList<AUTEUR> getListAuteur() {
		return ListAuteur;
	}
	public static void setListAuteur(ArrayList<AUTEUR> listAuteur) {
		ListAuteur = listAuteur;
	}
	public static ArrayList<ADHERENT> getListAdherent() {
		return ListAdherent;
	}
	public static void setListAdherent(ArrayList<ADHERENT> listAdherent) {
		ListAdherent = listAdherent;
	}
	public static Connection getCon() {
		Connection con;
		String BDD = "2023ap2";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			con = DriverManager.getConnection(url, user, passwd);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public model() {
		ListLivre=new ArrayList<LIVRE> ();
		ListAuteur=new ArrayList<AUTEUR> ();
		ListAdherent=new ArrayList<ADHERENT> ();
	}
	
	public static void getall() throws SQLException
	{
		Connection con;
		ListLivre.clear();
		ListAuteur.clear();
		ListAdherent.clear();

		//on initialise la connection
		con = getCon();

		System.out.println("connection OK");
		java.sql.ResultSet resultats;
		
		String requete5 = "SELECT email,password FROM ADHERENT";
		java.sql.Statement stm5=con.createStatement();
		resultats=stm5.executeQuery(requete5);
		while(resultats.next())
		{
			String email = resultats.getString("email");
			String password = resultats.getString("password");
		}
		
		//********************************************************
		//ON REMPLI NOTRE LISTE DE LIVRE (sans auteur ni adherent)
		//********************************************************

		String requete = "SELECT * FROM LIVRE";
		java.sql.Statement stm=con.createStatement();
		resultats=stm.executeQuery(requete);
		while(resultats.next())
		{
			System.out.println(resultats.getInt("ISBN")+" - "+resultats.getString("titre"));
			LIVRE l = new LIVRE(String.valueOf(resultats.getInt("ISBN")),resultats.getString("titre"),resultats.getInt("prix"), null, null);
			ListLivre.add(l);
		}
		//********************************************************
		//ON REMPLI NOTRE LISTE D'AUTEUR
		//********************************************************
		requete = "SELECT * FROM AUTEUR";
		stm=con.createStatement();
		resultats=stm.executeQuery(requete);
		while(resultats.next())
		{

			AUTEUR a = new AUTEUR(resultats.getString("num"),resultats.getString("nom"),resultats.getString("prenom"),resultats.getString("date_naissance"),resultats.getString("description"));
			ListAuteur.add(a);
		}

		//********************************************************
		//ON REMPLI NOTRE LISTE D'ADHERENT (sans se soucier des livres)
		//********************************************************
		requete = "SELECT * FROM adherent";
		stm=con.createStatement();
		resultats=stm.executeQuery(requete);
		while(resultats.next())
		{
			ADHERENT adherent= new ADHERENT(resultats.getString("num"),resultats.getString("nom"),resultats.getString("prenom"),resultats.getString("email"),resultats.getString("password"));
			ListAdherent.add(adherent);
		}


		//aide mémo pour insérer un nouveau livre
		//requete = "INSERT INTO `livre` (`ISBN`, `titre`, `prix`, `adherent`, `auteur`) VALUES ('11123', 'new livre', '12', '1', '1');";
		//java.sql.Statement stm2=con.createStatement();
		//int maj = stm2.executeUpdate(requete);
		
		
		//********************************************************
		//ON MET A JOUR LA LISTE DE LIVRE AVEC L'AUTEUR
		//********************************************************
		requete = "SELECT ISBN, auteur FROM LIVRE;";
		stm=con.createStatement();
		resultats=stm.executeQuery(requete);

		while(resultats.next())
		{
			String ISBN=resultats.getString("ISBN");
			String num=resultats.getString("auteur");
			LIVRE l=findlivre(ISBN);
			AUTEUR lauteur=findauteur(num);
			if (l != null) {
			    l.setauteur(lauteur);
			}
		}

		
		//********************************************************
		//ON MET A JOUR LA LISTE DE LIVRE AVEC L'EMPRUNTEUR(adhérent
		//ON MET A JOUR LA LISTE DES ADHERENTS AVEC LEUR LISTE DE LIVRE
		//********************************************************
		requete = "SELECT ISBN,adherent FROM `livre`";
		stm=con.createStatement();
		resultats=stm.executeQuery(requete);
		while(resultats.next())
		{
			String ISBN=resultats.getString("ISBN");
			String num=resultats.getString("adherent");
			LIVRE l=findlivre(ISBN);
			ADHERENT ladherent=findadherent(num);

			if(ladherent!=null)
			{
				l.setadherent(ladherent);
				ladherent.ajouterLivre(l);
			}

		}
	}
	
	public static LIVRE findlivre(String ISBN) {
	    for (int i = 0; i != ListLivre.size(); i++) {
	        if (ListLivre.get(i).getISBN().equals(ISBN)) {
	            return ListLivre.get(i);
	        }
	    }
	    return null;
	}

	public static AUTEUR findauteur(String num) {
	    for (int i = 0; i != ListAuteur.size(); i++) {
	        if (ListAuteur.get(i).getNum().equals(num)) {
	            return ListAuteur.get(i);
	        }
	    }
	    return null;
	}

	public static ADHERENT findadherent(String num) {
	    for (int i = 0; i != ListAdherent.size(); i++) {
	        if (ListAdherent.get(i).getNum().equals(num)) {
	            return ListAdherent.get(i);
	        }
	    }
	    return null;
	}
	
	public static boolean compteconn(String email, String password) {
	    try (Connection connection = (Connection) model.getCon()) {
	        String query = "SELECT * FROM adherent WHERE email = ? AND password = ?";
	        try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query)) { 
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {               
	            	

					Session.setAttribute("numAdherent", resultSet.getString("num"));
	                Session.setAttribute("userEmail", email);
	                Session.setAttribute("userNom", resultSet.getString("nom"));
	                Session.setAttribute("userPrenom", resultSet.getString("prenom"));
	                Session.setAttribute("typeAdherent", resultSet.getInt("type"));
	                

	                String countQuery = "SELECT COUNT(*) AS nbLivres FROM livre, adherent WHERE livre.adherent = adherent.num AND adherent.email = ?";
	                try (PreparedStatement countStatement = connection.prepareStatement(countQuery)) {
	                    countStatement.setString(1, email);
	                    ResultSet countResult = countStatement.executeQuery();
	                    if (countResult.next()) {
	                        int nbLivres = countResult.getInt("nbLivres");
	                        Session.setAttribute("nbLivres", nbLivres);
	                  
	                    }
	                }

	                // Open the PageCompte
	                PageCompte pageCompte = new PageCompte();
	                PageCompte.main(null);

	                return true;
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	public static void emprunterLivre(String adherent, String ISBN) throws SQLException {
	    try (Connection connection = model.getCon()) {	
	        String query = "UPDATE LIVRE SET adherent = ? WHERE ISBN = ?";
	        try (PreparedStatement stm = connection.prepareStatement(query)) {
	            stm.setString(1, adherent);
	            stm.setString(2, ISBN);
	            stm.executeUpdate();
	        }
	    } catch (SQLException e) {

	        e.printStackTrace();

	        throw new RuntimeException("Failed to update LIVRE table", e);
	    }
	}
		/*
	public static void emprunter_livre(String ISBN) throws SQLException{
		try (Connection connection = (Connection) model.getCon()) {	
			String query = "INSERT INTO historique_emprunts (ISBN_Livre, num_Adherent, date_emprunt) VALUES (?, ?, CURRENT_DATE)";
			try (PreparedStatement stm = (PreparedStatement) connection.prepareStatement(query)){
				
				stm.setString(1, ISBN);
				stm.setString(2, (String) Session.getAttribute("numAdherent"));
	      
				stm.executeUpdate();
				}
		}
	}
	
	}*/
	public static void restituer_livre(String ISBN) throws SQLException{
		try (Connection connection = (Connection) model.getCon()) {	
			String query = "update LIVRE set adherent = NULL where ISBN = ?";
			try (PreparedStatement stm = (PreparedStatement) connection.prepareStatement(query)){

				stm.setString(1, ISBN);
	      
				stm.executeUpdate();
				}
		}
	}
	
	public static void creer_livre(String ISBN, String titre, float prix) throws SQLException{
		try (Connection connection = (Connection) model.getCon()) {	
			String query = "INSERT INTO livre (ISBN, titre, prix) VALUES (?, ?, ?);";
			try (PreparedStatement stm = (PreparedStatement) connection.prepareStatement(query)){

				stm.setString(1, ISBN);
				stm.setString(2, titre);
				stm.setFloat(3, prix);
	      
				stm.executeUpdate();
				}
		}
	}
	
}
