package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Offer;
import com.promostree.domain.entities.Venue;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	public Offer findById(Long id);
}
