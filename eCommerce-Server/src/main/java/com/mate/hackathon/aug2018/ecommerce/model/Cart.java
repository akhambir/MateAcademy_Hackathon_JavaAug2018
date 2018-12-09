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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "CartDetailsId.fkCartId")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("FK_CUSTOMER_ID")
    private User user;

    private List<CartDetails> products = new ArrayList<>();
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<CartDetails> getProducts() {
        return products;
    }

    public void setProducts(List<CartDetails> products) {
        this.products = products;
    }

    public void setProductAndQuantity(Product product, Integer quantity) {

        CartDetails cartDetails = createCartDetails(product);
        cartDetails.setQuantity(quantity);

        if (products.contains(cartDetails)) {
            int index = products.indexOf(cartDetails);
            products.set(index, cartDetails);
        } else {
            products.add(cartDetails);
        }
    }

    public void deleteProduct(Product product) {
        CartDetails cartDetails = createCartDetails(product);
        products.remove(cartDetails);
    }

    private CartDetails createCartDetails(Product product) {
        CartDetails cartDetails = CartDetails.empty();
        CartDetailsId cartDetailsId = CartDetailsId.empty();
        cartDetailsId.setFkCartId(this.getId());
        cartDetailsId.setProduct(product);
        cartDetails.setCartDetailsId(cartDetailsId);
        return cartDetails;
    }
}
