package com.dairy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
@Setter
@Getter
public class MobileOtp {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int id;

        private String mobileNumber;
        private String Otp;
        private String ipAddress;

    }

