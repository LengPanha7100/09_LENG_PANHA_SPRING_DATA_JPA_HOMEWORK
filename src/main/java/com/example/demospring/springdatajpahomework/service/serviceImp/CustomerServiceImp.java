package com.example.demospring.springdatajpahomework.service.serviceImp;

import com.example.demospring.springdatajpahomework.exception.CustomNotfoundException;
import com.example.demospring.springdatajpahomework.model.Customer;
import com.example.demospring.springdatajpahomework.model.request.CustomerRequest;
import com.example.demospring.springdatajpahomework.repository.CustomerRepository;
import com.example.demospring.springdatajpahomework.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerRequest.toEntity());
    }

    @Override
    public List<Customer> getAllCustomer(int pageNo, int pageSize, String sortBy, Sort.Direction orderBy) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orderBy,sortBy));
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.getContent();
    }

    @Override
    public Customer getByIdCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not found!")
        );
        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerRequest customerRequest, Integer id) {
        Customer customer =getByIdCustomer(id);
        return customerRepository.save(customerRequest.toEntity(id,customer.getEmail().getId()));
    }

    @Override
    public Customer deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        customerRepository.deleteById(id);
//        return customer;
        return null;
    }
}
