package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserShout;

public interface UserShoutRepository extends JpaRepository<UserShout, Long> {

}
