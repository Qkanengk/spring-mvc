package com.codegym.quan_ly_blog_api.service;

import com.codegym.quan_ly_blog_api.dto.CategoryResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Category;

import java.util.List;

public interface ICategoryService {
    void save(Category category);
    List<CategoryResponseDTO> findAll();

    Category findById(int id);
}
