package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.promostree.domain.user.User;
import com.promostree.domain.user.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

	
	
	
}
