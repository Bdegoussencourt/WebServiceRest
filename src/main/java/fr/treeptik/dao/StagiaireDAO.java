package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Stagiaire;

public interface StagiaireDAO extends GenericDAO<Stagiaire, Integer> {
	
	Stagiaire findByEmail(String email) throws DAOException;

}
