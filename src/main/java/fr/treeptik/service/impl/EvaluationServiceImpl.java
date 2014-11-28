package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.EvaluationDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Evaluation;
import fr.treeptik.service.EvaluationService;

@Stateless
public class EvaluationServiceImpl implements EvaluationService{

	@EJB
	private EvaluationDAO evaluationDAO;
	@Override
	public void add(Evaluation evaluation) throws ServiceException {
		try{
			evaluationDAO.add(evaluation);
		}catch(DAOException e){
			throw new ServiceException("EvaluationService Impl save :"+evaluation,e);
		}
		
	}

	@Override
	public void update(Evaluation evaluation) throws ServiceException {
		try{
			evaluationDAO.update(evaluation);
		}catch(DAOException e){
			throw new ServiceException("EvaluationServiceImpl update : "+evaluation,e);
		}
		
	}

	@Override
	public List<Evaluation> getAll() throws ServiceException {
		try{
			return evaluationDAO.findAll();
		}catch(DAOException e){
			throw new ServiceException("EvaluationServiceImpl getAll",e);
		}
		
	}

	@Override
	public Evaluation get(Integer id) throws ServiceException {
		try{
			return evaluationDAO.findByPk(id);
		}catch(DAOException e){
			throw new ServiceException("EvaluationServiceImpl get : "+id, e);
		}
		
	}

	@Override
	public void delete(Integer evaluationId) throws ServiceException {
		try{
			evaluationDAO.remove(get(evaluationId));
		}catch(DAOException e){
			throw new ServiceException("EvaluationServiceImpl delete : "+evaluationId, e);
		}
	}

}
