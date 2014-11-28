package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Formateur;

public interface FormateurService {
	public void add(Formateur formateur)throws ServiceException;
	public void update(Formateur formateur)throws ServiceException;
    public List<Formateur> getAll()throws ServiceException;
    public Formateur get(Integer id)throws ServiceException;
    public void delete(Integer formateurId)throws ServiceException;
}
