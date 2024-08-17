package com.example.demospring.springdatajpahomework.service;

import com.example.demospring.springdatajpahomework.model.Order;
import com.example.demospring.springdatajpahomework.model.StatusEnum;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;

import java.util.List;

public interface OrderService {
    Order createProductOrder(Integer customerId, List<ProductOrderRequest> productOrderRequest);

    Order getByOrderId(Integer orderId);

    Order getByCustomerId(Integer customerId);

    Order updateStatue(StatusEnum statusEnum, Integer orderId);
}
