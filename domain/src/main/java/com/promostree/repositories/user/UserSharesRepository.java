package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.UserShares;

public interface UserSharesRepository extends JpaRepository<UserShares, Long> {

}
