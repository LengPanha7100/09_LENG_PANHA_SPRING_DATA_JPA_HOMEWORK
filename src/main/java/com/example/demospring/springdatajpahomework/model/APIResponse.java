package com.example.demospring.springdatajpahomework.model;

import lombok.*;
import org.springframework.http.HttpStatus;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse <T> {
    private HttpStatus status;
    private String message;
    private T payload;
}
