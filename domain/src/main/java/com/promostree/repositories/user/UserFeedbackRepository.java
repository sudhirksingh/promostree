package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserFeedback;

public interface UserFeedbackRepository extends
		JpaRepository<UserFeedback, Long> {

}
