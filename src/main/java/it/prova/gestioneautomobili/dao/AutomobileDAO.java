package it.prova.gestioneautomobili.dao;

import java.util.List;

import it.prova.gestioneautomobili.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {

	public List<Automobile> findByExample(Automobile automobileExample) throws Exception ;
}
