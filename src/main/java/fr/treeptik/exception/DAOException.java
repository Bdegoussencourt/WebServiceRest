package fr.treeptik.exception;

import java.io.Serializable;

public class DAOException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public DAOException(Exception e, String message) {
		super(message, e);
	}

	public DAOException(String string, Exception e) {
		super(string, e);
	}

}