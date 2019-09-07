package com.senerutaxi.service;

import com.senerutaxi.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
