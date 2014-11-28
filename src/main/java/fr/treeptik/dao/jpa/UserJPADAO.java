package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.UserDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.User;

@Stateless
public class UserJPADAO extends GenericJPADAO<User, Integer> implements UserDAO {

	public UserJPADAO() {
		super(User.class);
	}

	@Override
	public Integer CountEmailUseWithoutId(String email, Integer id) {
		String req = "";
		if (id != null) {
			req = "Select count(*) from  User where email=:email and id!=:id ";
		} else {
			req = "Select count(*) from  User where email=:email ";
		}

		Query createQuery = getEntityManager().createQuery(req);

		createQuery.setParameter("email", email);
		if (id != null) {
			createQuery.setParameter("id", id);
		}

		Number result = (Number) createQuery.getSingleResult();

		return result.intValue();
	}

	@Override
	public User findByEmail(String email) throws DAOException {
		User user = null;
		try {
			String queryString = "select distinct c from User c where c.email=:email";
			TypedQuery<User> query = em.createQuery(queryString, User.class)
					.setParameter("email", email);
			if (query.getResultList().size() == 0) {
				return null;
			}
			user = query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException(e, "Erreur findByEmail : " + email);
		}
		return user;
	}

}
