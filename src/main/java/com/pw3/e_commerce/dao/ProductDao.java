package com.pw3.e_commerce.dao;

import java.util.List;

import com.pw3.e_commerce.domain.Product;

public interface ProductDao {

    void save(Product product);

    void update(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();
}
