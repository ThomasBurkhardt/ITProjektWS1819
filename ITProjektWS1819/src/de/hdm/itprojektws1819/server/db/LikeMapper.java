package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.itprojektws1819.shared.bo.Like;

public class LikeMapper {

	private static LikeMapper likeMapper = null;

	protected LikeMapper() {
	}

	public static LikeMapper likeMapper() {
		if (likeMapper == null) {
			likeMapper = new LikeMapper();
		}

		return likeMapper;
	}

	/**
	 * Suchen eines Likes �ber die vorgegebene Id. Da diese eindeutig ist, wird
	 * genau ein Objekt zur�ckgegeben.
	 * 
	 * @param id
	 * @return Like-Objekt, das dem �bergebenen Schl�ssel entspricht, null bei
	 *         nicht vorhandenem DB-Tupel
	 */
	public Like findLikeByID(int id) {
		Connection con = DBConnection.connection();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, beitragID FROM like "
					+ "WHERE id=" + id + " ORDER BY id");

			/*
			 * Da id Prim�rschl�ssel ist, kann max. nur ein Tupel zur�ckgegeben
			 * werden. Pr�fe, ob ein Ergebnis vorliegt.
			 */
			if (rs.next()) {
				// Ergebnis-Tupel in Objekt umwandeln
				Like like = new Like();
				like.setId(rs.getInt("id"));
				like.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				like.setNutzerID(rs.getInt("nutzerID"));
				like.setBeitragID(rs.getInt("beitragID"));

				return like;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Likes �ber den
	 * vorgegebenen Fremdschl�ssel.
	 * 
	 * @param nutzerID
	 * @return Vector mit Like-Objekten, die s�mtliche Beitr�ge mit gesuchtem
	 *         Fremdschl�ssel repr�sentieren,
	 */
	public Vector<Like> findLikeByNutzerID(int nutzerID) {
		Connection con = DBConnection.connection();
		Vector<Like> result = new Vector<Like>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, beitragID FROM like"
					+ "WHERE nutzerID=" + nutzerID + "ORDER BY nutzerID");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Beitrag-Objekt
			// erstellt
			while (rs.next()) {
				Like like = new Like();
				like.setId(rs.getInt("id"));
				like.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				like.setNutzerID(rs.getInt("nutzerID"));
				like.setBeitragID(rs.getInt("beitragID"));

				result.addElement(like);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Vector-Methode muss angepasst werden. Suchen eines Likes �ber den
	 * vorgegebenen Fremdschl�ssel.
	 * 
	 * @param beitragID
	 * @return Vector mit Like-Objekten, die s�mtliche Beitr�ge mit gesuchtem
	 *         Fremdschl�ssel repr�sentieren,
	 */
	public Vector<Like> findLikeByBeitragID(int beitragID) {
		Connection con = DBConnection.connection();
		Vector<Like> result = new Vector<Like>();

		try {
			// Leeres SQL-Statement (JDBC) anlegen
			Statement stmt = con.createStatement();

			// Statement ausf�llen und als Query an die DB schicken
			ResultSet rs = stmt.executeQuery("SELECT id, erstellungszeitpunkt, nutzerID, beitragID FROM like"
					+ "WHERE beitragID=" + beitragID + "ORDER BY beitragID");

			// F�r jeden Eintrag im Suchergebnis wird nun ein Like-Objekt
			// erstellt
			while (rs.next()) {
				Like like = new Like();
				like.setId(rs.getInt("id"));
				like.setErstellungszeitpunkt(rs.getDate("erstellungszeitpunkt"));
				like.setNutzerID(rs.getInt("nutzerID"));
				like.setBeitragID(rs.getInt("beitragID"));

				result.addElement(like);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Einf�gen eines <code>Beitrag</code>-Objekts in die Datenbank.
	 * 
	 * @param b
	 * @return das bereits �bergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 */
	public Like createLike(Like like) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM like ");

			if (rs.next()) {

				like.setId(rs.getInt("maxid") + 1);

				stmt = con.createStatement();

				stmt.executeUpdate("INSERT INTO like (id, erstellungszeitpunkt, " + "nutzerID, beitragID) " + "VALUES ("
						+ like.getId() + "," + like.getErstellungszeitpunkt() + "," + like.getNutzerID() + ","
						+ like.getBeitragID() + ")");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return like;
	}

	/**
	 * Wiederholtes Schreiben eines Objekts in die Datenbank.
	 * 
	 * @param like
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter �bergebene Objekt
	 */
	public Like updateLike(Like like) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("UPDATE like " + "SET erstellungszeitpunkt=\"" + like.getErstellungszeitpunkt() + "\""
					+ "WHERE id =" + like.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return like;

	}

	/**
	 * L�schen der Daten eines <code>Like</code>-Objekts aus der Datenbank
	 * 
	 * @param like
	 *            das aus der DB zu l�schende "Objekt"
	 */
	public void deleteLike(Like like) {
		Connection con = DBConnection.connection();

		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("DELETE FROM like " + "WHERE id=" + like.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
