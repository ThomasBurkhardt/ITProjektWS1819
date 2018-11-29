package de.hdm.itprojektws1819.shared.bo;

import java.util.Date;

public class Nutzer extends BusinessObject {

	private static final long serialVersionUID = 1L;

	/**
	 * Vorname des Nutzers
	 */
	private String vorname = "";

	/**
	 * Nachname des Nutzers
	 */
	private String nachname = "";

	/**
	 * Nickname des Nutzers
	 */
	private String nickname = "";

	/**
	 * Email-Adresse des Nutzers
	 */
	private String email = "";

	/**
	 * Erstellungszeitpunkt des Nutzers
	 */
	private Date erstellungszeitpunkt = new Date();

	/**
	 * Auslesen des Vornamen
	 * 
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Setzen des Vornamens
	 * 
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Auslesen des Nachnamens
	 * 
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Setzen des Nachnamen
	 * 
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Auslesen des Nicknamens
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Setzen des Nicknamens
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Auslesen der Email-Adresse
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setzen der Email-Adresse
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Auslesen des Erstellungszeitpunkts
	 * 
	 * @param erstellungszeitpunkt
	 */
	public void setErstellungszeitpunkt(Date erstellungszeitpunkt) {
		this.erstellungszeitpunkt = erstellungszeitpunkt;
	}

}
