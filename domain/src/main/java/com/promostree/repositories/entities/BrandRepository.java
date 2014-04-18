package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
