package com.dairy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class Coupons {

    private String id;

    private String couponCode;

    private String couponDescription;

    private boolean isPercentage = false;

    private double discount;

    private boolean isValid = true;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private LocalDateTime validDate;

}
