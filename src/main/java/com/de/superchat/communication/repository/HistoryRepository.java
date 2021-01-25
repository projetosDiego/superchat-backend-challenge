package com.de.superchat.communication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.de.superchat.communication.model.History;

public interface HistoryRepository extends JpaRepository<History, Long>{

}
