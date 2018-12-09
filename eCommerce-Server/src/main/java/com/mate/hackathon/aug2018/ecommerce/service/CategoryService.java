package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findByName(String name);

    List<Category> findAll();

    Category save(Category category);

    void deleteByName(String name);

    Optional<Category> findByNameAndListProducts(String name);
}
