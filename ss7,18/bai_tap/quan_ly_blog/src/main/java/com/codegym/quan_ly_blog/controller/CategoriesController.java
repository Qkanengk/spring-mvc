package com.codegym.quan_ly_blog.controller;

import com.codegym.quan_ly_blog.entity.Blog;
import com.codegym.quan_ly_blog.entity.Category;
import com.codegym.quan_ly_blog.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
    private ICategoryService categoryService;


    public CategoriesController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("categories/list");
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("categories/add");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        categoryService.save(category);
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        categoryService.delete(id);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateForm(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("categories/update");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        categoryService.update(category.getId(), category);
        return modelAndView;
    }
}
