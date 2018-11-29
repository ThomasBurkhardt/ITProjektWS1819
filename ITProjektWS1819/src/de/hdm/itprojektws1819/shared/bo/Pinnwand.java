package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Pinnwand extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Erstellungszeitpunkt der Pinnwand
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Fremdschlüsselbeziehung zum Ersteller der Pinnwand
	 */
	private int nutzerID = 0;

	/**
	 * Auslesen des Erstellungszeitpunkts
	 * 
	 * @return erstellungszeitpunkt
	 */
	public Date getErstellungszeitpunkt() {
		return erstellungszeitpunkt;
	}

	/**
	 * Setzen des Erstellungszeitpunkts
	 * 
	 * @param erstellungszeitpunkt
	 */
	public void setErstellungszeitpunkt(Date erstellungszeitpunkt) {
		this.erstellungszeitpunkt = erstellungszeitpunkt;
	}

	/**
	 * Auslesen der ID des Nutzers
	 * 
	 * @return nutzerID
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Nutzers
	 * 
	 * @param nutzerID
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

}
