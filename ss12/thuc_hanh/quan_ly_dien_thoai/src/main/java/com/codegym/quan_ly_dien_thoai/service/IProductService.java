package com.codegym.quan_ly_dien_thoai.service;

import com.codegym.quan_ly_dien_thoai.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Integer id);

    Product save(Product product);

    public Product update(Integer id, Product product);

    void remove(Integer id);
}
