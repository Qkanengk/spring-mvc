package com.codegym.ung_dung_gio_hang.controller;

import com.codegym.ung_dung_gio_hang.entity.Cart;
import com.codegym.ung_dung_gio_hang.entity.Product;
import com.codegym.ung_dung_gio_hang.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/view/details")
    public String viewDetails(@RequestParam("id") Integer id, Model model) {
        Optional<Product> productOptional = productService.findById(id.longValue());
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        model.addAttribute("product", productOptional.get());
        return "shop/detail";

    }

    @GetMapping("/view/details/add")
    public String viewDetails(@RequestParam("id") Integer id,
                              @RequestParam("quantity") Integer quantity,
                              Model model, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id.longValue());
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.addProduct(productOptional.get(), quantity);
        model.addAttribute("product", productOptional.get());
        return "redirect:/shopping-cart";

    }

    @GetMapping("cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProductCompletely(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("cart/update/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @RequestParam Integer qty,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cart.updateQuantity(productOptional.get(),qty);
        return "redirect:/shopping-cart";
    }
}