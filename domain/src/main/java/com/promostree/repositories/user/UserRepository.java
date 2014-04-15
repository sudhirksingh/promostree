package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByPhoneNumberOrEmail(String phno, String email);
	public User findById(Long id);
	public User findByPhoneNumber(String phoneNumber);
}
