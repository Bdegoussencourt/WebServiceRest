package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.User;

public interface UserDAO extends GenericDAO<User, Integer> {

	Integer CountEmailUseWithoutId(String email, Integer id) throws DAOException;
	
	User findByEmail(String email) throws DAOException;

}
