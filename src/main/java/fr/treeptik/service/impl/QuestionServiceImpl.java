package fr.treeptik.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.QuestionDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Question;
import fr.treeptik.service.QuestionService;

@Stateless
public class QuestionServiceImpl implements QuestionService{

	@EJB
	private QuestionDAO questionDAO;
	@Override
	public void add(Question question) throws ServiceException {
		try{
			questionDAO.add(question);
		}catch(DAOException e){
			throw new ServiceException("QuestionServiceImpl add : "+question, e);
		}
	}

	@Override
	public void update(Question question) throws ServiceException {
		try{
			questionDAO.update(question);
		}catch(DAOException e){
			throw new ServiceException("QuestionServiceImpl update : "+question, e);
		}
	}

	@Override
	public List<Question> getAll() throws ServiceException {
		try {
			return questionDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("QuestionServiceImpl getAll", e);
		}
	}

	@Override
	public Question get(Integer id) throws ServiceException {
		try {
			return questionDAO.findByPk(id);
		} catch (DAOException e) {
			throw new ServiceException("QuestionServiceImpl get : "+id, e);
		}
	}

	@Override
	public void delete(Integer questionId) throws ServiceException {
		try{
			questionDAO.remove(get(questionId));
		}catch(DAOException e){
			throw new ServiceException("QuestionServiceImpl delete : "+questionId, e);
		}
	}

}
