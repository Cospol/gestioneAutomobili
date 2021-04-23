package it.prova.gestioneautomobili.dao;

  
import it.prova.gestioneautomobili.model.Utente;
 
public interface UtenteDAO extends IBaseDAO<Utente> {
	public Utente findByUsernameAndPassword(String username, String password);
}
