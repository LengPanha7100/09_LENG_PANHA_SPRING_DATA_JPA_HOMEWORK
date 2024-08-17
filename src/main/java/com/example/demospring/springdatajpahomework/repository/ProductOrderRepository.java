package com.example.demospring.springdatajpahomework.repository;

import com.example.demospring.springdatajpahomework.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}