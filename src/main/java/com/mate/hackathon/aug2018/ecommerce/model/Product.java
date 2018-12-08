package com.mate.hackathon.aug2018.ecommerce.model;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;

public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Category category;

    public static Product of(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        return product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
