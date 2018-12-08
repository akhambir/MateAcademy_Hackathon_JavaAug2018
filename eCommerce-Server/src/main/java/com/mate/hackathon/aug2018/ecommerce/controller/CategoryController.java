package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CategoryDto;
import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(name = "/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return Optional.of(categoryService.findAll())
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping(name = "/{categoryName}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String name) {
        return categoryService.findByName(name)
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping(name = "/admin/category")
    public ResponseEntity<List<CategoryDto>> saveCategory(CategoryDto categoryDto) {
        categoryService.save(Category.of(categoryDto));
        return getAllCategory();
    }


    @PutMapping(name = "/admin/category/{name}")
    public ResponseEntity<List<CategoryDto>> updateCategory(@RequestBody CategoryDto category, @PathVariable String name) {
        Category categoryFromFront = Category.of(category);
        Optional<Category> optionalCategory = categoryService.findByName(name);
        Category oldCategory = null;
        if (optionalCategory.isPresent()) {
            oldCategory = optionalCategory.get();
        }
        oldCategory.setName(categoryFromFront.getName());
        categoryService.save(oldCategory);
        return getAllCategory();
    }

    @DeleteMapping(name = "/admin/category/{name}")
    public ResponseEntity<List<CategoryDto>> deleteByName(@PathVariable String name) {
        categoryService.deleteByName(name);
        return getAllCategory();
    }
}