package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.SessionDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Session;
import fr.treeptik.service.SessionService;

@Stateless
public class SessionServiceImpl implements SessionService{

	@EJB
	private SessionDAO sessionDAO;
	
	@Override
	public void add(Session session) throws ServiceException {
		try {
			sessionDAO.add(session);
		} catch (DAOException e) {
			throw new ServiceException("SessionServiceImpl add : "+session, e);
		}
	}

	@Override
	public void update(Session session) throws ServiceException {
		try{
			sessionDAO.update(session);
		}catch(DAOException e){
			throw new ServiceException("SessionServiceImpl update : "+session, e);
		}
	}

	@Override
	public List<Session> getAll() throws ServiceException {
		try {
			return sessionDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("SessionServiceImpl getAll", e);
		}
	}

	@Override
	public Session get(Integer id) throws ServiceException {
		try {
			return sessionDAO.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("SessionServiceImpl get : "+id, e);
		}
	}

	@Override
	public void delete(Integer sessionId) throws ServiceException {
		try {
			sessionDAO.remove(get(sessionId));
		} catch (DAOException e) {
			throw new ServiceException("SessionServiceImpl delete : "+sessionId, e);
		}
	}

}
