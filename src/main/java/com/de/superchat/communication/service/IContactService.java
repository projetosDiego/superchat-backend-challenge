package com.de.superchat.communication.service;

import java.util.List;

import com.de.superchat.communication.model.Contact;

public interface IContactService {

	List<Contact> findAll();

	void saveContact(Contact contact);

}
