package com.pw3.e_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pw3.e_commerce.dao.ProductDao;
import com.pw3.e_commerce.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    @Transactional(readOnly = true)
    @Override
    public Product buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> buscarTodos() {
        return dao.findAll();
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Product product) {
        dao.update(product);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void salvar(Product product) {
        dao.save(product);
    }

}
