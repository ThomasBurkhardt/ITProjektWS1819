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
	 * Suchen einer Pinnwand �ber die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id
	 * @return Pinnwand-Objekt, das dem �bergebenen Schl�ssel entspricht, null
	 *         bei nicht vorhandenem DB-Tupel
	 */
	public Pinnwand findPinnwandByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery(
					"SELECT id, erstellungszeitpunkt, nutzerID" + "FROM pinnwand " + "WHERE id=" + id + "ORDER BY id");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
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
	 * Suchen einer Pinnwand �ber die vorgegebene nutzerID. Da diese eindeutig
	 * ist, wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param nutzerID
	 * @return Pinnwand-Objekt, das dem �bergebenen Fremdschl�ssel entspricht,
	 *         null bei nicht vorhandenem DB-Tupel
	 */
	public Pinnwand findPinnwandByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID" + "FROM pinnwand "
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY id");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
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
	 * Einf�gen eines <code>Pinnwand</code>-Objekts in die Datenbank.
	 * 
	 * @param p
	 * @return das bereits �bergebene Objekt jedoch mit ggf. korrigierter
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

				// id muss m�glicherweise in pinnwandId ge�ndert werden !!!!!
				// Values -> p.getErstellungszeitpunkt muss m�glicherweise mit '
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
	 * @return das als Parameter �bergebene Objekt
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
	 * L�schen der Daten eines <code>Pinnwand</code>-Objekts aus der Datenbank
	 * 
	 * @param p
	 *            das aus der DB zu l�schende "Objekt"
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
