package fr.treeptik.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.treeptik.dao.UserDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

@Stateless
public class UserServiceImpl implements UserService {
	@EJB
	private UserDAO userDAO;

	@Override
	public void add(User user) throws ServiceException {
		try {
			userDAO.add(user);
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl add", e);
		}
	}

	@Override
	public void update(User user) throws ServiceException {
		try {
			userDAO.update(user);
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl update", e);
		}
	}

	@Override
	public List<User> getAll() throws ServiceException {
		try {
			return userDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl getAll", e);
		}
	}

	@Override
	public User get(Integer id) throws ServiceException {
		try {
			return userDAO.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl get", e);
		}
	}

	@Override
	public void delete(Integer userId) throws ServiceException {
		try {
			userDAO.remove(get(userId));
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl delete", e);
		}
	}

	@Override
	public User findWithEmail(String email) throws ServiceException {
		try {
			return userDAO.findByEmail(email);
		} catch (DAOException e) {
			throw new ServiceException("UserServiceImpl findWithEmail : "
					+ email, e);
		}
	}
}