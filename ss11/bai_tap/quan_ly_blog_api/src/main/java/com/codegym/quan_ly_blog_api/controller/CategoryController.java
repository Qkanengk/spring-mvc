package com.codegym.quan_ly_blog_api.controller;

import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.dto.CategoryResponseDTO;
import com.codegym.quan_ly_blog_api.service.IBlogService;
import com.codegym.quan_ly_blog_api.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        // 1. Gán kết quả vào biến (Chỉ gọi DB 1 lần duy nhất)
        Page<BlogResponseDTO> page = blogService.findAllByCategoryId(pageable, id);
        // 2. Kiểm tra nếu Category đó không tồn tại (Optional - Tùy logic Service của bạn)
        // Lưu ý: Nếu Service chỉ query thuần túy thì page luôn != null.
        // Bạn nên check hasContent() nếu muốn biết có bài viết hay không.
        // Logic chuẩn REST: Tìm kiếm ra list rỗng vẫn là thành công (200 OK)
        return ResponseEntity.ok(page);
    }
}
