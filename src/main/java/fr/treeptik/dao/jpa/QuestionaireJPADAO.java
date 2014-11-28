package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.QuestionnaireDAO;
import fr.treeptik.model.Questionnaire;
@Stateless
public class QuestionaireJPADAO extends GenericJPADAO<Questionnaire, Integer> implements QuestionnaireDAO{

	public QuestionaireJPADAO() {
		super(Questionnaire.class);
		// TODO Auto-generated constructor stub
	}

}
