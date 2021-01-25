package com.de.superchat.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_history")
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   histId;
	private String name;
	private String number;
	private String message;
	
	public History() {
	}

	public History(Long histId, String name, String number, String message) {
		super();
		this.histId  = histId;
		this.name    = name;
		this.number  = number;
		this.message = message;
	}

	public Long getHistId() {
		return histId;
	}
	public void setHistId(Long histId) {
		this.histId = histId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
