package com.example.demospring.springdatajpahomework.service.serviceImp;

import com.example.demospring.springdatajpahomework.exception.CustomNotfoundException;
import com.example.demospring.springdatajpahomework.model.*;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;
import com.example.demospring.springdatajpahomework.repository.CustomerRepository;
import com.example.demospring.springdatajpahomework.repository.OrderRepository;
import com.example.demospring.springdatajpahomework.repository.ProductRepository;
import com.example.demospring.springdatajpahomework.service.OrderService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Order createProductOrder(Integer customerId, List<ProductOrderRequest> productOrderRequest) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        System.out.println(customer);
        float totalAmount = 0 ;
        List<ProductOrder> productOrders = new ArrayList<>();
        for (ProductOrderRequest pr : productOrderRequest){
            Product product = productRepository.findById(pr.getProductId()).orElseThrow(
                    () -> new CustomNotfoundException("Not Found!")
            );
            totalAmount += product.getUnitPrice() * pr.getQuantity();
            ProductOrder productOrder = new ProductOrder();
            productOrder.setQuantity(pr.getQuantity());
            productOrder.setProduct(product);
            productOrders.add(productOrder);
        }
        Order order = new Order();
        order.setOrderDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setTotalAmount(totalAmount);
        order.setStatusEnum(StatusEnum.PENDING);
        order.setCustomer(customer);
        order.setProductOrders(productOrders);

        for(ProductOrder pr : productOrders){
            pr.setOrder(order);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order getByOrderId(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        return order;
    }

    @Override
    public List<Order> getByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        return orderRepository.findAllByCustomer(customer);
    }

    @Override
    public Order updateStatue(StatusEnum statusEnum, Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        order.setStatusEnum(statusEnum);
        return orderRepository.save(order);
    }
}
