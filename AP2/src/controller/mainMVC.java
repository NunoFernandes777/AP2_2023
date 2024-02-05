package controller;

import java.sql.SQLException;

import model.model;
import view.View_Accueil;

public class mainMVC {
	private static model m;


	

	public static model getM() {
		return m;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		m=new model();	
		View_Accueil va = new View_Accueil();

	}

}
