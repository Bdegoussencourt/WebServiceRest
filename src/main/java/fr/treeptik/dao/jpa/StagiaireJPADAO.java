package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.StagiaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Stagiaire;

@Stateless
public class StagiaireJPADAO extends GenericJPADAO<Stagiaire, Integer>
		implements StagiaireDAO {

	public StagiaireJPADAO() {
		super(Stagiaire.class);
	}

	@Override
	public Stagiaire findByEmail(String email) throws DAOException {
		Stagiaire stagiaire = null;
		try {
			String queryString = "select distinct c from User c where c.email=:email";
			TypedQuery<Stagiaire> query = em.createQuery(queryString,
					Stagiaire.class).setParameter("email", email);
			if (query.getResultList().size() == 0) {
				return null;
			}
			stagiaire = query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException(e, "Erreur findByEmail : " + email);
		}
		return stagiaire;
	}
}
