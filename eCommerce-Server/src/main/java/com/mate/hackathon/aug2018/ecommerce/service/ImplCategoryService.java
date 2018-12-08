package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCategoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Optional<Category> findByName(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
