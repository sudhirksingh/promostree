package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Groups;

public interface GroupRepository extends JpaRepository<Groups, Long> {

}
