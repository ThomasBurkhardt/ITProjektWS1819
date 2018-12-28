package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Beitrag extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Erstellungszeitpunkt des Beitrags
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Inhalt des Beeitrags
	 */
	private String beitragInhalt = "";

	/**
	 * Fremdschlüsselbeziehung zur Pinnwand
	 */
	private int pinnwandID = 0;

	/**
	 * Fremdschlüsselbeziehung zum Nutzer
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
	 * Auslesen des Beitraginhalts
	 * 
	 * @return beitragInhalt
	 */
	public String getBeitragInhalt() {
		return beitragInhalt;
	}

	/**
	 * Setzen des Beitraginhalts
	 * 
	 * @param beitragInhalt
	 */
	public void setBeitragInhalt(String beitragInhalt) {
		this.beitragInhalt = beitragInhalt;
	}

	/**
	 * Auslesen des Fremdschlüssels zur Pinnwand
	 * 
	 * @return pinnwandID
	 */
	public int getPinnwandID() {
		return pinnwandID;
	}

	/**
	 * Setzen des Fremdschlüssels zur Pinnwand
	 * 
	 * @param pinnwandID
	 */
	public void setPinnwandID(int pinnwandID) {
		this.pinnwandID = pinnwandID;
	}

	/**
	 * Auslesen des Fremdschlüssels zum Nutzer
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Fremdschlüssels zum Nutzer
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

}
