package com.mate.hackathon.aug2018.ecommerce.repository;

import com.mate.hackathon.aug2018.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
