package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;


public interface UserPreferenceRepository extends
		JpaRepository<UserPreference, Long> {
	List<UserPreference> findByUserId(Long userId);
	List<UserPreference> findByUserIdAndTypeId(Long userId,Long typeId);
	List<UserPreference> findByTypeIdAndValue(Long typeId,Long value);

	
}
