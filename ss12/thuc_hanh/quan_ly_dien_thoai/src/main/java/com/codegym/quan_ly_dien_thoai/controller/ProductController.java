package com.codegym.quan_ly_dien_thoai.controller;

import com.codegym.quan_ly_dien_thoai.entity.Product;
import com.codegym.quan_ly_dien_thoai.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Product>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<Product> page = productService.findAll(pageable);
        if (page != null) {
            return ResponseEntity.ok().body(page);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("")
    public ResponseEntity<Product> findById(@RequestParam("id") Integer id) {
        Product product = productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product product1 = productService.save(product);
        if (product1 != null) {
            return ResponseEntity.ok().body(product1);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Product> delete(@RequestParam("id") Integer id) {
        productService.remove(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("")
    public ResponseEntity<Product> update(@RequestParam("id") Integer id, @RequestBody Product product) {
        Product product1 = productService.findById(id);
        if (product1 != null) {
            return ResponseEntity.ok().body(productService.update(id, product));
        }
        return ResponseEntity.badRequest().build();
    }
}
