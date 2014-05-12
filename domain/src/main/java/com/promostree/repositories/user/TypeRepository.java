package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.Type;

public interface TypeRepository extends
		JpaRepository<Type, Long> {

}
