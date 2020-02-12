package com.dairy.model;


import com.dairy.enums.AuthProvider;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Indexed
    private String  id;

    @Indexed
    private String uuid;

    private String userName;

    private String fName;

    private String lName;

    private String contact;

    private String email;

    private String sex;

    private String imageUrl;

    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    private AuthProvider provider;

    private String providerId;

    private List<DeliveryAddress> address = new ArrayList<>();


    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date lastLogin;


    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date createdAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date modifiedAt;


}

