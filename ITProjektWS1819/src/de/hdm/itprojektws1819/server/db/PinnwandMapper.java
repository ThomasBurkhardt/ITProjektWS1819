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
	
	
}
