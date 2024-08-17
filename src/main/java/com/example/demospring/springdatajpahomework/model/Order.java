package com.example.demospring.springdatajpahomework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "homework")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Date orderDate;
    private float totalAmount;
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_Id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;
}
