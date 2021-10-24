package com.wfh.mobilestorespring.services;

import com.wfh.mobilestorespring.model.Product;
import com.wfh.mobilestorespring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        // valid
        return productRepository.save(product);
    }
}
