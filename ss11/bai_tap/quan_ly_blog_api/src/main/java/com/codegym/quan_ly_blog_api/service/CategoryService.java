package com.codegym.quan_ly_blog_api.service;

import com.codegym.quan_ly_blog_api.dto.CategoryResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Category;
import com.codegym.quan_ly_blog_api.mapper.CategoryMapper;
import com.codegym.quan_ly_blog_api.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements  ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(ICategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryMapper.toDTOs(categoryRepository.findAll());
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
