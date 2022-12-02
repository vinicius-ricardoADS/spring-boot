package com.pw3.e_commerce.dao;

import org.springframework.stereotype.Repository;

import com.pw3.e_commerce.domain.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Long> implements ProductDao {

}
