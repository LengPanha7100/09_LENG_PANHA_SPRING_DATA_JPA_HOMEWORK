package com.example.demospring.springdatajpahomework.service;

import com.example.demospring.springdatajpahomework.model.ProductOrder;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;

public interface OrderService {
    ProductOrder createProductOrder(Integer customerId, ProductOrderRequest productOrderRequest);
}
