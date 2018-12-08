package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CategoryDto;
import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 588148e781fb3f07e2e81fbe69c636c869e45891

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

<<<<<<< HEAD
    @GetMapping(name = "/{Name}")
=======
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/{categoryName}")
>>>>>>> 588148e781fb3f07e2e81fbe69c636c869e45891
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String name) {
        return categoryService.findByName(name)
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

<<<<<<< HEAD
    @PostMapping(name = "/admin/category/")
    public ResponseEntity<List<CategoryDto>> saveCategory(CategoryDto categoryDto) {
=======
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/admin/category")
    public ResponseEntity<List<CategoryDto>> save(CategoryDto categoryDto) {
>>>>>>> 588148e781fb3f07e2e81fbe69c636c869e45891
        categoryService.save(Category.of(categoryDto));
        return getAllCategory();
    }

<<<<<<< HEAD
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
=======
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(name = "/admin/category")
>>>>>>> 588148e781fb3f07e2e81fbe69c636c869e45891
    public ResponseEntity<List<CategoryDto>> deleteByName(@PathVariable String name) {
        categoryService.deleteByName(name);
        return getAllCategory();
    }
}