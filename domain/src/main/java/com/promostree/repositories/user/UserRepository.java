package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.promostree.domain.user.User;
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByPhoneNumberOrEmail(String phno, String email);
	public  User findById(Long id);
//	@Query("select user from User user where user.phoneNumber = ?1 AND user.email=  ?2")
	//@Query("phoneNumber:?1* AND email:?2*")
	public User findByPhoneNumberAndEmail(String phno,String email);
	public User findByPhoneNumber(String phoneNumber);
	public List<User> findByIdNotIn(Long id);
	public User findByEmail(String email);


}
