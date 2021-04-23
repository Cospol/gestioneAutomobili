package it.prova.gestioneautomobili.service;

import java.util.List;

import it.prova.gestioneautomobili.dao.AutomobileDAO;
import it.prova.gestioneautomobili.model.Automobile;

public interface AutomobileService {

 	public void setAutomobileDAO(AutomobileDAO automobileDao);

	public List<Automobile> listAll() throws Exception;

	public Automobile caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Automobile input) throws Exception;

	public void inserisciNuovo(Automobile input) throws Exception;

	public void rimuovi(Automobile input) throws Exception;

	public List<Automobile> findByExample(Automobile input) throws Exception;

 
}
