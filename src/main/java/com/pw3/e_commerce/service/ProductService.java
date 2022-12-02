package com.pw3.e_commerce.service;

import java.util.List;

import com.pw3.e_commerce.domain.Product;

public interface ProductService {

    void salvar(Product product);

    void editar(Product product);

    void excluir(Long id);

    Product buscarPorId(Long id);

    List<Product> buscarTodos();
}
