package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;

import java.util.Optional;

public interface CartService {

    Optional<Cart> findByUser(User user);

    Cart save(Cart cart);

    void increaseProductQuantity(Product product, User user);

    void decreaseProductQuantity(Product product, User user);

    void deleteProduct(Product product, User user);
}
