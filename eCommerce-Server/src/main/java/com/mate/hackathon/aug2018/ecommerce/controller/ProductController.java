package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ProductDto> getProductByProductCode(@PathVariable String productCode) {
        return productService.findByProductCode(productCode)
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping("/admin/products")
    public ResponseEntity<List<ProductDto>> saveProduct(@RequestBody ProductDto productDto) {
        productService.save(Product.of(productDto));
        return getAllProducts();
    }

    @PutMapping("/admin/products/{productCode}")
    public ResponseEntity<List<ProductDto>> updateProduct(@RequestBody ProductDto productDto, @PathVariable String productCode) {
        productDto.setProductCode(productCode);
        productService.save(Product.of(productDto));
        return getAllProducts();
    }

    @DeleteMapping("/admin/products/{productCode}")
    public ResponseEntity<List<ProductDto>> deleteByProductCode(@PathVariable String productCode) {
        productService.deleteByProductCode(productCode);
        return getAllProducts();
    }
}
