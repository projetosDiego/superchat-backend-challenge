package com.de.superchat.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_placeholder")
public class Placeholder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   placeholderId;
	private String reservedWord;
	private String reservedWordValue;
	
	public Placeholder() {
	}

	public Placeholder(Long placeholderId, String reservedWord, String reservedWordValue) {
		super();
		this.placeholderId     = placeholderId;
		this.reservedWord      = reservedWord;
		this.reservedWordValue = reservedWordValue;
	}

	public Long getPlaceholderId() {
		return placeholderId;
	}
	public void setPlaceholderId(Long placeholderId) {
		this.placeholderId = placeholderId;
	}
	public String getReservedWord() {
		return reservedWord;
	}
	public void setReservedWord(String reservedWord) {
		this.reservedWord = reservedWord;
	}
	public String getReservedWordValue() {
		return reservedWordValue;
	}
	public void setReservedWordValue(String reservedWordValue) {
		this.reservedWordValue = reservedWordValue;
	}
}
