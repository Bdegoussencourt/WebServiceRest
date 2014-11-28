package fr.treeptik.service;

import java.util.List;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Administrateur;
import fr.treeptik.model.User;

public interface UserService {
	
	public void add(User user) throws ServiceException;

	public void update(User user) throws ServiceException;

	public List<User> getAll() throws ServiceException;

	public User get(Integer id) throws ServiceException;

	public User findWithEmail(String email) throws ServiceException;

	public void delete(Integer userId) throws ServiceException;
}