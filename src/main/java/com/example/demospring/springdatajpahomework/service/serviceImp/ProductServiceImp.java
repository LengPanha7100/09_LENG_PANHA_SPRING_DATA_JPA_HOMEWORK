package com.example.demospring.springdatajpahomework.service.serviceImp;

import com.example.demospring.springdatajpahomework.exception.CustomNotfoundException;
import com.example.demospring.springdatajpahomework.model.Product;
import com.example.demospring.springdatajpahomework.model.request.ProductRequest;
import com.example.demospring.springdatajpahomework.repository.ProductRepository;
import com.example.demospring.springdatajpahomework.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct(int pageNo, int pageSize, String sortBy, Sort.Direction orderBy) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orderBy,sortBy));
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();
    }

    @Override
    public Product getByIdProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not Found")
        );
        return product;
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity());
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, Integer id) {
        return productRepository.save(productRequest.toEntity(id));
//        return null;
    }

    @Override
    public Product deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new CustomNotfoundException("Not Found!")
        );
        productRepository.deleteById(id);
        return product;
    }

}
