package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Beitrag extends Textdokument {

	private static final long serialVersionUID = 1L;

	/**
	 * Erstellungszeitpunkt des Beitrags
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Fremdschl�sselbeziehung zur Pinnwand
	 */
	private int pinnwandID = 0;

	/**
	 * Fremdschl�sselbeziehung zum Nutzer
	 */
	private int nutzerID = 0;

	/**
	 * Auslesen des Erstellungszeitpunktes
	 */
	public Date getErstellungszeitpunkt() {
		return erstellungszeitpunkt;
	}

	/**
	 * Setzen des Erstellungszeitpunkts
	 */
	public void setErstellungszeitpunkt(Date erstellungszeitpunkt) {
		this.erstellungszeitpunkt = erstellungszeitpunkt;
	}

	/**
	 * Auslesen des Fremdschl�ssels zur Pinnwand
	 * 
	 * @return pinnwandID
	 */
	public int getPinnwandID() {
		return pinnwandID;
	}

	/**
	 * Setzen des Fremdschl�ssels zur Pinnwand
	 * 
	 * @param pinnwandID
	 */
	public void setPinnwandID(int pinnwandID) {
		this.pinnwandID = pinnwandID;
	}

	/**
	 * Auslesen des Fremdschl�ssels zum Nutzer
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Fremdschl�ssels zum Nutzer
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

}
