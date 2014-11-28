package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.QuestionDAO;
import fr.treeptik.model.Question;
@Stateless
public class QuestionJPADAO extends GenericJPADAO<Question, Integer> implements QuestionDAO{

	public QuestionJPADAO() {
		super(Question.class);
		// TODO Auto-generated constructor stub
	}

}
