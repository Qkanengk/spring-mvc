package com.codegym.quan_ly_blog_api.controller;

import com.codegym.quan_ly_blog_api.dto.BlogCreationRequestDTO;
import com.codegym.quan_ly_blog_api.dto.BlogResponseDTO;
import com.codegym.quan_ly_blog_api.entity.Blog;
import com.codegym.quan_ly_blog_api.service.IBlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateBlog(@PathVariable("id") Integer id, @RequestBody Blog blogCreationRequestDTO) {
        blogService.update(id, blogCreationRequestDTO);
        return ResponseEntity.ok().build();
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

    @GetMapping("/search")
    public ResponseEntity<Page<BlogResponseDTO>> search(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                                        @PageableDefault(size = 5) Pageable pageable) {
        Page<BlogResponseDTO> page = blogService.search(pageable, keyword, categoryId);
        if (page != null) {
            return ResponseEntity.ok().body(page);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")

    public ResponseEntity<Void> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> pudate(@RequestBody Blog blog) {
        blogService.save(blog);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<BlogResponseDTO> findByIdUpdate(@PathVariable("id") Integer id) {
        if (blogService.findById(id) != null) {
            return ResponseEntity.ok().body(blogService.findById(id));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        blogService.remove(id);
        return ResponseEntity.ok().build();
    }
}
