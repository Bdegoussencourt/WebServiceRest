package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Evaluation;

public interface EvaluationService {
	public void add(Evaluation evaluation)throws ServiceException;
	public void update(Evaluation evaluation)throws ServiceException;
    public List<Evaluation> getAll()throws ServiceException;
    public Evaluation get(Integer id)throws ServiceException;
    public void delete(Integer evaluationId)throws ServiceException;
}
