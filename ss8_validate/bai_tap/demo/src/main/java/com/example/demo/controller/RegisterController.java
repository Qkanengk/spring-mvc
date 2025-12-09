package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegisterController {
    private final IUserService userService;

    public RegisterController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String list() {
        return "user/register";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register/submit")
    public String save(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        userService.saveUser(user);
        return "user/success";

    }

}
