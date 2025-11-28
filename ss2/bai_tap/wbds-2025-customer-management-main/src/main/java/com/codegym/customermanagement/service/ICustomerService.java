package com.codegym.customermanagement.service;

import com.codegym.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
}
