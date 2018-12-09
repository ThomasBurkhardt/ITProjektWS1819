package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * Einfügen eines <code>Kommentar</code>-Objekts in die Datenbank.
	 * 
	 * @param k
	 * @return das bereits übergebene Objekt jedoch mit ggf. korrigierter
	 *         <code>id</code>.
	 * 
	 *         !!!!! TEXT WIRD EVTL. NOCH HINZUGEFÜGT !!!!!!
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
	 * @return das als Parameter übergebene Objekt
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
	 * Löschen der Daten eines <code>Kommentar</code>-Objekts aus der Datenbank
	 * 
	 * @param k
	 *            das aus der DB zu löschende "Objekt"
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
