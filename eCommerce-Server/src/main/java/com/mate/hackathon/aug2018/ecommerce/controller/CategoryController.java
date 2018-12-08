package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CategoryDto;
import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return Optional.of(categoryService.findAll())
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/{categoryName}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String name) {
        return categoryService.findByName(name)
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/admin/category")
    public ResponseEntity<List<CategoryDto>> save(CategoryDto categoryDto) {
        categoryService.save(Category.of(categoryDto));
        return getAllCategory();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/admin/category")
    public ResponseEntity<List<CategoryDto>> deleteByName(@PathVariable String name) {
        categoryService.deleteByName(name);
        return getAllCategory();
    }
}