package com.de.superchat.communication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.de.superchat.communication.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	@Query("FROM Contact WHERE contactNumber = ?1")
	Contact findByContactNumber(String contactNumber);

}
