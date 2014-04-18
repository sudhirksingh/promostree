package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.EventType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

	
	//public UserEvent findById(Long id);
	
	//@Query("select userEvent from UserEvent userEvent where userEvent.userId = ?1 AND userEvent.eventTypeId=  ?2")
	public List<UserEvent>  findByUserAndType(User user,EventType eventType);
	
}
