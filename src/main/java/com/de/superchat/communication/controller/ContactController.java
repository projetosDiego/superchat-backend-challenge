package com.de.superchat.communication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.de.superchat.communication.model.Contact;
import com.de.superchat.communication.service.IContactService;

@RestController
@RequestMapping("contact")
public class ContactController {
	
	@Autowired
	private IContactService contactService;
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ResponseEntity<Void> saveContact(@RequestBody Contact Contact) {
		contactService.saveContact(Contact);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getContacts", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> getContacts() {
		return new ResponseEntity<List<Contact>>(contactService.findAll(), HttpStatus.OK);
	}

}
