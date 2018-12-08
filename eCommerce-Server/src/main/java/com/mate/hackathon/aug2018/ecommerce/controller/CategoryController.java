package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.model.Category;
import com.mate.hackathon.aug2018.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory() {
        return Optional.of(categoryService.findAll())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
