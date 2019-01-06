package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @param k
	 *            das Objekt, das in die DB geschrieben werden soll
	 * @return das als Parameter übergebene Objekt
	 */
//	/**public Abonnement updateAbonnement(Abonnement a) {
//		*Connection con = DBConnection.connection();
//
//		try {
//			Statement stmt = con.createStatement();
//
//			stmt.executeUpdate("UPDATE abonnement " + "SET erstellungszeitpunkt=\"" + a.getErstellungszeitpunkt()
//	}
//	
}
