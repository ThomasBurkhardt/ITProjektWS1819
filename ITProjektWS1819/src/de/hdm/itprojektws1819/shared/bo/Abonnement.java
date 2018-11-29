package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Abonnement extends BusinessObject {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Erstellungszeitpunkt des Abonnements
	 */
	private Date erstellungszeitpunkt = new Date();
	
	/**
	 * Fremdschlüsselbeziehung zum Nutzer
	 */
	private int nutzerID = 0;
	
	/**
	 * Fremdschlüsselbeziehung zur Pinnwand
	 */
	private int pinnwandID = 0;

	/**
	 * Auslesen des Erstellungszeitpunkts
	 * @return erstellungszeitpunkt
	 */
	public Date getErstellungszeitpunkt() {
		return erstellungszeitpunkt;
	}

	/**
	 * Setzen des Erstellungszeitpunkts
	 * @param erstellungszeitpunkt
	 */
	public void setErstellungszeitpunkt(Date erstellungszeitpunkt) {
		this.erstellungszeitpunkt = erstellungszeitpunkt;
	}

	/**
	 * Auslesen des Fremdschlüssels zum Nutzer
	 * @return nutzerID
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Fremdschlüssels zum Nutzer
	 * @param nutzerID
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

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
