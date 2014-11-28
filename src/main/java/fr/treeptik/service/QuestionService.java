package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Question;

public interface QuestionService {
	public void add(Question question)throws ServiceException;
	public void update(Question question)throws ServiceException;
    public List<Question> getAll()throws ServiceException;
    public Question get(Integer id)throws ServiceException;
    public void delete(Integer questionId)throws ServiceException;
}
