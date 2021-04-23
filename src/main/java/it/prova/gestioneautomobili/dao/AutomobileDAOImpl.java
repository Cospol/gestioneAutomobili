package it.prova.gestioneautomobili.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneautomobili.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile findOne(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Automobile input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public List<Automobile> findByExample(Automobile automobileExample) throws Exception {
		if (automobileExample == null)
            throw new Exception("Valore di input non ammesso.");

        String query = "from Automobile a where 1=1 ";
        if (automobileExample.getMarca() != null && !automobileExample.getMarca().equals("")) {
            query += " and a.marca= '" + automobileExample.getMarca() + "' ";
        }
        if (automobileExample.getModello() != null && !automobileExample.getModello().equals("")) {
            query += " and a.modello='" + automobileExample.getModello() + "' ";
        }

        if (automobileExample.getCilindrata() != null && automobileExample.getCilindrata() != 0) {
            query += " and a.cilindrata='" + automobileExample.getCilindrata() + "' ";
        }

        if (automobileExample.getDataImmatricolazione() != null && !automobileExample.getDataImmatricolazione().equals(null)) {
            java.sql.Date data = new java.sql.Date(automobileExample.getDataImmatricolazione().getTime());
            query += " and a.dataImmatricolazione='" + data + "' ";
        }

        TypedQuery<Automobile> tquery = entityManager.createQuery(query, Automobile.class);
        return tquery.getResultList();	}
	

}
