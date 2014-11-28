package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.ResultatDAO;
import fr.treeptik.model.Resultat;

@Stateless
public class ResultatJPADAO extends GenericJPADAO<Resultat, Integer> implements ResultatDAO{

	public ResultatJPADAO() {
		super(Resultat.class);
		// TODO Auto-generated constructor stub
	}

}
