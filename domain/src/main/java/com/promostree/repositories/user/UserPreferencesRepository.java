package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserPreferences;

public interface UserPreferencesRepository extends
		JpaRepository<UserPreferences, Long> {

	List<UserPreferences> findByUserId(Long userId);
	
}
