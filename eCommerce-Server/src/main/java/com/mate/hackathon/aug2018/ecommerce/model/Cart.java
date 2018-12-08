package com.mate.hackathon.aug2018.ecommerce.model;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CartDto;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FK_CUSTOMER_ID")
    private User user;
    private Map<Product, Integer> products = new HashMap<>();
    @Column(name = "AMOUNT")
    private Double amount;

    public static Cart of(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setUser(cartDto.getUser());
        cart.setProducts(cartDto.getProducts());
        cart.setAmount(cartDto.getAmount());
        return cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public void increaseQuantity(Product product, Integer quantity) {
        if (products.containsKey(product)) {
            Integer previousQuantity = products.get(product);
            quantity += previousQuantity;
        }
        products.put(product, quantity);
    }

    public void decreaseQuantity(Product product, Integer quantity) {
        Integer previousQuantity = products.get(product);
        if (previousQuantity > 1) {
            products.put(product, previousQuantity - quantity);
        }
    }
}
