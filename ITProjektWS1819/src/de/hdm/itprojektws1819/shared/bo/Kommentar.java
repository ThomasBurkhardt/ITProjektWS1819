package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Kommentar extends Textdokument{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fremdschlüsselbeziehung zum Beitrag
	 */
	private int beitragID = 0;
	
	/**
	 * Erstellungszeitpunkt des Kommentars
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Auslesen des Fremdschlüssels zum Beitrag
	 * @return beitragID
	 */
	public int getBeitragID() {
		return beitragID;
	}

	/**
	 * Setzen des Fremdschlüssels zum Beitrag
	 * @param beitragID
	 */
	public void setBeitragID(int beitragID) {
		this.beitragID = beitragID;
	}
	
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
	

}
