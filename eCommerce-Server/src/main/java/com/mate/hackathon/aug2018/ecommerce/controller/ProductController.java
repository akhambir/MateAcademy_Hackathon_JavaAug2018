package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CategoryDto;
import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.service.CategoryService;
import com.mate.hackathon.aug2018.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/products/{categoryName}")
    public ResponseEntity<CategoryDto> getAllProductsByCategory(@PathVariable String categoryName) {
        return categoryService.findByNameAndListProducts(categoryName)
                .map(CategoryDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ProductDto> getProductByProductCode(@PathVariable String productCode) {
        return productService.findByProductCode(productCode)
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping("/admin/products")
    public ResponseEntity<CategoryDto> saveProduct(@RequestBody ProductDto productDto) {
        productService.save(Product.of(productDto));
        return getAllProductsByCategory(productDto.getCategoryName());
    }

    @PutMapping("/admin/products/{productCode}")
    public ResponseEntity<CategoryDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable String productCode) {
        productDto.setProductCode(productCode);
        productService.save(Product.of(productDto));
        return getAllProductsByCategory(productDto.getCategoryName());
    }

    @DeleteMapping("/admin/products/{productCode}")
    public ResponseEntity<CategoryDto> deleteByProductCode(@PathVariable String productCode, String categoryName) {
        productService.deleteByProductCode(productCode);
        return getAllProductsByCategory(categoryName);
    }
}
