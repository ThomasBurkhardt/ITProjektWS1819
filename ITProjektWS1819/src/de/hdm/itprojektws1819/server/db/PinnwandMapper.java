package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.itprojektws1819.shared.bo.Pinnwand;

public class PinnwandMapper {

	private static PinnwandMapper pinnwandMapper = null;
	
	protected PinnwandMapper() {
		
	}
	
	public static PinnwandMapper pinnwandMapper() {
		if (pinnwandMapper == null) {
			pinnwandMapper = new PinnwandMapper();
		}

		return pinnwandMapper;
	}

	/**
	 * Suchen einer Pinnwand über die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zurückgegeben.
	 * 
	 * @param id
	 * @return Pinnwand-Objekt, das dem übergebenen Schlüssel entspricht, null
	 *         bei nicht vorhandenem DB-Tupel
	 */
	public Pinnwand findPinnwandByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, erstellungszeitpunkt, nutzerID" + "FROM pinnwand " + "WHERE id=" + id + "ORDER BY id");

			/*
			 * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
			 * werden. Prüfe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Pinnwand p = new Pinnwand();
				p.setId(rs.getInt("id"));
				p.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				p.setNutzerID(rs.getInt("nutzerID"));

				return p;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}
	
	/**
	 * Suchen einer Pinnwand über die vorgegebene nutzerID. Da diese eindeutig
	 * ist, wird genau ein Objekt zurückgegeben.
	 * 
	 * @param nutzerID
	 * @return Pinnwand-Objekt, das dem übergebenen Fremdschlüssel entspricht,
	 *         null bei nicht vorhandenem DB-Tupel
	 */
	public Pinnwand findPinnwandByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID" + "FROM pinnwand "
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY id");

			/*
			 * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
			 * werden. Prüfe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Pinnwand p = new Pinnwand();
				p.setId(rs.getInt("id"));
				p.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				p.setNutzerID(rs.getInt("nutzerID"));

				return p;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	} 
	
	
	/**
	 * Einfügen eines <code>Pinnwand</code>-Objekts in die Datenbank.
	 * 
	 * @param p
	 * @return das bereits übergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 */
	public Pinnwand createPinnwand(Pinnwand p) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM pinnwand ");

			if (rs.next()) {

				p.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				// id muss möglicherweise in pinnwandId geändert werden !!!!!
				// Values -> p.getErstellungszeitpunkt muss möglicherweise mit '
				// ' verwendet werden wegen Typ Date
				stmt.executeUpdate("INSERT INTO pinnwand(id, erstellungszeitpunkt, nutzerID) " + "VALUES (" + p.getId()
						+ "," + p.getErstellungszeitpunkt() + "," + p.getNutzerID() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param p
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter übergebene Objekt
	 */
	public Pinnwand updatePinnwand(Pinnwand p) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE pinnwand " + "SET erstellungszeitpunkt=\"" + p.getErstellungszeitpunkt() + "\", "
					+ "nutzerID=\"" + p.getNutzerID() + "\" " + "WHERE id =" + p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * Löschen der Daten eines <code>Pinnwand</code>-Objekts aus der Datenbank
	 * 
	 * @param p
	 *            das aus der DB zu löschende "Objekt"
	 */
	public void deletePinnwand(Pinnwand p) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM pinnwand " + "WHERE id =" + p.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
