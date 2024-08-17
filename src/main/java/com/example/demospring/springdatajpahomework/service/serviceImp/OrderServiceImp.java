package com.example.demospring.springdatajpahomework.service.serviceImp;
import com.example.demospring.springdatajpahomework.exception.CustomNotfoundException;
import com.example.demospring.springdatajpahomework.model.ProductOrder;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;
import com.example.demospring.springdatajpahomework.repository.OrderRepository;
import com.example.demospring.springdatajpahomework.service.OrderService;
import com.example.demospring.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    @Override
    public ProductOrder createProductOrder(Integer customerId, ProductOrderRequest productOrderRequest) {
        ProductOrder productOrder = orderRepository.findById(customerId).orElseThrow(
                () -> new CustomNotfoundException("Not Found")
        );
        productOrder.setQuantity(productOrderRequest.getQuantity());
        return orderRepository.save(productOrder);
    }
}
