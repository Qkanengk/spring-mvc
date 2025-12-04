package com.codegym.quan_ly_blog.controller;

import com.codegym.quan_ly_blog.entity.Blog;
import com.codegym.quan_ly_blog.entity.Category;
import com.codegym.quan_ly_blog.service.IBlogService;
import com.codegym.quan_ly_blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/search")
    public String searchByTitle(
            @RequestParam("keyword") String keyword,
            @RequestParam("category") Integer category,
            @PageableDefault(size = 5) Pageable pageable,
            Model model) {

        Page<Blog> page = blogService.search(keyword, category, pageable);

        model.addAttribute("page", page);              // QUAN TRỌNG — để list.html đọc page.hasNext()
        model.addAttribute("blogs",
                page.getContent().stream().map(blogService::toDto).toList()
        );
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("keyword", keyword);

        return "blogs/list";
    }


    @GetMapping("")
    public ModelAndView list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogPage = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("blogs/list");
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("blogs", blogPage.getContent().stream().map(blogService::toDto).toList());
        modelAndView.addObject("page", blogPage);
        return modelAndView;
    }


    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("blogs/add");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("blog") Blog blog) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        blogService.delete(id);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView updateForm(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("blogs/update");
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
        Category category = categoryService.findById(blog.getCategory().getId());
        blog.setCategory(category);
        blogService.update(blog.getId(), blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");

        return modelAndView;
    }

}
