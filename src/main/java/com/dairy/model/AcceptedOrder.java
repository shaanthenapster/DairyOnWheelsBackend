package com.dairy.model;

import com.dairy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Setter
@Getter
public class AcceptedOrder {


    private String id;

    @Indexed
    private String orderId;

    @Indexed
    private String userId;

    private DeliveryAddress deliveryAddress;

    private OrderStatus orderStatus;

    private int orderQuantity;

    private double totalPrice;

    private boolean isCouponApplied;

    private Coupons couponCode;

    private double orderRating;

    private Payment payment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date orderDate;

}
