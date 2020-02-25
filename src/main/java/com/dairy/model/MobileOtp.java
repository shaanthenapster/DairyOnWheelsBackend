package com.dairy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
@Document
public class MobileOtp {

        private int id;

        private String mobileNumber;
        private String Otp;
        private String ipAddress;

    }

