package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findById(Long id);

}
