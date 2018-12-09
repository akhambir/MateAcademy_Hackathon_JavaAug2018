package com.mate.hackathon.aug2018.ecommerce.repository;

import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    void deleteByName(String name);

    @Query("SELECT c FROM CATEGORIES c JOIN FETCH c.products WHERE c.name = (:name)")
    Optional<Category> findByNameAndListProducts(@Param("name") String name);
}
