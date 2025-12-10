package com.codegym.ung_dung_gio_hang.service;

import com.codegym.ung_dung_gio_hang.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
