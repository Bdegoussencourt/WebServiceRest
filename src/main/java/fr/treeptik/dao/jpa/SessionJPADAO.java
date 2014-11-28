package fr.treeptik.dao.jpa;

import javax.ejb.Stateless;

import fr.treeptik.dao.SessionDAO;
import fr.treeptik.model.Session;

@Stateless
public class SessionJPADAO extends GenericJPADAO<Session, Integer> implements SessionDAO{

	public SessionJPADAO() {
		super(Session.class);
		// TODO Auto-generated constructor stub
	}

}
