package it.prova.gestioneautomobili.service;

import java.util.List;

import it.prova.gestioneautomobili.dao.UtenteDAO;
import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.model.Utente;

 

public interface UtenteService  {
	
	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;
	
 	public void setUtenteDAO(UtenteDAO utenteDAO);
 	
 	public Utente cercaPerUsernameEpassword(String username, String password);
 	

}