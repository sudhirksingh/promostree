package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;

public interface UserPreferencesRepository extends JpaRepository<UserPreference, Long> {

public 	List<UserPreference> findByUserId(Long long1);
	
}
