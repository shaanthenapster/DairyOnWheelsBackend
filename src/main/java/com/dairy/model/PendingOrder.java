package com.dairy.model;

import com.dairy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PendingOrder {

    private String id;

    @Indexed
    private String uuid;

    private DeliveryAddress deliveryAddress;

    private OrderStatus orderStatus = OrderStatus.AWAITING_CONFIRMATION;

    private int orderQuantity;

    private double totalPrice;

    private String couponCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date orderDate;

    List<OrderProduct> productsList = new ArrayList<>();

}
