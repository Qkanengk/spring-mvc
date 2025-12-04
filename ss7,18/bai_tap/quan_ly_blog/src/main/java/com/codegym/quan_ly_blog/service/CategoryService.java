package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.entity.Blog;
import com.codegym.quan_ly_blog.entity.Category;
import com.codegym.quan_ly_blog.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean save(Category category) {
        return categoryRepository.save(category) != null;
    }

    @Override
    public boolean update(Integer id, Category category) {
        Category blog1 = categoryRepository.findById(id).orElse(null);
        if (blog1 != null) {
            blog1.setName(blog1.getName());
        }
        return categoryRepository.save(blog1) != null;

    }

    @Override
    public boolean delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
