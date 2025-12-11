package com.codegym.quan_ly_blog_api.repository;

import com.codegym.quan_ly_blog_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
