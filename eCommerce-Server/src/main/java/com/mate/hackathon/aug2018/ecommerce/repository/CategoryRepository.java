package com.mate.hackathon.aug2018.ecommerce.repository;

import com.mate.hackathon.aug2018.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    void deleteByName(String name);
}
