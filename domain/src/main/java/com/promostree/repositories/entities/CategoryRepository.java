package com.promostree.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promostree.domain.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
