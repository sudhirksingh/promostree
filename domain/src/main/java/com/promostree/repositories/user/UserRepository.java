package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//@Query("phoneNumber:?0")
	public User findByPhoneNumber(String phno);
	public User findById(long id);

}
