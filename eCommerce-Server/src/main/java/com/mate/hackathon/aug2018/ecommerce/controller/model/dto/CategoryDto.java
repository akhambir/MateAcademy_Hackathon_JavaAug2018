package com.mate.hackathon.aug2018.ecommerce.controller.model.dto;

import com.mate.hackathon.aug2018.ecommerce.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CategoryDto of(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }

    public static List<CategoryDto> of(List<Category> allCategories) {
        return allCategories.stream().map(CategoryDto::of).collect(Collectors.toList());
    }

}
