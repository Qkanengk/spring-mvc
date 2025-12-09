package com.codegym.ung_dung_muon_sach.controller;

import com.codegym.ung_dung_muon_sach.service.IBookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String findAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("books", bookService.findAll(pageable));
        return "books/list";
    }

    @GetMapping("view")
    public String viewBook(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "books/view";
    }
}
