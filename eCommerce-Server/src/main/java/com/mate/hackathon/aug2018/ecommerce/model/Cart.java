package com.mate.hackathon.aug2018.ecommerce.model;

import com.mate.hackathon.aug2018.ecommerce.controller.model.dto.CartDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Long id;
    @Column(name = "FK_CUSTOMER_ID")
    private User user;
    private List<Product> products = new ArrayList<>();
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

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
