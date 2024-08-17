package com.example.demospring.springdatajpahomework.controller;

import com.example.demospring.springdatajpahomework.model.APIResponse;
import com.example.demospring.springdatajpahomework.model.Customer;
import com.example.demospring.springdatajpahomework.model.request.CustomerRequest;
import com.example.demospring.springdatajpahomework.service.CustomerService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<APIResponse<Customer>> createCustomer (@RequestBody CustomerRequest customerRequest){
        APIResponse<Customer> apiResponse = APIResponse.<Customer>builder()
                .status(HttpStatus.CREATED)
                .message("Customer is created successfully!")
                .payload(customerService.createCustomer(customerRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Customer>>> getAllCustomer (@Positive @RequestParam(defaultValue = "1") int pageNo , @RequestParam(defaultValue = "10") int pageSize , @RequestParam(defaultValue = "cusId") String sortBy , @RequestParam Sort.Direction orderBy){
        APIResponse<List<Customer>> apiResponse = APIResponse.<List<Customer>>builder()
                .status(HttpStatus.OK)
                .message("Customer is get all successfully!")
                .payload(customerService.getAllCustomer(pageNo,pageSize,sortBy,orderBy))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Customer>> getByIdCustomer (@PathVariable Integer id){
        APIResponse<Customer> apiResponse = APIResponse.<Customer>builder()
                .status(HttpStatus.OK)
                .message("Customer by id is successfully!")
                .payload(customerService.getByIdCustomer(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Customer>> updateCustomer (@PathVariable Integer id,@RequestBody CustomerRequest customerRequest){
        APIResponse<Customer> apiResponse = APIResponse.<Customer>builder()
                .status(HttpStatus.OK)
                .message("Customer is updated successfully!")
                .payload(customerService.updateCustomer(customerRequest,id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Customer>> deleteCustomer (@PathVariable Integer id ){
        APIResponse<Customer> apiResponse = APIResponse.<Customer>builder()
                .status(HttpStatus.OK)
                .message("Customer is deleted successfully!")
                .payload(customerService.deleteCustomer(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
