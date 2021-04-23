package it.prova.gestioneautomobili.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneautomobili.dao.UtenteDAO;
import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.model.Utente;
import it.prova.gestioneautomobili.web.listener.LocalEntityManagerFactoryListener;
 

public class UtenteServiceImpl implements UtenteService {

	private UtenteDAO utenteDAO;

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO = utenteDAO;
	}

	@Override
	public List<Utente> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			utenteDAO.setEntityManager(entityManager);
			return utenteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Utente caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			utenteDAO.setEntityManager(entityManager);
			return utenteDAO.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			utenteDAO.setEntityManager(entityManager);
			utenteDAO.update(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
 			entityManager.getTransaction().begin();

 			utenteDAO.setEntityManager(entityManager);
 			utenteDAO.insert(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
 			entityManager.getTransaction().begin();
 			
 			utenteDAO.setEntityManager(entityManager);
 			utenteDAO.delete(utenteInstance);
 			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Utente cercaPerUsernameEpassword(String username, String password) {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			utenteDAO.setEntityManager(entityManager);
			return utenteDAO.findByUsernameAndPassword(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

 
 
}
