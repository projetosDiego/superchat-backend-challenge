package com.de.superchat.communication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   contactId;
	private String contactName;
	private String contactNumber;
	private String contactEmail;
	
	public Contact() {
	}

	public Contact(Long contactId, String contactName, String contactNumber, String contactEmail) {
		super();
		this.contactId     = contactId;
		this.contactName   = contactName;
		this.contactNumber = contactNumber;
		this.contactEmail  = contactEmail;
	}

	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}
