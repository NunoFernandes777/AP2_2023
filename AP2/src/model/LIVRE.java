package model;

import controller.mainMVC;
import view.View_CodeBarre_Emprunte;

public class LIVRE {
	private String ISBN;
	private String titre;
	private int prix;
	private ADHERENT adherent ;
	private AUTEUR auteur;
	private GENRE genre;
	
	public LIVRE(String iSBN, String titre, int prix, ADHERENT adherent, AUTEUR auteur, GENRE genre) {
		super();
		this.ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		this.adherent = adherent;
		this.auteur = auteur;
		this.genre = genre;
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public ADHERENT getadherent() {
		return adherent;
	}
	public void setadherent(ADHERENT adherent) {
		this.adherent = adherent;
	}
	public AUTEUR getauteur() {
		return auteur;
	}
	public void setauteur(AUTEUR auteur) {
		this.auteur = auteur;
	}
	public GENRE getGenre() {
		return genre;
	}
	public void setGenre(GENRE genre) {
		this.genre = genre;
	}
	

	public void AFFICHER() {
		System.out.println("Voici les info du livre n°"+ISBN);
		System.out.println("titre : "+titre);
		System.out.println("prix : "+prix);
		if (auteur==null)
			System.out.println("Auteur inconnu");
		else
			System.out.println("nom Auteur :"+auteur.getNom());
		if (adherent==null)
			System.out.println("Livre dispo");
		else
		{
			System.out.println("Livre emprunté par : "+adherent.getNom());
		}
	}
	
	public String Ligne() {
		String str;
		str="ISBN : " + ISBN + " / Titre : " + titre + "";
		if (auteur==null)
			str=str+" de "+"Auteur inconnu";
		else
			str=str+" de "+ auteur.getPrenom()+ " " +auteur.getNom();
		if (adherent==null)
			str=str+" - "+"dispo";
		else
			str=str+" - "+"Non dispo";	
		if (genre==null)
			str=str+" - "+"Genre Inconnu";
		else
			str=str+" / genre : "+ genre.getLibelle();
			str=str+" / Prix : "+ prix;
		return str;
	}


}
