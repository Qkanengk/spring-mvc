package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.dto.BlogDto;
import com.codegym.quan_ly_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> search(String title,Integer category, Pageable pageable);


    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    boolean save(Blog blog);

    boolean update(Integer id, Blog blog);

    boolean delete(Integer id);

    Blog findById(Integer id);

    BlogDto toDto(Blog blog);
}
