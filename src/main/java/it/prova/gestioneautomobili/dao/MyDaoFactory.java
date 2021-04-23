package it.prova.gestioneautomobili.dao;

public class MyDaoFactory {

	private static AutomobileDAO automobileDaoInstance = null;
	private static UtenteDAO utenteDaoInstance = null;

	public static AutomobileDAO getAutomobileDaoInstance() {
		if (automobileDaoInstance == null)
			automobileDaoInstance = new AutomobileDAOImpl();

		return automobileDaoInstance;
	}

	public static UtenteDAO getUtenteDaoInstance() {
		if (utenteDaoInstance == null)
			utenteDaoInstance = new UtenteDAOImpl();

		return utenteDaoInstance;
	}

}
