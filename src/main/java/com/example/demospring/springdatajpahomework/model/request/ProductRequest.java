package com.example.demospring.springdatajpahomework.model.request;

import com.example.demospring.springdatajpahomework.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;
    private float unitPrice;
    private String description;

    public Product toEntity(){
        return new Product(null,this.productName,this.unitPrice,this.description,null);
    }
    public Product toEntity(Integer id){
        return new Product(id,this.productName,this.unitPrice,this.description,null);
    }
}
