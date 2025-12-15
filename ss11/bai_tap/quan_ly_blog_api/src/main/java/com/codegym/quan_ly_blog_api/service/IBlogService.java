package com.codegym.quan_ly_blog_api.service;

import com.codegym.quan_ly_blog_api.dto.BlogCreationRequestDTO;
import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<BlogResponseDTO> findAll(Pageable pageable);

    Page<BlogResponseDTO> findAllByCategoryId(Pageable pageable, int id);

    Page<BlogResponseDTO> search(Pageable pageable, String keyword, Integer categoryId);

    BlogResponseDTO findById(int id);

    Blog findByIdUpdate(int id);

    void save(Blog blog);

    void remove(int id);

    void update(Integer id, Blog blog);
}
