package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CartDto;
import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/buy")
    public ResponseEntity<CartDto> addProduct(@RequestBody ProductDto productDto, User user) {
        Cart cart = cartService.increaseProductQuantity(Product.of(productDto), user);
        return ResponseEntity.ok(CartDto.of(cart));
    }
}
