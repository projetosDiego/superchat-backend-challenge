package com.de.superchat.communication.service;

import java.util.List;

import com.de.superchat.communication.model.History;
import com.de.superchat.communication.model.MessageRequestDTO;
import com.de.superchat.communication.model.Placeholder;

public interface IMessageService {
	
	public void sendMessage(MessageRequestDTO message);
	
	public void receivMessage(MessageRequestDTO message);

	public List<History> getHistory();

	public void savePlaceHolder(Placeholder placeholder);

}
