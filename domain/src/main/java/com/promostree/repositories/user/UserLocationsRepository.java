package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserLocation;

public interface UserLocationsRepository extends
		JpaRepository<UserLocation, Long> {

}
