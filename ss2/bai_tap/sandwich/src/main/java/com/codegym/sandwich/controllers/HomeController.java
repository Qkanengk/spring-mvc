package com.codegym.sandwich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "sandwich/home";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiments", required = false) String[] condiments, Model model) {
        List<String> condimentList = condiments != null ? Arrays.asList(condiments) : Collections.emptyList();
        model.addAttribute("condimentList", condimentList);
        return "sandwich/home";
    }
}
