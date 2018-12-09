package com.mate.hackathon.aug2018.ecommerce.controller.model.dto;

import com.mate.hackathon.aug2018.ecommerce.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {

    private String name;
    private String description;
    private List<ProductDto> products;

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

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public static List<CategoryDto> of(List<Category> allCategories) {
        return allCategories.stream().map(CategoryDto::of).collect(Collectors.toList());
    }

    public static CategoryDto of(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setProducts(ProductDto.of(category.getProducts()));
        return categoryDto;
    }

}
