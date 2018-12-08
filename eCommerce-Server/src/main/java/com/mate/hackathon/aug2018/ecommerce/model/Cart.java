package com.mate.hackathon.aug2018.ecommerce.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Long id;
    private User user;
    private Map<Product, Integer> products = new HashMap<>();
    private Double amount;

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
}
