package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
