package com.codegym.quan_ly_blog_api.service;

import com.codegym.quan_ly_blog_api.dto.BlogCreationRequestDTO;
import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Blog;
import com.codegym.quan_ly_blog_api.mapper.BlogMapper;
import com.codegym.quan_ly_blog_api.repository.IBlogRepository;
import com.codegym.quan_ly_blog_api.repository.ICategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository blogRepository;
    private final ICategoryRepository categoryRepository;

    private final BlogMapper blogMapper;

    public BlogService(IBlogRepository blogRepository, ICategoryRepository categoryRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.categoryRepository = categoryRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public Page<BlogResponseDTO> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable).map(blogMapper::toResponseDTO);
    }

    @Override
    public Page<BlogResponseDTO> findAllByCategoryId(Pageable pageable, int id) {
        return blogRepository.findAllByCategoryId(pageable, id).map(blogMapper::toResponseDTO);
    }

    @Override
    public Page<BlogResponseDTO> search(Pageable pageable, String keyword, Integer categoryId) {
        return blogRepository.search(pageable, keyword, categoryId).map(blogMapper::toResponseDTO);
    }

    @Override
    public BlogResponseDTO findById(int id) {
        return blogMapper.toResponseDTO(blogRepository.findById(id).orElse(null));
    }

    @Override
    public Blog findByIdUpdate(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, BlogCreationRequestDTO blog) {
        Blog blog1 = findByIdUpdate(id);
        if (blog1 != null) {
            blog1.setTitle(blog.getTitle());
            blog1.setContent(blog.getContent());
            blog1.setCategory(categoryRepository.findById(blog.getCategoryId()).orElse(null));
            blogRepository.save(blog1);
        }
    }
}
