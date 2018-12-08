package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import com.mate.hackathon.aug2018.ecommerce.model.User;
import com.mate.hackathon.aug2018.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
    public Cart addProduct(Product product, User user) {
        Integer defaultProductQuantity = 1;
        return setProductQuantity(product, user, defaultProductQuantity);
    }

    @Override
    public Cart setProductQuantity(Product product, User user, Integer quantity) {
        Optional<Cart> cartFromDB = cartRepository.findByUser_Id(user.getId());
        Cart cart;
        if (cartFromDB.isPresent()) {
            cart = cartFromDB.get();
            cart.setProductQuantity(product, quantity);
        } else {
            cart = new Cart();
            cart.setUser(user);
            cart.setProductQuantity(product, quantity);
        }
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart deleteProduct(Product product, User user) {
        Optional<Cart> optionalCart = cartRepository.findByUser_Id(user.getId());
        Cart cart = null;
        if (optionalCart.isPresent()) {
            cart = optionalCart.get();
            cart.deleteProduct(product);
            cartRepository.save(cart);
        }
        return cart;
    }
}
