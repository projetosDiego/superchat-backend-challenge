package com.de.superchat.communication.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 7465743800857659454L;

	public ObjectNotFoundException(String message) {
		super(message);
	}

}
