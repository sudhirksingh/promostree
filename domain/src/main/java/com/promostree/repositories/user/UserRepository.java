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
    public List<User> findByPhoneNumberIn(List<String> id);
	public User findByPhoneNumberAndEmail(String phno,String email);
	public User findByPhoneNumber(String phoneNumber);
	public List<User> findByIdNotIn(Long id);
	public User findByEmail(String email);


}
