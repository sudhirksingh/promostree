package com.promostree.repositories.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserShout;

public interface UserShoutRepository extends JpaRepository<UserShout, Long> {
public List<UserShout> findByUserId(Long userId);
public List<UserShout> findByVenueId(Long venueId);
 }
