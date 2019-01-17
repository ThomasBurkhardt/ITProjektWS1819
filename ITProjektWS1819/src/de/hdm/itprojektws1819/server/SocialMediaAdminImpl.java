package de.hdm.itprojektws1819.server;


import de.hdm.itprojektws1819.server.db.AbonnementMapper;
import de.hdm.itprojektws1819.server.db.BeitragMapper;
import de.hdm.itprojektws1819.server.db.KommentarMapper;
import de.hdm.itprojektws1819.server.db.NutzerMapper;
import de.hdm.itprojektws1819.server.db.PinnwandMapper;
import de.hdm.itprojektws1819.shared.FieldVerifier;
import de.hdm.itprojektws1819.shared.SocialMediaAdmin;
import de.hdm.itprojektws1819.shared.bo.Abonnement;
import de.hdm.itprojektws1819.shared.bo.Beitrag;
import de.hdm.itprojektws1819.shared.bo.Kommentar;
import de.hdm.itprojektws1819.shared.bo.Nutzer;
import de.hdm.itprojektws1819.shared.bo.Pinnwand;

import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Implementierungsklasse des Interface <code>SocialMediaAdmin</code>.
 * In den Methoden dieser Klasse findet sich die Applikationslogik.
 */
@SuppressWarnings("serial")
public class SocialMediaAdminImpl extends RemoteServiceServlet implements SocialMediaAdmin {

	/**
	 * Referenz auf NutzerMapper, der Nutzerobjekte mit der Datenbank 
	 * abgleicht.
	 */
	private NutzerMapper nutzerMapper = null;
	
	/**
	 * Referenz auf PinnwandMapper, der Pinnwandobjekte mit der Datenbank 
	 * abgleicht.
	 */
	private PinnwandMapper pinnwandMapper = null;
	
	/**
	 * Referenz auf BeitragMapper, der Beitragobjekte mit der Datenbank 
	 * abgleicht.
	 */
	private BeitragMapper beitragMapper = null;
	
	/**
	 * Referenz auf KommentarMapper, der Kommentarobjekte mit der Datenbank 
	 * abgleicht.
	 */
	private KommentarMapper kommentarMapper = null;
	
	/**
	 * Referenz auf AbonnementMapper, der Abonnemenetobjekte mit der Datenbank 
	 * abgleicht.
	 */
	private AbonnementMapper abonnementMapper = null;
	
	/**
	 * Null-Argument-Konstruktor für die Client-seitige Erzeugung von GWT.create
	 * um eine Initialisierung der Instanz vorzunehmen.
	 * 
	 * @throws IllegalArgumentException
	 */
	public SocialMediaAdminImpl() throws IllegalArgumentException {
		
	}

	/**
	 * Initialisierungsmethode, welche für jede Instanz von SocialMediaAdminImpl
	 * aufgerufen werden muss.
	 */
	@Override
	public void init() throws IllegalArgumentException {
		
		this.nutzerMapper = NutzerMapper.nutzerMapper();
		this.pinnwandMapper = PinnwandMapper.pinnwandMapper();
		this.beitragMapper = BeitragMapper.beitragMapper();
		this.kommentarMapper = KommentarMapper.kommentarMapper();
		this.abonnementMapper = AbonnementMapper.abonnementMapper();
		
	}
	
	
	/**
	 * Anlegen eines Nutzers
	 * 
	 * @param vorname, nachname, nickname, email des Nutzers
	 */
	@Override
	public Nutzer createNutzer(String vorname, String nachname, String nickname, String email)
			throws IllegalArgumentException {
		Nutzer nutzer = new Nutzer();
		nutzer.setVorname(vorname);
		nutzer.setNachname(nachname);
		nutzer.setNickname(nickname);
		nutzer.setEmail(email);
				
		return this.nutzerMapper.createNutzer(nutzer);
	}

	/**
	 * Anlegen einer neuen Pinnwand
	 * 
	 * @param nutzerID
	 *            Id des Nutzers, dem die Pinnwand angehört
	 */
	@Override
	public Pinnwand createPinnwand(int nutzerID) throws IllegalArgumentException {

		Pinnwand pinnwand = new Pinnwand();
		pinnwand.setNutzerID(nutzerID);

		return this.pinnwandMapper.createPinnwand(pinnwand);
	}

	/**
	 * Anlegen eines neuen Beitrags
	 * 
	 * @param beitragInhalt
	 */
	@Override
	public Beitrag createBeitrag(String beitragInhalt) throws IllegalArgumentException {
		Beitrag beitrag = new Beitrag();
		beitrag.setBeitragInhalt(beitragInhalt);
		
		return this.beitragMapper.createBeitrag(beitrag);
	}

	/**
	 * Anlegen eines neuen Kommentars
	 * 
	 * @param beitragID,
	 *            kommentarInhalt
	 */
	@Override
	public Kommentar createKommentar(int beitragID, String kommentarInhalt) throws IllegalArgumentException {
		Kommentar kommentar = new Kommentar();
		kommentar.setBeitragID(beitragID);
		kommentar.setKommentarInhalt(kommentarInhalt);

		return this.kommentarMapper.createKommentar(kommentar);
	}

	@Override
	public Abonnement createAbonnement(int nutzerID, int pinnwandID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNutzer(Nutzer n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePinnwand(Pinnwand p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveBeitrag(Beitrag b) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveKommentar(Kommentar k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAbonnement(Abonnement a) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNutzer(Nutzer n) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePinnwand(Pinnwand p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeitrag(Beitrag b) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKommentar(Kommentar k) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAbonnement(Abonnement a) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Nutzer findNutzerByID(int nutzerID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Nutzer> findNutzerByVorname(String vorname) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Nutzer> findNutzerByNachname(String nachname) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Nutzer> findNutzerByNickname(String nickname) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Nutzer> findAllNutzer() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pinnwand findPinnwandByID(int pinnwandID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pinnwand findPinnwandByNutzerID(int nutzerID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beitrag findBeitragByID(int beitragID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Beitrag> findBeitragByNutzerID(int nutzerID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kommentar findKommentarByID(int kommentarID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Kommentar> findKommentarByBeitragID(int beitragID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abonnement findAbonnementByID(int abonnemenetID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Abonnement> findAbonnementByNutzerID(int nutzerID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Abonnement> findAbonnementByPinnwandID(int pinnwandID) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
