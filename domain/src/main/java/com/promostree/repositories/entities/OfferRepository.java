package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

}
