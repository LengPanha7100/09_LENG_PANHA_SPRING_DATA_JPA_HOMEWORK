package com.example.demospring.springdatajpahomework.model.request;

import com.example.demospring.springdatajpahomework.model.Customer;
import com.example.demospring.springdatajpahomework.model.Email;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String customerName;
    private String address;
    private String phoneNumber;
    private String email;


    public Customer toEntity(){
        Email email1 = new Email(null,this.email,null);
        return new Customer(null,this.customerName,this.address,this.phoneNumber,email1,null);
    }

    public Customer toEntity(Integer id,Integer eId){
        Email email1 = new Email(eId,this.email,null);
        return new Customer(id,this.customerName,this.address,this.phoneNumber,email1,null);
    }


}
