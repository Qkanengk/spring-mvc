package com.codegym.ung_dung_muon_sach.controller;

import com.codegym.ung_dung_muon_sach.service.IRentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("tickets")
public class RentController {
    private final IRentService rentService;

    public RentController(IRentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/rent")
    public String rent(@RequestParam("id") Integer bookId) throws Exception {
        if(rentService.rent(bookId)){
            System.out.printf("ok");
        }
        return "redirect:/books";
    }
    @GetMapping("/return")
    public String returnBook(@RequestParam("code") String code ){
        if (rentService.returnBook(code)){
            return "redirect:/books";
        }
        return  "redirect:/rent";
    }
    @GetMapping("")
    public String findAll(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("tickets",rentService.findAll(pageable,false));
        return "tickets/list";
    }
}
