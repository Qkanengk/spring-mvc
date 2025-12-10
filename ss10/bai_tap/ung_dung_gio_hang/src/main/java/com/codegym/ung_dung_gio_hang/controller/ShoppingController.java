package com.codegym.ung_dung_gio_hang.controller;

import com.codegym.ung_dung_gio_hang.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
@Controller // 1. Bắt buộc phải có để Spring quản lý
@SessionAttributes("cart")
public class ShoppingController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}
