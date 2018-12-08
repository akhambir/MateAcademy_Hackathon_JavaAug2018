package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return Optional.of(productService.findAll())
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> getProductByProductCode(@PathVariable String productCode) {
        return productService.findByProductCode(productCode)
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/admin/products/save")
    public ResponseEntity<List<ProductDto>> saveProduct(ProductDto productDto) {
        productService.save(Product.of(productDto));
        return getAllProducts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/products/{productCode}")
    public ResponseEntity<ProductDto> showEditPage(@PathVariable String productCode) {
        return productService.findByProductCode(productCode)
                .map(ProductDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/products/create")
    public ResponseEntity<ProductDto> showCreatePage() {
        return ResponseEntity.ok(ProductDto.empty());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin/products/delete_{productCode}")
    public ResponseEntity<List<ProductDto>> deleteByProductCode(@PathVariable String productCode) {
        productService.deleteByProductCode(productCode);
        return getAllProducts();
    }
}
