package com.codegym.quan_ly_blog_api.controller;

import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.service.IBlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<Page<BlogResponseDTO>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        if (blogService.findAll(pageable) != null) {
            return ResponseEntity.ok().body(blogService.findAll(pageable));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponseDTO> findById(@PathVariable("id") int id) {
        if (blogService.findById(id) != null) {
            return ResponseEntity.ok().body(blogService.findById(id));
        }
        return ResponseEntity.notFound().build();

    }


}
