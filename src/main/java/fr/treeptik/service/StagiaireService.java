package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Stagiaire;

public interface StagiaireService {
	public void add(Stagiaire stagiaire)throws ServiceException;
	public void update(Stagiaire stagiaire)throws ServiceException;
    public List<Stagiaire> getAll()throws ServiceException;
    public Stagiaire get(Integer id)throws ServiceException;
    public Stagiaire findWithEmail(String email)throws ServiceException;
    public void delete(Integer stagiaireId)throws ServiceException;
    public String generatePassword();
}
