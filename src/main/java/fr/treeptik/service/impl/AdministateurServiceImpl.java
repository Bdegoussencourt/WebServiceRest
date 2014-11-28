package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.AdministrateurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Administrateur;
import fr.treeptik.model.User;

@Stateless
public class AdministateurServiceImpl {
	@EJB
	public AdministrateurDAO dao;

	public Administrateur saveAdministrateur(Administrateur entite)
			throws ServiceException {
		
		try {
			if (entite.getId() != null) {
				entite = dao.update(entite);
			} else {
				entite = dao.add(entite);
			}
		} catch (DAOException e) {
			throw new ServiceException("saveAdministrateur", e);
		}
		return entite;
	}

	public void removeAdministrateur(Administrateur entite)
			throws ServiceException {
		System.out.println("entite "+ entite);
		try {
			dao.remove(entite);
		} catch (DAOException e) {
			throw new ServiceException("removeAdministrateur", e);
		}
	}

	public User getAdministrateurById(Integer id)
			throws ServiceException {
		User u = null;
		try {
			u = dao.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("getAdministrateur", e);
		}
		return u;
	}

	public List<Administrateur> getALLAdministrateurs() throws ServiceException {
		List<Administrateur> administrateurs = null;
		try {
			administrateurs = dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException("getALLAdministrateurs", e);
		}
		return administrateurs;
	}

}
