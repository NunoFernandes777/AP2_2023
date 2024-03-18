package model;

public class GENRE {
	private int num;
	private String libelle;
	
	public GENRE(int num, String libelle) {
		super();
		this.num = num;
		this.libelle = libelle;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String LigneGenre() {
		String str;
		str=""+ libelle +"";
		return str;
	}
	
}
