package com.dairy.model;

import com.dairy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Setter
@Getter
public class AcceptedOrder {

    private String id;

    @Indexed
    private String orderId;

    @Indexed
    private String uuid;

    private DeliveryAddress deliveryAddress;

    private OrderStatus orderStatus;

    private int orderQuantity;

    private double totalPrice;

    @Indexed
    private String couponCode;

    private double orderRating;

    private Payment payment;

    List<OrderProduct> productsList = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date orderDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date deliveryTimestamp;
}
