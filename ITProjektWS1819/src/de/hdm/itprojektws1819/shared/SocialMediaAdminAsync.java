package de.hdm.itprojektws1819.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.itprojektws1819.shared.bo.Abonnement;
import de.hdm.itprojektws1819.shared.bo.Beitrag;
import de.hdm.itprojektws1819.shared.bo.Kommentar;
import de.hdm.itprojektws1819.shared.bo.Nutzer;
import de.hdm.itprojektws1819.shared.bo.Pinnwand;

public interface SocialMediaAdminAsync {

	void init(AsyncCallback<Void> callback);

	void createNutzer(String vorname, String nachname, String nickname, String email, AsyncCallback<Nutzer> callback);

	void createPinnwand(int nutzerID, AsyncCallback<Pinnwand> callback);

	void createBeitrag(String beitragInhalt, AsyncCallback<Beitrag> callback);

	void createKommentar(int beitragID, String kommentarInhalt, AsyncCallback<Kommentar> callback);

	void createAbonnement(int nutzerID, int pinnwandID, AsyncCallback<Abonnement> callback);

	void saveNutzer(Nutzer n, AsyncCallback<Void> callback);

	void savePinnwand(Pinnwand p, AsyncCallback<Void> callback);

	void saveBeitrag(Beitrag b, AsyncCallback<Void> callback);

	void saveKommentar(Kommentar k, AsyncCallback<Void> callback);

	void saveAbonnement(Abonnement a, AsyncCallback<Void> callback);

	void deleteNutzer(Nutzer n, AsyncCallback<Void> callback);

	void deletePinnwand(Pinnwand p, AsyncCallback<Void> callback);

	void deleteBeitrag(Beitrag b, AsyncCallback<Void> callback);

	void deleteKommentar(Kommentar k, AsyncCallback<Void> callback);

	void deleteAbonnement(Abonnement a, AsyncCallback<Void> callback);

}