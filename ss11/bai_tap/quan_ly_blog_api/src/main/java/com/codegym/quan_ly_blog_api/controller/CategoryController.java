package com.codegym.quan_ly_blog_api.controller;

import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.dto.CategoryResponseDTO;
import com.codegym.quan_ly_blog_api.service.IBlogService;
import com.codegym.quan_ly_blog_api.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IBlogService blogService;

    public CategoryController(ICategoryService categoryService, IBlogService blogService) {
        this.categoryService = categoryService;
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        if (categoryService.findAll()!=null){
            return ResponseEntity.ok().body(categoryService.findAll());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/blogs")
    public ResponseEntity<Page<BlogResponseDTO>> findByCategoryId(
            @PathVariable("id") int id, // Nên để PathVariable lên trước cho dễ đọc
            @PageableDefault(size = 5) Pageable pageable) {
        Page<BlogResponseDTO> page = blogService.findAllByCategoryId(pageable, id);
        return ResponseEntity.ok(page);
    }
}
