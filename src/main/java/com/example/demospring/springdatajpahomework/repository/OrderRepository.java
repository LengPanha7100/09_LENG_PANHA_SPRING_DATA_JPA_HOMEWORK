package com.example.demospring.springdatajpahomework.repository;

import com.example.demospring.springdatajpahomework.model.Customer;
import com.example.demospring.springdatajpahomework.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAllByCustomer (Customer customerId);
}
