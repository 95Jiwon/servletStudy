package com.korai.servletstudy02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor

public class Menu {
    private int menuId;
    private int restaurantId;
    private String name;
    private int price;
    private String description;
    private boolean isSignature;
    private boolean isSoldOut;

    public Menu(Map<String, Object> map){

    }

    public Menu(Object menuId, Object restaurantId, Object name, Object price, Object description, Object isSignature, Object isSoldOut) {
        this.menuId = (int) menuId;
        this.restaurantId = (int) restaurantId;
        this.name = (String) name;
        this.price = (int) price;
        this.description = (String) description;
        this.isSignature = (boolean) isSignature;
        this.isSoldOut = (boolean) isSoldOut;
    }
}
