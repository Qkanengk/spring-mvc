package com.codegym.quan_ly_dien_thoai.repository;

import com.codegym.quan_ly_dien_thoai.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
