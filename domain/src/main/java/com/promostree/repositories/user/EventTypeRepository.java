package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.EventType;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {

	public EventType findByName(String name);
	
}
