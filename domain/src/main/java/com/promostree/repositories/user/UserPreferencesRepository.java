package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserPreference;

public interface UserPreferencesRepository extends
		JpaRepository<UserPreference, Long> {

}
