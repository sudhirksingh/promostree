package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserFeedback;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {
	
	// List<UserFeedback> findByVenueId(Long venueId);

}
