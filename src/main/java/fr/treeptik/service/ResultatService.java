package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Resultat;

public interface ResultatService {
	public void add(Resultat resultat)throws ServiceException;
	public void update(Resultat resultat)throws ServiceException;
    public List<Resultat> getAll()throws ServiceException;
    public Resultat get(Integer id)throws ServiceException;
    public void delete(Integer resultatId)throws ServiceException;
}
