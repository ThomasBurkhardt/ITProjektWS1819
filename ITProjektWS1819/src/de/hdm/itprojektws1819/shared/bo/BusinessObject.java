package de.hdm.itprojektws1819.shared.bo;

import java.io.Serializable;


/**
 * Die Klasse <code>BusinessObject</code> stellt die Basisklasse aller in diesem
 * Projekt für die Umsetzung des Fachkonzepts relevanten Klassen dar.
 * 
 * @author Thomas Burkhardt in Anlehnung an das Bankprojekt
 * @version 1.0
 */
public abstract class BusinessObject implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Die eindeutige Identifikationsnummer einer Instanz dieser Klasse.
	 */
	private int id = 0;

	/**
	 * Auslesen der ID.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Setzen der ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz.
	 */
	public String toString() {
		return this.getClass().getName() + " #" + this.id;
	}

	/**
	 * Festellen der inhaltlichen <em>inhaltlichen</em> Gleichheit zweier
	 * <code>BusinessObject</code>-Objekte.
	 */
	public boolean equals(Object o) {

		if (o != null && o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) o;
			try {
				if (bo.getId() == this.id)
					return true;
			} catch (IllegalArgumentException e) {
				return false;
			}

		}
		return false;
	}

	/**
	 * <p>
	 * Erzeugen einer ganzen Zahl, die für das <code>BusinessObject</code>
	 * charakteristisch ist.
	 * </p>
	 */
	public int hashCode() {
		return this.id;
	}

}
