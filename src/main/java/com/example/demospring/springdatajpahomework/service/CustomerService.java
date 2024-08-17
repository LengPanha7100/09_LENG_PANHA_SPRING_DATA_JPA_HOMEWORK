package com.example.demospring.springdatajpahomework.service;

import com.example.demospring.springdatajpahomework.model.Customer;
import com.example.demospring.springdatajpahomework.model.request.CustomerRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CustomerRequest customerRequest);

    List<Customer> getAllCustomer(int pageNo, int pageSize, String sortBy, Sort.Direction orderBy);

    Customer getByIdCustomer(Integer id);

    Customer updateCustomer(CustomerRequest customerRequest, Integer id);

    Customer deleteCustomer(Integer id);
}
