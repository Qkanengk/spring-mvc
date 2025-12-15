package com.codegym.quan_ly_blog_api.repository;

import com.codegym.quan_ly_blog_api.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategoryId(Pageable pageable, int id);

    @Query("select b from Blog b where(:keyword is null or  b.title like %:keyword% )and(:categoryId is null or b.category.id = :categoryId)")
    Page<Blog> search(Pageable pageable,
                      @Param("keyword") String keyword,
                      @Param("categoryId") Integer categoryId);


}
