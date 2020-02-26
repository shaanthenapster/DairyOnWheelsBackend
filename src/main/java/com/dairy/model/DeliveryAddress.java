package com.dairy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Document
@Setter
@Getter
public class DeliveryAddress {


    private String id;

    private String houseNo;

    private String street;

    private String landmark;

    private String city;

    private String state;

    private String pinCode;

    private String latitude;

    private String longitude;

    @DBRef
    private User user;
}
