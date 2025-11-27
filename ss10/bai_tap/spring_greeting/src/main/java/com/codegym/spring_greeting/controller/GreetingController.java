package com.codegym.spring_greeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")  // ← Thêm mapping cho root
    public String home() {
        return "index";
    }
    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }
}
