package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.LocationType;

public interface LocationTypeRepository extends
		JpaRepository<LocationType, Long> {
public LocationType findByName(String name);
}
