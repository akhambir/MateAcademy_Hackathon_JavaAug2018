package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return Optional.of(productService.findAll())
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productCode) {
        return productService.findByProductCode(productCode)
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
