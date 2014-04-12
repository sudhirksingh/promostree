package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.TargetUser;

public interface TargetUsersRepository extends JpaRepository<TargetUser, Long> {
	
	//@Query("TargetUser.User.id:?0")
	List<TargetUser> findByUserId(Long userId);

}
