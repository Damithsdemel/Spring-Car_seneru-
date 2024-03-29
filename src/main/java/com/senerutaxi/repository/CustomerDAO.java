package com.senerutaxi.repository;

import com.senerutaxi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findById(Long id);
}
