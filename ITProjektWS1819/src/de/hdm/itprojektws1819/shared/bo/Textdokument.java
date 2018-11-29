package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Textdokument extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Erstellungszeitpunkt des Textes
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Inhalt des Textes
	 */
	private String text = "";

	/**
	 * Fremdschlüsselbeziehung zum Ersteller des Textes
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
	 * Auslesen des Textes
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setzen des Textes
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Auslesen des Nutzers, der den Text erstellt hat
	 * 
	 * @return nutzerID
	 */
	public int getNutzerID() {
		return nutzerID;
	}

	/**
	 * Setzen des Nutzers, der den Text erstellt hat
	 * 
	 * @param nutzerID
	 */
	public void setNutzerID(int nutzerID) {
		this.nutzerID = nutzerID;
	}

}
