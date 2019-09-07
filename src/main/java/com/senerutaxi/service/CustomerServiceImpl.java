package com.senerutaxi.service;

import com.senerutaxi.model.Customer;
import com.senerutaxi.repository.CustomerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerDAO.save(customer);
    }
}
