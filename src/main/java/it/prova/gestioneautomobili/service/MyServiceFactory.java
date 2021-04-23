package it.prova.gestioneautomobili.service;

import it.prova.gestioneautomobili.dao.AutomobileDAO;
import it.prova.gestioneautomobili.dao.AutomobileDAOImpl;
import it.prova.gestioneautomobili.dao.UtenteDAO;
import it.prova.gestioneautomobili.dao.UtenteDAOImpl;

public class MyServiceFactory {
 
	private static AutomobileService AUTOMOBILE_SERVICE_INSTANCE = null;
	private static AutomobileDAO AUTOMOBILEDAO_INSTANCE = null;
	
	private static UtenteService UTENTE_SERVICE_INSTANCE = null;
	private static UtenteDAO UTENTEDAO_INSTANCE = null;


	public static AutomobileService getAutomobileServiceInstance() {
		if (AUTOMOBILE_SERVICE_INSTANCE == null)
			AUTOMOBILE_SERVICE_INSTANCE = new AutomobileServiceImpl();

		if (AUTOMOBILEDAO_INSTANCE == null)
			AUTOMOBILEDAO_INSTANCE = new AutomobileDAOImpl();

		AUTOMOBILE_SERVICE_INSTANCE.setAutomobileDAO(AUTOMOBILEDAO_INSTANCE);

		return AUTOMOBILE_SERVICE_INSTANCE;
	}
	

	public static UtenteService getUtenteServiceInstance() {
		if (UTENTE_SERVICE_INSTANCE == null)
			UTENTE_SERVICE_INSTANCE = new UtenteServiceImpl();

		if (UTENTEDAO_INSTANCE == null)
			UTENTEDAO_INSTANCE = new UtenteDAOImpl();

		UTENTE_SERVICE_INSTANCE.setUtenteDAO(UTENTEDAO_INSTANCE);

		return UTENTE_SERVICE_INSTANCE;
	}

}
