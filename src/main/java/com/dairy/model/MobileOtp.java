package com.dairy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileOtp {


        @Id
        private int id;

        private String mobileNumber;
        private String Otp;
        private String ipAddress;

    }

