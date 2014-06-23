package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Brand;
import com.promostree.domain.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	public Location findById(Long id);
}
