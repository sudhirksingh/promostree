package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserShare;

public interface UserShareRepository extends JpaRepository<UserShare, Long> {

	
	//List<UserShare> findByUserId(Long userId);
	
	//List<UserShare>	findByTypeIdAndValue(Long TypeId,Long vlaue);
}
