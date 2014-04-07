package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserPreferences;

public interface UserPreferencesRepository extends
		JpaRepository<UserPreferences, Long> {

}
