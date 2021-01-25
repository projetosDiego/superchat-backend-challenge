package com.de.superchat.communication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.de.superchat.communication.config.TwilioConfiguration;
import com.de.superchat.communication.exception.ObjectNotFilledException;
import com.de.superchat.communication.exception.ObjectNotFoundException;
import com.de.superchat.communication.model.History;
import com.de.superchat.communication.model.MessageRequestDTO;
import com.de.superchat.communication.model.Placeholder;
import com.de.superchat.communication.repository.HistoryRepository;
import com.de.superchat.communication.repository.PlaceHolderRepository;
import com.de.superchat.communication.util.Constants;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	private TwilioConfiguration twilioConfiguration;
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Autowired
	private PlaceHolderRepository placeHolderRepository;

	/**
	 * Method responsible for send SMS messages
	 * @param messageRequest
	 */
	@Override
	public void sendMessage(MessageRequestDTO messageRequest) {
		if(!"".equals(messageRequest.getContactNumber()) && !"".equals(messageRequest.getMessage()) && !"".equals(messageRequest.getName())) {
			PhoneNumber    to      = new PhoneNumber(messageRequest.getContactNumber());
			PhoneNumber    from    = new PhoneNumber(twilioConfiguration.getNumber());
			String         message = validatePlaceholder(messageRequest.getMessage());
			MessageCreator creator = Message.creator(to, from, message);
			creator.create();
			saveHistory(messageRequest);
		}else {
			throw new ObjectNotFilledException(Constants.OBJECT_NOT_FILLED_EXCEPTION);
		}
	}
	
	/**
	 * Method responsible for validate and replace placeholders
	 * @param message
	 */
	private String validatePlaceholder(String message) {
		List<Placeholder> placeHolders = new ArrayList<Placeholder>();
		placeHolders = placeHolderRepository.findAll();
		if(!placeHolders.isEmpty()) {
			message = placeHolders.stream()
		             .map(iterator-> (Function<String,String>) s-> s.replaceAll(iterator.getReservedWord(), iterator.getReservedWordValue()))
		             .reduce(Function.identity(), Function::andThen)
		             .apply(message);
		}
		return message;
	}

	/**
	 * Method responsible for receive a external message
	 * @param messageReceived
	 */
	@Override
	public void receivMessage(MessageRequestDTO messageReceived) {
		if(!"".equals(messageReceived.getContactNumber()) && !"".equals(messageReceived.getMessage()) && !"".equals(messageReceived.getName())) {
			History hist = new History();
			hist.setMessage(messageReceived.getMessage());
			hist.setNumber(messageReceived.getContactNumber());
			hist.setName(messageReceived.getName());
			historyRepository.save(hist);
		}else {
			throw new ObjectNotFilledException(Constants.OBJECT_NOT_FILLED_EXCEPTION);
		}
	}
	
	/**
	 * Method responsible for list all previous conversations
	 */
	@Override
	public List<History> getHistory() {
		List<History> historiys = historyRepository.findAll();
		if(!historiys.isEmpty()) {
			return historiys;
		}else {
			throw new ObjectNotFoundException(Constants.OBJECT_NOT_FOUND_EXCEPTION);
		}
	}
	
	/**
	 * Method responsible for save the conversations
	 * @param messageRequest
	 */
	public void saveHistory(MessageRequestDTO messageRequest) {
		History hist = new History();
		hist.setMessage(messageRequest.getMessage());
		hist.setNumber(messageRequest.getContactNumber());
		hist.setName(messageRequest.getName());
		historyRepository.save(hist);
	}

	/**
	 * Method responsible for save placeholders
	 * @param placeholder
	 */
	@Override
	public void savePlaceHolder(Placeholder placeholder) {
		if(!"".equals(placeholder.getReservedWord()) && !"".equals(placeholder.getReservedWordValue())) {
			Placeholder placeHolder = new Placeholder();
			placeHolder.setReservedWord(placeholder.getReservedWord());
			placeHolder.setReservedWordValue(placeholder.getReservedWordValue());
			placeHolderRepository.save(placeHolder);
		}else {
			throw new ObjectNotFilledException(Constants.OBJECT_NOT_FILLED_EXCEPTION);
		}
	}
}