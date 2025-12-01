package com.codegym.bai1.controllers;

import com.codegym.bai1.entities.Setting;
import com.codegym.bai1.services.ISettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/setting")
public class SettingController {
    private ISettingService settingService;
    public SettingController(ISettingService settingService) {
        this.settingService = settingService;
    }
    @GetMapping("/home")
    public ModelAndView home(@ModelAttribute("setting") Setting setting) {
        ModelAndView modelAndView = new ModelAndView();
        if (setting == null || setting.getLanguage() == null) {
            setting = new Setting();
        }

        modelAndView.setViewName("setting/home");
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("setting") Setting setting, RedirectAttributes ra) {
        settingService.add(setting);
        ra.addFlashAttribute(setting);
        return "redirect:/setting/home";
    }
}
