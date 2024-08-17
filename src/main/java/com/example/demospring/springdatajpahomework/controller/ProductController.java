package com.example.demospring.springdatajpahomework.controller;

import com.example.demospring.springdatajpahomework.model.APIResponse;
import com.example.demospring.springdatajpahomework.model.Product;
import com.example.demospring.springdatajpahomework.model.request.ProductRequest;
import com.example.demospring.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Product>>> getAllProduct (@RequestParam(defaultValue = "1") int pageNo , @RequestParam(defaultValue = "10") int pageSize , @RequestParam(defaultValue = "proId") String sortBy, @RequestParam Sort.Direction orderBy){
        APIResponse<List<Product>> apiResponse = APIResponse.<List<Product>>builder()
                .status(HttpStatus.OK)
                .message("Product is get all successfully!")
                .payload(productService.getAllProduct(pageNo,pageSize,sortBy,orderBy))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Product>> getByIdProduct (@RequestParam Integer id){
        APIResponse<Product> apiResponse = APIResponse.<Product>builder()
                .status(HttpStatus.OK)
                .message("Product get by id is successfully!")
                .payload(productService.getByIdProduct(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Product>> createProduct (@RequestBody ProductRequest productRequest){
        APIResponse<Product> apiResponse = APIResponse.<Product>builder()
                .status(HttpStatus.OK)
                .message("Product is created successfully!")
                .payload(productService.createProduct(productRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Product>> updateProduct(@RequestBody ProductRequest productRequest , @PathVariable Integer id){
        APIResponse<Product> apiResponse = APIResponse.<Product>builder()
                .status(HttpStatus.OK)
                .message("Product is updated successfully!")
                .payload(productService.updateProduct(productRequest,id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Product>> deleteProduct(@PathVariable Integer id){
        APIResponse<Product> apiResponse = APIResponse.<Product>builder()
                .status(HttpStatus.OK)
                .message("Product is deleted successfully!")
                .payload(productService.deleteProduct(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
