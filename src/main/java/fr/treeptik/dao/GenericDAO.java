package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;

public interface GenericDAO<T, P> {
	
	T update(T entite) throws DAOException;

	T add(T entite) throws DAOException;

	void remove(T entite) throws DAOException;

	void removeById(P id) throws DAOException;

	List<T> findAll() throws DAOException;

	// Integer count() throws DAOException;

	T findByPk(P id) throws DAOException;

	// List<T> findWithParams(Map<String, Object> params) throws DAOException;
}
