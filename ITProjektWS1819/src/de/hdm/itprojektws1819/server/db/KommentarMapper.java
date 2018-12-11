package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojektws1819.shared.bo.Kommentar;

public class KommentarMapper {
	
	private static KommentarMapper kommentarMapper = null;
	
	protected KommentarMapper() {
	}

	public static KommentarMapper kommentarMapper() {
		if (kommentarMapper == null) {
			kommentarMapper = new KommentarMapper();
		}
		
		return kommentarMapper;
	}

	/**
	 * Suchen eines Kommentars �ber die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id
	 * @return Kommentar-Objekt, das dem �bergebenen Schl�ssel entspricht, null
	 *         bei nicht vorhandenem DB-Tupel
	 */
	public Kommentar findKommentarByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, beitragID, erstellungszeitpunkt" + "FROM kommentar "
					+ "WHERE id=" + id + " ORDER BY id");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Kommentar k = new Kommentar();
				k.setId(rs.getInt("id"));
				k.setBeitragID(rs.getInt("beitragID"));
				k.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				return k;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Kommentars �ber den
	 * vorgegebenen Fremdschl�ssel.
	 * 
	 * @param beitragID
	 * @return Vector mit Kommentar-Objekten, die s�mtliche Kommentare mit
	 *         gesuchtem Fremdschl�ssel repr�sentieren.
	 */
	public Vector<Kommentar> findKommentarByBeitragID(int beitragID) {
		Connection con = DBConnection.connection();
		Vector<Kommentar> result = new Vector<Kommentar>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, beitragID, erstellungszeitpunkt" + "FROM kommentar "
					+ "WHERE beitragID=" + beitragID + "ORDER BY beitragID");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Kommentar-Objekt
			// erstellt
			while (rs.next()) {
				Kommentar k = new Kommentar();
				k.setId(rs.getInt("id"));
				k.setBeitragID(rs.getInt("beitragID"));
				k.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(k);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	/**
	 * Einf�gen eines <code>Kommentar</code>-Objekts in die Datenbank.
	 * 
	 * @param k
	 * @return das bereits �bergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 * 
	 *         !!!!! TEXT WIRD EVTL. NOCH HINZUGEF�GT !!!!!!
	 */
	public Kommentar createKommentarMapper(Kommentar k) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM kommentar ");

			if (rs.next()) {

				k.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				stmt.executeUpdate("INSERT INTO kommentar(id, beitragID, erstellungszeitpunkt) " + "VALUES ("
						+ k.getId() + "," + k.getBeitragID() + "," + k.getErstellungszeitpunkt() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;

	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param k
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter �bergebene Objekt
	 */
	public Kommentar updateKommentar(Kommentar k) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE kommentar " + "SET beitragID=\"" + k.getBeitragID() + "\", "
					+ "erstellungszeitpunkt=\"" + k.getErstellungszeitpunkt() + "\" " + "WHERE id =" + k.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
	
	/**
	 * L�schen der Daten eines <code>Kommentar</code>-Objekts aus der Datenbank
	 * 
	 * @param k
	 *            das aus der DB zu l�schende "Objekt"
	 */
	public void deleteKommentar(Kommentar k) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM kommentar " + "WHERE id =" + k.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
	
}
