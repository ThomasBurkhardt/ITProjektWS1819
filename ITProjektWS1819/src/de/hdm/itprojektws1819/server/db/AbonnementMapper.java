package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojektws1819.shared.bo.Abonnement;

public class AbonnementMapper {

	private static AbonnementMapper abonnementMapper = null;

	protected AbonnementMapper() {
	}

	public static AbonnementMapper abonnementMapper() {
		if (abonnementMapper == null) {
			abonnementMapper = new AbonnementMapper();
		}

		return abonnementMapper;
	}

	/**
	 * Suchen eines Abonnements über die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zurückgegeben.
	 * 
	 * @param id
	 * @return Abonnement-Objekt, das dem übergebenen Schlüssel entspricht, null
	 *         bei nicht vorhandenem DB-Tupel
	 */
	public Abonnement findAbonnementByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE id=" + id + " ORDER BY id");

			/*
			 * Da id Primärschlüssel ist, kann max. nur ein Tupel zurückgegeben
			 * werden. Prüfe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Abonnement a = new Abonnement();
				a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				a.setNutzerID(rs.getInt("nutzerID"));
				a.setPinnwandID(rs.getInt("pinnwandID"));

				return a;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Abonnements über den
	 * vorgegebenen Fremdschlüssel.
	 * 
	 * @param nutzerID
	 * @return Vector mit Abonnement-Objekten, die sämtliche Abonnements mit
	 *         gesuchtem Fremdschlüssel repräsentieren.
	 */
	public Vector<Abonnement> findAbonnementByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();
		Vector<Abonnement> result = new Vector<Abonnement>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY nutzerID");

			// Für jeden Eintrag im Suchergebnis wird nun ein Abonnement-Objekt
			// erstellt
			while (rs.next()) {
				Abonnement a = new Abonnement();
				a.setId(rs.getInt("id"));
				a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				a.setNutzerID(rs.getInt("nutzerID"));
				a.setPinnwandID(rs.getInt("pinnwandID"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Abonnements über den
	 * vorgegebenen Fremdschlüssel.
	 * 
	 * @param pinnwandID
	 * @return Vector mit Kommentar-Objekten, die sämtliche Abonnements mit
	 *         gesuchtem Fremdschlüssel repräsentieren.
	 */
	public Vector<Abonnement> findAbonnementByPinnwandID(int pinnwandID) {
		Connection con = DBConnection.connection();
		Vector<Abonnement> result = new Vector<Abonnement>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausfüllen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE pinnwandID=" + pinnwandID + "ORDER BY pinnwandID");

			// Für jeden Eintrag im Suchergebnis wird nun ein Abonnement-Objekt
			// erstellt
			while (rs.next()) {
				Abonnement a = new Abonnement();
				a.setId(rs.getInt("id"));
				a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				a.setNutzerID(rs.getInt("nutzerID"));
				a.setPinnwandID(rs.getInt("pinnwandID"));

				// Hinzufügen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Einfügen eines <code>Abonnement</code>-Objekts in die Datenbank.
	 * 
	 * @param a
	 * @return das bereits übergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 */
	public Abonnement createAbonnement(Abonnement a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM abonnement ");

			if (rs.next()) {

				a.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				stmt.executeUpdate("INSERT INTO abonnement(id, erstellungszeitpunkt, nutzerID, pinnwandID) "
						+ "VALUES (" + a.getId() + "," + a.getErstellungszeitpunkt() + "," + a.getNutzerID() + ","
						+ a.getPinnwandID() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

	}

	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param a
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter übergebene Objekt
	 */
	public Abonnement updateAbonnement(Abonnement a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE abonnement " + "SET erstellungszeitpunkt=\"" + a.getErstellungszeitpunkt()
					+ "\", " + "nutzerID=\"" + a.getNutzerID() + "\" " + "pinnwandID=\"" + a.getPinnwandID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

	}

	/**
	 * Löschen der Daten eines <code>Abonnement</code>-Objekts aus der Datenbank
	 * 
	 * @param a
	 *            das aus der DB zu löschende "Objekt"
	 */
	public void deleteAbonnement(Abonnement a) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM abonnement " + "WHERE id =" + a.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
