package com.example.demospring.springdatajpahomework.service;

import com.example.demospring.springdatajpahomework.model.Product;
import com.example.demospring.springdatajpahomework.model.request.ProductRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct(int pageNo, int pageSize, String sortBy, Sort.Direction orderBy);

    Product getByIdProduct(Integer id);

    Product createProduct(ProductRequest productRequest);

    Product updateProduct(ProductRequest productRequest, Integer id);

    Product deleteProduct(Integer id);
}
