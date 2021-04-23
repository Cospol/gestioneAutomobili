package it.prova.gestioneautomobili.dao;

 import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneautomobili.model.Utente;
  

public class UtenteDAOImpl implements UtenteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Utente> list() throws Exception {
		return entityManager.createQuery("from Utente",Utente.class).getResultList();
	}

	@Override
	public Utente findOne(Long id) throws Exception {
		return entityManager.find(Utente.class, id);
	}

	@Override
	public void update(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		utenteInstance = entityManager.merge(utenteInstance);
	}

	@Override
	public void insert(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(utenteInstance);
	}

	@Override
	public void delete(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(utenteInstance));
	}
 
	@Override
	public Utente findByUsernameAndPassword(String username, String password) {
 
		TypedQuery<Utente> query = entityManager
				.createQuery("from Utente u  where u.username like ?1 and u.password like ?2", Utente.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		
		return query.getResultStream().findFirst().orElse(null);
		 
	}
	 
}
