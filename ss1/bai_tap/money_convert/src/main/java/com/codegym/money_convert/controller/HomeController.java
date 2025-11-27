package com.codegym.money_convert.controller;

import com.codegym.money_convert.service.IMoneyConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private IMoneyConvertService moneyConvertService;

    @GetMapping("/")
    public String home() {
        return "result";
    }


    @GetMapping("/convert/usd-to-vnd")
    public String convertUSDToVND(@RequestParam("value") Double value, Model model) {
        model.addAttribute("result", moneyConvertService.USDToVND(value));
        model.addAttribute("value", value); // for display ( not necessary)
        return "result";
    }

    @GetMapping("/convert/vnd-to-usd")
    public String convertVNDToUSD(@RequestParam("value") Double value, Model model) {
        model.addAttribute("result", moneyConvertService.VNDToUSD(value));
        return "result";
    }
}
