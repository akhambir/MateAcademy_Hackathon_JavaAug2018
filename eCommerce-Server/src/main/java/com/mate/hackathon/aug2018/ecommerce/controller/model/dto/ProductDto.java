package com.mate.hackathon.aug2018.ecommerce.controller.model.dto;

import com.mate.hackathon.aug2018.ecommerce.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    private String productCode;
    private String name;
    private String description;
    private Double price;
    private String categoryName;
    private Integer quantity;

    public static ProductDto of(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductCode(product.getProductCode());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setCategoryName(product.getCategory().getName());
        return productDto;
    }

    public static List<ProductDto> of(List<Product> products) {
        return products.stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }

    public static ProductDto empty() {
        return new ProductDto();
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
