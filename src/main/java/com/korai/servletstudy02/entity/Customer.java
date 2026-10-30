package com.korai.servletstudy02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String email;
    private String birthDate;
    private String district;
    private String address;
    private String grade;
    private boolean marketingAgreed;
    private String joinedAt;
}
