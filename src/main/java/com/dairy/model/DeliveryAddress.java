package com.dairy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress {

    @Id
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
