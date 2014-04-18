package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByPhoneNumberOrEmail(String phno, String email);
	public User findById(Long id);
<<<<<<< HEAD
	
//	@Query("select user from User user where user.phoneNumber = ?1 AND user.email=  ?2")
	//@Query("phoneNumber:?1* AND email:?2*")
	public User findByPhoneNumberAndEmail(String phno,String email);

=======
	public User findByPhoneNumber(String phoneNumber);
>>>>>>> 83e8485faa8ba273f4e70a6805a2d0d0cdce2548
}
