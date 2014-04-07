package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
