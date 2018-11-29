package de.hdm.itprojektws1819.shared.bo;

public class Beitrag extends Textdokument {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschl�sselbeziehung zur Pinnwand
	 */
	private int pinnwandID = 0;

	/**
	 * Auslesen des Fremdschl�ssels zur Pinnwand
	 * @return pinnwandID
	 */
	public int getPinnwandID() {
		return pinnwandID;
	}

	/**
	 * Setzen des Fremdschl�ssels zur Pinnwand
	 * @param pinnwandID
	 */
	public void setPinnwandID(int pinnwandID) {
		this.pinnwandID = pinnwandID;
	}

	
}
