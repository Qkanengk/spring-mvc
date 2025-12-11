package com.codegym.quan_ly_blog_api.repository;

import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategoryId(Pageable pageable, int id);
}
