package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.entity.Blog;
import com.codegym.quan_ly_blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean save(Category category);
    boolean update(Integer id,Category category);
    boolean delete(Integer id);
    Category findById(Integer id);


}
