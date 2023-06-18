package com.example.database.service;

import com.example.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Object[]> getAllCustomers() { return customerRepository.getAllCustomers(); }

    public List<Object[]> getCustomerByName(String customerName) { return customerRepository.getCustomerByName(customerName); }
}
