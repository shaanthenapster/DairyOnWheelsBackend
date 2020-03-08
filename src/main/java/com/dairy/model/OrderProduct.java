package com.dairy.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderProduct {

    private String productId;

    private String productName;

    private double productPrice;

    int quantity = 1 ;
}
