package com.codegym.customermanagement.controller;

import com.codegym.customermanagement.model.Customer;
import com.codegym.customermanagement.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller()
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam("id") int customerId) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findById(customerId);
        System.out.println(customer);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@RequestParam("id") int customerId,
                                       @RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("address") String address) {
        ModelAndView modelAndView = new ModelAndView();
        Customer customer = new Customer(customerId, name, email, address);
        customerService.save(customer);
        modelAndView.setViewName("redirect:/customers");
        return modelAndView;
    }


}