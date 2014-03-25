package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
