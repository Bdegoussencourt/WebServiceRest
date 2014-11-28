package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.StagiaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Stagiaire;
import fr.treeptik.model.User;

@Stateless
public class StagiaireServiceImpl {
	@EJB
	public StagiaireDAO dao;

	// @EJB
	// public MailUtils mailUtils;

	public User saveStagiaire(Stagiaire entite) throws ServiceException {
		try {
			if (entite.getId() != null && entite.getId() != 0) {
				entite = dao.update(entite);
			} else {
				entite.setId(null);
				entite = dao.add(entite);
				// mailUtils.mailSenderToStagiaire(entite);
			}
		} catch (DAOException e) {
			throw new ServiceException("saveStagiaire", e);
		}
		return entite;
	}

	public void removeStagiaire(Stagiaire entite) throws ServiceException {
		try {

			dao.remove(entite);
		} catch (DAOException e) {
			throw new ServiceException("removeStagiaire", e);
		}
	}

	public User getStagiaireById(Integer id) throws ServiceException {
		User u = null;
		try {
			u = dao.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("getStagiaire", e);
		}
		return u;
	}

	public List<Stagiaire> getALLStagiaires() throws ServiceException {
		List<Stagiaire> stagiaires = null;
		try {
			stagiaires = dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException("getALLStagiaires", e);
		}
		return stagiaires;
	}
}
