package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

	
	public UserEvent findById(Long id);
}
