package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.EvaluationDAO;
import fr.treeptik.model.Evaluation;
@Stateless
public class EvaluationJPADAO extends GenericJPADAO<Evaluation, Integer> implements EvaluationDAO{

	public EvaluationJPADAO() {
		super(Evaluation.class);
	}

}
