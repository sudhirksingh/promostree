package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Brand;
import com.promostree.domain.entities.Venue;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	public Brand findById(Long id);
}
