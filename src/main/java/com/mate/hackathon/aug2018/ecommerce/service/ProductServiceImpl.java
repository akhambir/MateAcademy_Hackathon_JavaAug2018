package com.mate.hackathon.aug2018.ecommerce.service;

import com.mate.hackathon.aug2018.ecommerce.repository.ProductDao;
import com.mate.hackathon.aug2018.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Optional<Product> findByProductCode(Long productCode) {
        return productDao.findByProductCode(productCode);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product save(Product product) {
        return productDao.saveAndFlush(product);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
