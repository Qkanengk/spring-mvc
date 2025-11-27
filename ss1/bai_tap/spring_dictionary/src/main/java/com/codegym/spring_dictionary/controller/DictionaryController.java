package com.codegym.spring_dictionary.controller;

import com.codegym.spring_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/find")
    public String search(@RequestParam("keyword") String keyword, Model model){
        model.addAttribute("result", dictionaryService.findWord(keyword));
        return "home";
    }
}
