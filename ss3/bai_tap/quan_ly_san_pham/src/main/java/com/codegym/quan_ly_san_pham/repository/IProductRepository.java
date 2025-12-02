package com.codegym.quan_ly_san_pham.repository;

import com.codegym.quan_ly_san_pham.entity.Product;

import java.util.List;

public interface IProductRepository{
    List<Product> getAllProducts();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}
