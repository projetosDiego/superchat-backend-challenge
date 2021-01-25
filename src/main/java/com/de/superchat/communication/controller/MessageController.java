package com.de.superchat.communication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.de.superchat.communication.model.History;
import com.de.superchat.communication.model.MessageRequestDTO;
import com.de.superchat.communication.model.Placeholder;
import com.de.superchat.communication.service.IMessageService;

@RestController
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ResponseEntity<Void> getAdres(@RequestBody MessageRequestDTO message) {
		messageService.sendMessage(message);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/externalMessage", method = RequestMethod.POST)
	public ResponseEntity<Void> receiveMessage(@RequestBody MessageRequestDTO message) {
		messageService.receivMessage(message);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHistory", method = RequestMethod.GET)
	public ResponseEntity<List<History>> getHistory() {
		return new ResponseEntity<List<History>>(messageService.getHistory(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savePlaceholder", method = RequestMethod.POST)
	public ResponseEntity<Void> savePlaceholder(@RequestBody Placeholder placeholder) {
		messageService.savePlaceHolder(placeholder);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
