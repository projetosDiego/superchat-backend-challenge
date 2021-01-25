package com.de.superchat.communication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.de.superchat.communication.exception.ContactCreatedException;
import com.de.superchat.communication.exception.ObjectNotFilledException;
import com.de.superchat.communication.exception.ObjectNotFoundException;
import com.de.superchat.communication.model.Contact;
import com.de.superchat.communication.repository.ContactRepository;
import com.de.superchat.communication.util.Constants;

@Service
public class ContactServiceImpl implements IContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	/**
	 * Method responsible for save the contact
	 * @param contact
	 */
	@Override
	public void saveContact(Contact contact) {
		Contact contactBd = new Contact();
		if(!"".equals(contact.getContactName()) && !"".equals(contact.getContactEmail()) && !"".equals(contact.getContactNumber())) {
			contactBd = contactRepository.findByContactNumber(contact.getContactNumber());
		}else {
			throw new ObjectNotFilledException(Constants.OBJECT_NOT_FILLED_EXCEPTION);
		}
		
		if(contactBd == null) {
			contactRepository.save(contact);
		}else {
			throw new ContactCreatedException(Constants.CONTACT_CREATED_EXCEPTION);
		}
	}

	/**
	 * Method responsible for list all contacts
	 */
	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = contactRepository.findAll();
		if(!contacts.isEmpty()) {
			return contacts;
		}else {
			throw new ObjectNotFoundException(Constants.OBJECT_NOT_FOUND_EXCEPTION);
		}
	}
}