package fr.treeptik.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;

public abstract class GenericJPADAO<T, P> implements GenericDAO<T, P> {

	private Class<T> type;
	@PersistenceContext(unitName = "entityManager")
	protected EntityManager em;

	public GenericJPADAO(Class<T> type) {
		this.type = type;
	}

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;

	public T update(T entite) throws DAOException {
		try {
			entityManager.merge(entite);
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO update" + entite, e);
		}
		return entite;
	}

	public T add(T entite) throws DAOException {
		try {
			entityManager.persist(entite);
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO add" + entite, e);
		}
		return entite;
	}

	public void remove(T entite) throws DAOException {
		try {
			entite = entityManager.merge(entite);
			entityManager.remove(entite);
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO remove" + entite, e);
		}
	}

	public void removeById(P id) throws DAOException {
		try {
			entityManager.remove(id);
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO removebyId" + id, e);
		}
	}

	public List<T> findAll() throws DAOException {
		List<T> t = null;
		try {
			TypedQuery<T> query = entityManager.createQuery("Select t from "
					+ type.getSimpleName() + " t", type);

			t = query.getResultList();
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO findAll", e);
		}
		return t;
	}

	public T findByPk(P id) throws DAOException {
		T entity = null;
		try {
			entity = entityManager.find(type, id);
		} catch (Exception e) {
			throw new DAOException("GenericJPADAO findByPk", e);
		}
		return entity;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}