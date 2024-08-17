package com.example.demospring.springdatajpahomework.controller;
import com.example.demospring.springdatajpahomework.model.APIResponse;
import com.example.demospring.springdatajpahomework.model.ProductOrder;
import com.example.demospring.springdatajpahomework.model.request.ProductOrderRequest;
import com.example.demospring.springdatajpahomework.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<APIResponse<ProductOrder>> createProductOrder (@PathVariable Integer customerId, @RequestBody ProductOrderRequest productOrderRequest){
        APIResponse<ProductOrder> apiResponse = APIResponse.<ProductOrder>builder()
                .status(HttpStatus.CREATED)
                .message("ProductOrder is created successfully!")
                .payload(orderService.createProductOrder(customerId,productOrderRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
