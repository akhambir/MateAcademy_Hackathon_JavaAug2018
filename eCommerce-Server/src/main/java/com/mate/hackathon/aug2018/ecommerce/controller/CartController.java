package com.mate.hackathon.aug2018.ecommerce.controller;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CartDto;
import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.ProductDto;
import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.service.CartService;
import com.mate.hackathon.aug2018.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @PostMapping("/buy")
    public ResponseEntity<CartDto> addProductToCart(@RequestBody ProductDto productDto, Principal principal) {
        String name = principal.getName();
        Optional<User> byEmail = userService.getByEmail(name);
        User user = byEmail.get();
        Cart cart = cartService.setProductQuantity(Product.of(productDto), productDto.getQuantity(), productDto.getCategoryName(), user);
        return ResponseEntity.ok(CartDto.of(cart));
    }

    @DeleteMapping("/cart/deleteProduct")
    public ResponseEntity<CartDto> deleteProductFromCart(@RequestBody ProductDto productDto, User user) {
        Cart cart = cartService.deleteProduct(Product.of(productDto), user);
        return ResponseEntity.ok(CartDto.of(cart));
    }
}
