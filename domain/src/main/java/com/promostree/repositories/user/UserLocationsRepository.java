package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserLocations;

public interface UserLocationsRepository extends
		JpaRepository<UserLocations, Long> {

}
