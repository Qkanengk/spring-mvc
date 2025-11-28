package com.codegym.calculator.controllers;

import com.codegym.calculator.services.ICalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculator")
public class HomeController {

    private final ICalculatorService calculatorService;
    public HomeController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("")
    public String home() {
        return "calculator/home";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("number1") Double number1, @RequestParam("number2") Double number2, @RequestParam("operator") char operator, RedirectAttributes redirectAttributes) {
        double result = calculatorService.calculate(number1, number2, operator);
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/calculator";
    }
}
