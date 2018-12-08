package com.mate.hackathon.aug2018.ecommerce.repository;

import com.mate.hackathon.aug2018.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
