package com.codegym.quan_ly_blog.service;

import com.codegym.quan_ly_blog.dto.BlogDto;
import com.codegym.quan_ly_blog.entity.Blog;
import com.codegym.quan_ly_blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private IBlogRepository blogRepository;

    private ModelMapper modelMapper;


    public BlogService(IBlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }


    public BlogDto toDto(Blog blog) {
        BlogDto dto = modelMapper.map(blog, BlogDto.class);
        dto.setCategoryId(blog.getCategory().getId());
        dto.setCategoryName(blog.getCategory().getName());
        return dto;
    }

    @Override
    public Page<Blog> search(String title,Integer category, Pageable pageable) {
        return blogRepository.findByTitleContainingAndCategoryId(title, category,pageable);
    }




    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean save(Blog blog) {
        return blogRepository.save(blog) != null;
    }

    @Override
    public boolean update(Integer id, Blog blog) {
        Blog blog1 = blogRepository.findById(id).orElse(null);
        if (blog1 != null) {
            blog1.setTitle(blog.getTitle());
            blog1.setContent(blog.getContent());
            blog1.setCategory(blog.getCategory());
        }
        return blogRepository.save(blog1) != null;

    }

    @Override
    public boolean delete(Integer id) {
        try {
            blogRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }
}
