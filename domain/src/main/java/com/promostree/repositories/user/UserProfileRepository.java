package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.promostree.domain.user.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    
public UserProfile findByUserId(Long userId);
}
