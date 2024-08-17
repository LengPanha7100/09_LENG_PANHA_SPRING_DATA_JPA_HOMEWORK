package com.example.demospring.springdatajpahomework.repository;

import com.example.demospring.springdatajpahomework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {



}
