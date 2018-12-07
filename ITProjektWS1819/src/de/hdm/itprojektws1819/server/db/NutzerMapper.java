package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojektws1819.shared.bo.Nutzer;

public class NutzerMapper {

	private static NutzerMapper nutzerMapper = null;
	
	protected NutzerMapper() {
	}
	
	public static NutzerMapper nutzerMapper() {
		if (nutzerMapper == null) {
			nutzerMapper = new NutzerMapper();
		}
		
		return nutzerMapper;
	}
	
	/**
	 * Suchen eines Nutzers �ber die vorgegebene Id. Da diese eindeutig ist,
	 * wird genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id
	 * @return Nutzer-Objekt, das dem �bergebenen Schl�ssel entspricht, null bei
	 *         nicht vorhandenem DB-Tupel
	 */
	public Nutzer findNutzerByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, nickname, "
					+ "email, erstellungszeitpunkt FROM nutzer " + "WHERE id=" + id + " ORDER BY nachname");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("id"));
				n.setVorname(rs.getString("vorname"));
				n.setNachname(rs.getString("nachname"));
				n.setNickname(rs.getString("nickname"));
				n.setEmail(rs.getString("email"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				return n;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}
	
	/**
	 * Auslesen aller Nutzer-Objekte mit gegebenem Vornamen
	 * 
	 * @param vorname
	 * @return Vektor mit Nutzer-Objekten, die s�mtliche Nutzer mit gesuchtem
	 *         Vornamen repr�sentieren. Bei evtl. Exceptions wird ein partiell
	 *         gef�llter oder ggf. auch leerer Vetor zur�ckgeliefert.
	 */
	public Vector<Nutzer> findNutzerByVorname(String vorname) {
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, nickname, " + "email, erstellungszeitpunkt "
					+ "FROM nutzer " + "WHERE vorname LIKE '" + vorname + "' ORDER BY vorname");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Nutzer-Objekt
			// erstellt
			while (rs.next()) {
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("id"));
				n.setVorname(rs.getString("vorname"));
				n.setNachname(rs.getString("nachname"));
				n.setNickname(rs.getString("nickname"));
				n.setEmail(rs.getString("email"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(n);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Auslesen aller Nutzer-Objekte mit gegebenem Nachnamen
	 * 
	 * @param nachname
	 * @return Vektor mit Nutzer-Objekten, die s�mtliche Nutzer mit gesuchtem
	 *         Nachnamen repr�sentieren. Bei evtl. Exceptions wird ein partiell
	 *         gef�llter oder ggf. auch leerer Vetor zur�ckgeliefert.
	 */
	public Vector<Nutzer> findNutzerByNachname(String nachname) {
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT id, vorname, nachname, nickname, " + "email, erstellungszeitpunkt  "
							+ "FROM nutzer " + "WHERE nachname LIKE '" + nachname + "' ORDER BY nachname");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Nutzer-Objekt
			// erstellt
			while (rs.next()) {
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("id"));
				n.setVorname(rs.getString("vorname"));
				n.setNachname(rs.getString("nachname"));
				n.setNickname(rs.getString("nickname"));
				n.setEmail(rs.getString("email"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(n);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Auslesen aller Nutzer-Objekte mit gegebenem Nicknamen
	 * 
	 * @param nickname
	 * @return Vektor mit Nutzer-Objekten, die s�mtliche Nutzer mit gesuchtem
	 *         Nicknamen repr�sentieren. Bei evtl. Exceptions wird ein partiell
	 *         gef�llter oder ggf. auch leerer Vetor zur�ckgeliefert.
	 * 
	 * 
	 *         VECTOR MUSS EVTL. GE�NDERT WERDEN
	 */
	public Vector<Nutzer> findNutzerByNickname(String nickname) {
		Connection con = DBConnection.connection();
		Vector<Nutzer> result = new Vector<Nutzer>();

		try {
			Statement stmt = con.createStatement();

			// Tabelle id m�glicherweise "nutzerID"
			ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, nickname, " + "email, erstellungszeitpunkt "
					+ "FROM nutzer " + "WHERE nickname LIKE '" + nickname + "' ORDER BY nickname");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Nutzer-Objekt
			// erstellt
			while (rs.next()) {
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("id"));
				n.setVorname(rs.getString("vorname"));
				n.setNachname(rs.getString("nachname"));
				n.setNickname(rs.getString("nickname"));
				n.setEmail(rs.getString("email"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(n);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	/**
	 * Auslesen aller Nutzer
	 * 
	 * @return Ein Vektor mit Nutzer-Objekten, die s�mtliche Nutzer
	 *         repr�sentieren.
	 */
	public Vector<Nutzer> findAllNutzer() {
		Connection con = DBConnection.connection();

		// Ergebnisvektor vorbereiten
		Vector<Nutzer> result = new Vector<Nutzer>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, vorname, nachname, "
					+ "nickname, email, erstellungszeitpunkt FROM nutzer" + "ORDER BY id");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Nutzer-Objekt
			// erstellt.
			while (rs.next()) {
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("id"));
				n.setVorname(rs.getString("vorname"));
				n.setNachname(rs.getString("nachname"));
				n.setNickname(rs.getString("nickname"));
				n.setEmail(rs.getString("email"));
				n.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));

				// Hinzuf�gen des neuen Objekts zum Ergebnisvektor
				result.addElement(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Ergebnisvektor zur�ckgeben
		return result;
	}
	
	/**
	 * Einf�gen eines <code>Nutzer</code>-Objekts in die Datenbank.
	 * 
	 * @param n
	 * @return das bereits �bergebene Objekt jedoch mit ggf. korrigierter <code>id</code>.
	 */
	public Nutzer createNutzer(Nutzer n) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM nutzer ");
			
			if (rs.next()) {
				
				n.setId(rs.getInt("maxid") + 1);
				
				stmt = con.createStatement();
				
				// id muss evtl. in nutzerID ge�ndert werden
				stmt.executeUpdate("INSERT INTO nutzer (id, vorname, nachname, nickname, email, erstellungszeitpunkt) "
						+ "VALUES (" + n.getId() + "','" + n.getVorname() + "','"
						+ n.getNachname() + "','" + n.getNickname() + "','" + n.getEmail() + "','"
						+ n.getErstellungszeitpunkt() + "')");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param n
	 * 			das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter �bergebene Objekt
	 */
	public Nutzer updateNutzer(Nutzer n) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE nutzer " + "SET vorname=\"" + n.getVorname() + "\", " + "nachname=\""
					+ n.getNachname() + "\", " + "nickname=\"" + n.getNickname() + "\" " + "WHERE id =" + n.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	/**
	 * L�schen der Daten eines <code>Nutzer</code>-Bojekts aus der Datenbank
	 * 
	 * @param n
	 * 			das aus der DB zu l�schende "Objekt"
	 */
	public void deleteNutzer(Nutzer n) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM nutzer " + "WHERE id=" + n.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
