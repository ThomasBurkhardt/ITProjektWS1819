package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Like extends BusinessObject {

	private static final long serialVersionUID = 1l;

	/**
	 * Erstellungszeitpunkt des Likes
	 */
	private Date erstellungszeitpunkt = null;

	/**
	 * Fremdschl�sselbeziehung zum Ersteller
	 */
	private int nutzerID = 0;

	/**
	 * Fremdschl�sselbeziehung zum Beitrag
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
	 * Auslesen des Fremdschl�ssels zum Nutzer
	 * 
	 * @return nutzerID
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Fremdschl�ssels zum Nutzer
	 * 
	 * @param nutzerID
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

	/**
	 * Auslesen des Fremdschl�ssels zum Beitrag
	 * 
	 * @return beitragID
	 */
	public int getBeitragID() {
		return beitragID;
	}

	/**
	 * Setzen des Fremdschl�ssels zum Beitrag
	 * 
	 * @param beitragID
	 */
	public void setBeitragID(int beitragID) {
		this.beitragID = beitragID;
	}

}
