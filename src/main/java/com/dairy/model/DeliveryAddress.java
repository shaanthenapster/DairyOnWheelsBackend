package com.dairy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "address")
@Setter
@Getter
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String houseNo;

    private String street;

    private String landmark;

    private String city;

    private String state;

    private String pinCode;

    private String latitude;

    private String longitude;

    @ManyToOne
    private User user;
}
