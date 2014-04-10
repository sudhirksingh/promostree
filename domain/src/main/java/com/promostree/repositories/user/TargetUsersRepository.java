package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.TargetUsers;

public interface TargetUsersRepository extends JpaRepository<TargetUsers, Long> {
	
	@Query("userId:?0")
	List<TargetUsers> findByUserId(long userId);

}
