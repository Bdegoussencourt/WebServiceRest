package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.AdministrateurDAO;
import fr.treeptik.model.Administrateur;

@Stateless
public class AdministrateurJPADAO extends
		GenericJPADAO<Administrateur, Integer> implements AdministrateurDAO {

	public AdministrateurJPADAO() {
		super(Administrateur.class);
	}

}
