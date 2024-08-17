package com.example.demospring.springdatajpahomework.repository;

import com.example.demospring.springdatajpahomework.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
