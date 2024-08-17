package com.example.demospring.springdatajpahomework.repository;

import com.example.demospring.springdatajpahomework.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder,Integer> {
}
