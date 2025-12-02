package com.codegym.quan_ly_san_pham.controller;

import com.codegym.quan_ly_san_pham.entity.Product;
import com.codegym.quan_ly_san_pham.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("view")
    public String view(@RequestParam("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "products/view";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") int id){
        productService.remove(id);
        return "redirect:/products";
    }
    @GetMapping("update")
    public String updateForm(@RequestParam("id") int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "products/update";
    }

    @GetMapping("add")
    public String addForm(Model model){
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("product")Product product){
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("update")
    public String update(@RequestParam("id") int id, @ModelAttribute("product")Product product){
        productService.update(id, product);

        return "redirect:/products";
    }
}
