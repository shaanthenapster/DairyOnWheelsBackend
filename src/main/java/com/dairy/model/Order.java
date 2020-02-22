package com.dairy.model;

import com.dairy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Setter
@Getter
public class Order {

    @Id
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date orderDate;

}
