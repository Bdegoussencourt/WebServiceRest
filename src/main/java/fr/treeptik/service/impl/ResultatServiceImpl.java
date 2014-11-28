package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.ResultatDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Resultat;
import fr.treeptik.service.ResultatService;

@Stateless
public class ResultatServiceImpl implements ResultatService{

	@EJB
	private ResultatDAO resultatDAO;
	@Override
	public void add(Resultat resultat) throws ServiceException {
		try{
			resultatDAO.add(resultat);
		}catch(DAOException e){
			throw new ServiceException("ResultatServiceImpl add : "+resultat,e);
		}
	}

	@Override
	public void update(Resultat resultat) throws ServiceException {
		try{
			resultatDAO.update(resultat);
		}catch(DAOException e){
			throw new ServiceException("ResultatServiceImpl update : "+resultat, e);
		}
	}

	@Override
	public List<Resultat> getAll() throws ServiceException {
		try {
			return resultatDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("ResultatServiceImpl getAll", e);
		}
	}

	@Override
	public Resultat get(Integer id) throws ServiceException {
		try {
			return resultatDAO.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("ResultatServiceImpl get", e);
		}
	}

	@Override
	public void delete(Integer resultatId) throws ServiceException {
		try {
			resultatDAO.remove(get(resultatId));
		} catch (DAOException e) {
			throw new ServiceException("ResultatServiceImpl delete : "+resultatId,e);
		}
	}

}
