package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Like extends BusinessObject {

	private static final long serialVersionUID = 1l;

	/**
	 * Erstellungszeitpunkt des Likes
	 */
	private Date erstellungszeitpunkt = null;

	/**
	 * Fremdschlüsselbeziehung zum Ersteller
	 */
	private int nutzerID = 0;

	/**
	 * Fremdschlüsselbeziehung zum Beitrag
	 */
	private int beitragID = 0;

	/**
	 * Auslesen des Erstellungszeitpunkts des Likes
	 * 
	 * @return erstellungszeitpunkt
	 */
	public Date getErstellungszeitpunkt() {
		return erstellungszeitpunkt;
	}

	/**
	 * Setzen des Erstellungszeitpunkt des Likes
	 * 
	 * @param erstellungszeitpunkt
	 */
	public void setErstellungszeitpunkt(Date erstellungszeitpunkt) {
		this.erstellungszeitpunkt = erstellungszeitpunkt;
	}

	/**
	 * Auslesen des Fremdschlüssels zum Nutzer
	 * 
	 * @return nutzerID
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Fremdschlüssels zum Nutzer
	 * 
	 * @param nutzerID
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

	/**
	 * Auslesen des Fremdschlüssels zum Beitrag
	 * 
	 * @return beitragID
	 */
	public int getBeitragID() {
		return beitragID;
	}

	/**
	 * Setzen des Fremdschlüssels zum Beitrag
	 * 
	 * @param beitragID
	 */
	public void setBeitragID(int beitragID) {
		this.beitragID = beitragID;
	}

}
