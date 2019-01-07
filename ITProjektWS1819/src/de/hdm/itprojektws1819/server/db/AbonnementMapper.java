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
	 * Suchen eines Abonnements �ber die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id
	 * @return Abonnement-Objekt, das dem �bergebenen Schl�ssel entspricht, null
	 *         bei nicht vorhandenem DB-Tupel
	 */
	public Abonnement findAbonnementByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE id=" + id + " ORDER BY id");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
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
	 * Vector-Methode muss angepasst werden. Suchen eines Abonnements �ber den
	 * vorgegebenen Fremdschl�ssel.
	 * 
	 * @param nutzerID
	 * @return Vector mit Abonnement-Objekten, die s�mtliche Abonnements mit
	 *         gesuchtem Fremdschl�ssel repr�sentieren.
	 */
	public Vector<Abonnement> findAbonnementByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();
		Vector<Abonnement> result = new Vector<Abonnement>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY nutzerID");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Abonnement-Objekt
			// erstellt
			while (rs.next()) {
				Abonnement a = new Abonnement();
				a.setId(rs.getInt("id"));
				a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				a.setNutzerID(rs.getInt("nutzerID"));
				a.setPinnwandID(rs.getInt("pinnwandID"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Abonnements �ber den
	 * vorgegebenen Fremdschl�ssel.
	 * 
	 * @param pinnwandID
	 * @return Vector mit Kommentar-Objekten, die s�mtliche Abonnements mit
	 *         gesuchtem Fremdschl�ssel repr�sentieren.
	 */
	public Vector<Abonnement> findAbonnementByPinnwandID(int pinnwandID) {
		Connection con = DBConnection.connection();
		Vector<Abonnement> result = new Vector<Abonnement>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, pinnwandID FROM abonnement "
					+ "WHERE pinnwandID=" + pinnwandID + "ORDER BY pinnwandID");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Abonnement-Objekt
			// erstellt
			while (rs.next()) {
				Abonnement a = new Abonnement();
				a.setId(rs.getInt("id"));
				a.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				a.setNutzerID(rs.getInt("nutzerID"));
				a.setPinnwandID(rs.getInt("pinnwandID"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(a);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Einf�gen eines <code>Abonnement</code>-Objekts in die Datenbank.
	 * 
	 * @param a
	 * @return das bereits �bergebene Objekt jedoch mit ggf. korrigierter
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
	 * @return das als Parameter �bergebene Objekt
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
	 * L�schen der Daten eines <code>Abonnement</code>-Objekts aus der Datenbank
	 * 
	 * @param a
	 *            das aus der DB zu l�schende "Objekt"
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
