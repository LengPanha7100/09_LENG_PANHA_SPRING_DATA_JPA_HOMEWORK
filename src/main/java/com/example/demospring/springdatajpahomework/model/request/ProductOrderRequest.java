package com.example.demospring.springdatajpahomework.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderRequest {
    private Integer quantity;
    private Integer productId;
}
