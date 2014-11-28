package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.FormateurDAO;
import fr.treeptik.model.Formateur;
@Stateless
public class FormateurJPADAO extends GenericJPADAO<Formateur, Integer> implements FormateurDAO{

	public FormateurJPADAO() {
		super(Formateur.class);
		// TODO Auto-generated constructor stub
	}

}
