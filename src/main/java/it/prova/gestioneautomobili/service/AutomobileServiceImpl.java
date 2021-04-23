package it.prova.gestioneautomobili.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneautomobili.dao.AutomobileDAO;
import it.prova.gestioneautomobili.model.Automobile;
import it.prova.gestioneautomobili.web.listener.LocalEntityManagerFactoryListener;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDao;

	public void setAutomobileDAO(AutomobileDAO automobileDao) {
		this.automobileDao = automobileDao;
	}

	@Override
	public List<Automobile> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Automobile caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return automobileDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Automobile input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			entityManager.getTransaction().begin();
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.update(input);
			entityManager.getTransaction().commit();


		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}	}

	@Override
	public void inserisciNuovo(Automobile input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			automobileDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			automobileDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Automobile> findByExample(Automobile input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
 			automobileDao.setEntityManager(entityManager);
 			return automobileDao.findByExample(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	 

}
