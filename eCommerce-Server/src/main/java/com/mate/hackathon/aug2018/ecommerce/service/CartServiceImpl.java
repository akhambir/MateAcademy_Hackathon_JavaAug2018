package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Optional<Cart> findByUser(User user) {
        return cartRepository.findByUser_Id(user.getId());
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void increaseProductQuantity(Product product, User user) {
        Optional<Cart> cartFromDB = cartRepository.findByUser_Id(user.getId());
        Cart cart;
        Integer defaultProductQuantity = 1;
        if (cartFromDB.isPresent()) {
            cart = cartFromDB.get();
            cart.increaseQuantity(product, defaultProductQuantity);
        } else {
            cart = new Cart();
            cart.setUser(user);
            cart.increaseQuantity(product, defaultProductQuantity);
        }
        cartRepository.save(cart);
    }

    @Override
    public void decreaseProductQuantity(Product product, User user) {
        Optional<Cart> cartFromDB = cartRepository.findByUser_Id(user.getId());
        if (cartFromDB.isPresent()) {
            Cart cart = cartFromDB.get();
            Integer defaultProductQuantity = 1;
            cart.decreaseQuantity(product, defaultProductQuantity);
            cartRepository.save(cart);
        }
    }

    @Override
    public void deleteProduct(Product product, User user) {
        Optional<Cart> optionalCart = cartRepository.findByUser_Id(user.getId());
        if (optionalCart.isPresent()) {
            Cart cartFromDB = optionalCart.get();
            cartFromDB.deleteProduct(product);
            cartRepository.save(cartFromDB);
        }
    }
}
