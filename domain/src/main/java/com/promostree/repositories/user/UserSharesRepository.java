package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.UserShares;

public interface UserSharesRepository extends JpaRepository<UserShares, Long> {

	@Query("userId:?0")
	List<UserShares> findUserShares(long userId);
	
}
