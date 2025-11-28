package com.codegym.customermanagement.repository;

import com.codegym.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
}
