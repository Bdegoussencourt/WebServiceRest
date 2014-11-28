package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Session;

public interface SessionService {
	public void add(Session session)throws ServiceException;
	public void update(Session session)throws ServiceException;
    public List<Session> getAll()throws ServiceException;
    public Session get(Integer id)throws ServiceException;
    public void delete(Integer sessionId)throws ServiceException;
}
