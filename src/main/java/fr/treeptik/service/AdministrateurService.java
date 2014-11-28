package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Administrateur;

public interface AdministrateurService {
	public void add(Administrateur administrateur)throws ServiceException;
	public void update(Administrateur administrateur)throws ServiceException;
    public List<Administrateur> getAll()throws ServiceException;
    public Administrateur get(Integer id)throws ServiceException;
    public Administrateur findWithEmail(String email)throws ServiceException;
    public void delete(Integer administrateurId)throws ServiceException;
   
}
