package de.hdm.itprojektws1819.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * Einfügen eines <code>Nutzerobjekt</code>-Objects in die Datenbank.
	 * 
	 * @param n
	 * @return das bereits übergebene Objekt jedoch mit ggf. korrigierter <code>id</code>.
	 */
	public Nutzer createNutzer(Nutzer n) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid " + "FROM nutzer ");
			
			if (rs.next()) {
				
				n.setId(rs.getInt("maxid") + 1);
				
				stmt = con.createStatement();
				
				stmt.executeUpdate("INSERT INTO nutzer (nutzerID, vorname, nachname, nickname, email, erstellungszeitpunkt) "
						+ "VALUES (" + n.getId() + ",'" + n.getId() + "','" + n.getVorname() + "','"
						+ n.getNachname() + "','" + n.getNickname() + "','" + n.getEmail() + "','"
						+ n.getErstellungszeitpunkt() + "')");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	
}
