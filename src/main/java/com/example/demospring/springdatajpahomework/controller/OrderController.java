package com.example.demospring.springdatajpahomework.controller;
import com.example.demospring.springdatajpahomework.model.APIResponse;
import com.example.demospring.springdatajpahomework.model.Order;
import com.example.demospring.springdatajpahomework.model.ProductOrder;
import com.example.demospring.springdatajpahomework.model.StatusEnum;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;
import com.example.demospring.springdatajpahomework.service.OrderService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<APIResponse<Order>> createProductOrder (@PathVariable Integer customerId, @RequestBody List<ProductOrderRequest> productOrderRequest){
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .status(HttpStatus.CREATED)
                .message("ProductOrder is created successfully!")
                .payload(orderService.createProductOrder(customerId,productOrderRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<APIResponse<Order>> getByOrderId (@PathVariable Integer orderId){
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .status(HttpStatus.OK)
                .message("Get order id is successfully!")
                .payload(orderService.getByOrderId(orderId))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<APIResponse<List<Order>>> getByCustomerId (@PathVariable Integer customerId){
        APIResponse<List<Order>> apiResponse = APIResponse.<List<Order>>builder()
                .status(HttpStatus.OK)
                .message("Get customer id is successfully!")
                .payload(orderService.getByCustomerId(customerId))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<APIResponse<Order>> updateStatue (@RequestParam StatusEnum statusEnum, @PathVariable Integer orderId){
        APIResponse<Order> apiResponse = APIResponse.<Order>builder()
                .status(HttpStatus.OK)
                .message("Status is updated successfully!")
                .payload(orderService.updateStatue(statusEnum,orderId))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
