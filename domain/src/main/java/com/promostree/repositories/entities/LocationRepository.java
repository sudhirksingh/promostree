package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
