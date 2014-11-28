package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Questionnaire;

public interface QuestionnaireService {
	public void add(Questionnaire questionnaire)throws ServiceException;
	public void update(Questionnaire questionnaire)throws ServiceException;
    public List<Questionnaire> getAll()throws ServiceException;
    public Questionnaire get(Integer id)throws ServiceException;
    public void delete(Integer questionnaireId)throws ServiceException;
}
