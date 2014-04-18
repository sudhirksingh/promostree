package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//@Query("phoneNumber:?0")
	public User findByPhoneNumber(String phno);
	public User findById(Long id);
	
//	@Query("select user from User user where user.phoneNumber = ?1 AND user.email=  ?2")
	//@Query("phoneNumber:?1* AND email:?2*")
	public User findByPhoneNumberAndEmail(String phno,String email);

}
