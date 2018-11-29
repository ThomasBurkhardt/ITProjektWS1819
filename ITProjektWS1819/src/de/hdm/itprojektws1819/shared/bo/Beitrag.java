package de.hdm.itprojektws1819.shared.bo;

public class Beitrag extends Textdokument {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschlüsselbeziehung zur Pinnwand
	 */
	private int pinnwandID = 0;

	/**
	 * Auslesen des Fremdschlüssels zur Pinnwand
	 * @return pinnwandID
	 */
	public int getPinnwandID() {
		return pinnwandID;
	}

	/**
	 * Setzen des Fremdschlüssels zur Pinnwand
	 * @param pinnwandID
	 */
	public void setPinnwandID(int pinnwandID) {
		this.pinnwandID = pinnwandID;
	}

	
}
