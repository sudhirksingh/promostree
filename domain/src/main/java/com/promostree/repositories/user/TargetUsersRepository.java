package com.promostree.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.user.TargetUsers;

public interface TargetUsersRepository extends JpaRepository<TargetUsers, Long> {

}
