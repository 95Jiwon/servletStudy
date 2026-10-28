package com.korai.servletstudy02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String carModel;
    private String carColor;
    private int carPrice;

    public Car(Car other){
        this.id = other.id;
        this.carModel = other.carModel;
        this.carColor = other.carColor;
        this.carPrice = other.carPrice;
    }
}
