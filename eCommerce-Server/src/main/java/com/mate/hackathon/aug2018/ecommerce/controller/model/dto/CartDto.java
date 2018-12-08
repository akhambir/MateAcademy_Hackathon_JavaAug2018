package com.mate.hackathon.aug2018.ecommerce.controller.model.dto;

import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private User user;
    private Double amount;
    private List<Product> products = new ArrayList<>();

    public static CartDto of(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setUser(cart.getUser());
        cartDto.setProducts(cart.getProducts());
        cartDto.setAmount(cart.getAmount());
        return cartDto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
