package com.codegym.quan_ly_blog.repository;

import com.codegym.quan_ly_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog>findByTitleContainingAndCategoryId(String title,Integer category, Pageable pageable);

}
