package de.hdm.itprojektws1819.shared.bo;

public class Kommentar extends Textdokument{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschl�sselbeziehung zum Beitrag
	 */
	private int beitragID = 0;

	/**
	 * Auslesen des Fremdschl�ssels zum Beitrag
	 * @return beitragID
	 */
	public int getBeitragID() {
		return beitragID;
	}

	/**
	 * Setzen des Fremdschl�ssels zum Beitrag
	 * @param beitragID
	 */
	public void setBeitragID(int beitragID) {
		this.beitragID = beitragID;
	}
	

}
