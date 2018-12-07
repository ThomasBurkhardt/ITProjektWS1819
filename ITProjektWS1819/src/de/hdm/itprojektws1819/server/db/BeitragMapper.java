package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojektws1819.shared.bo.Beitrag;
import de.hdm.itprojektws1819.shared.bo.Nutzer;

public class BeitragMapper {

	private static BeitragMapper beitragMapper = null;
	
	protected BeitragMapper() {
	}
	
	public static BeitragMapper beitragMapper() {
		if (beitragMapper == null) {
			beitragMapper = new BeitragMapper();
		}
		
		return beitragMapper;
	}
	
	/**
	 * Suchen eines Beitrags über die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zurückgegeben.
	 * 
	 * @param id
	 * @return Beitrags-Objekt, das dem übergebenen Schlüssel entspricht, null bei
	 *         nicht vorhandenem DB-Tupel
	 */
	public Beitrag findBeitragByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, erstellungszeitpunkt, pinnwandID  FROM beitrag " + "WHERE id=" + id + " ORDER BY id");

			/*
			 * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
			 * werden. Prüfe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Beitrag b = new Beitrag();
				b.setId(rs.getInt("id"));
				b.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				b.setPinnwandID(rs.getInt("pinnwandID"));

				return b;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}
	
	/**
	 * Vector-Methode muss angepasst werden Suchen eines Beitrags über den
	 * vorgegebenen Fremdschlüssel.
	 * 
	 * @param nutzerID
	 * @return Beitrag-Objekt, das dem übergebenen Fremdschlüssel entspricht,
	 *         null bei nicht vorhandenem DB-Tupel
	 */
	public Vector<Beitrag> findBeitragByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();
		Vector<Beitrag> result = new Vector<Beitrag>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			// Order By unwichtig
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, pinnwandID, nutzerID" + "FROM Beitrag "
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY nutzerID");

			// Für jeden Eintrag im Suchergebnis wird nun ein Beitrag-Objekt
			// erstellt
			while (rs.next()) {
				Beitrag b = new Beitrag();
				b.setId(rs.getInt("id"));
				b.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				b.setPinnwandID(rs.getInt("pinnwandID"));
				b.setNutzerID(rs.getInt("nutzerID"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(b);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	/**
	 * Einfügen eines <code>Beitrag</code>-Objekts in die Datenbank.
	 * 
	 * @param b
	 * @return das bereits übergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 * 
	 *         !!!!! TEXT WIRD EVTL. NOCH HINZUGEFÜGT !!!!!!
	 */
	public Beitrag createBeitrag(Beitrag b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM beitrag ");

			if (rs.next()) {

				b.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// TEXT EVTL. ALS ATTRIBUT und Beitragsklasse überarbeiten
				stmt.executeUpdate("INSERT INTO beitrag (id, pinnwandID) " + "VALUES (" + b.getId() + ","
						+ b.getPinnwandID() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param b
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter übergebene Objekt
	 */
	public Beitrag updateBeitrag(Beitrag b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate(
					"UPDATE beitrag " + "SET pinnwandID=\"" + b.getPinnwandID() + "\" " + "WHERE id =" + b.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;

	}
	
	/**
	 * Löschen der Daten eines <code>Beitrag</code>-Objekts aus der Datenbank
	 * 
	 * @param b
	 *            das aus der DB zu löschende "Objekt"
	 */
	public void deleteBeitrag(Beitrag b) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM beitrag " + "WHERE id=" + b.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
