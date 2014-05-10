package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.UserShare;

public interface UserSharesRepository extends JpaRepository<UserShare, Long> {


	public List<UserShare> findByUserId(Long userId);
	public List<UserShare> findByTypeIdAndValue(Long typeId,Long value);
	
}
