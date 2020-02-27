package com.dairy.requestDto;

import com.dairy.model.DeliveryAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IncomingOrderRequestDto {

    private String uuid;

    private DeliveryAddress deliveryAddress;

    private int orderQuantity;

    private double totalPrice;

    private String couponCode;

}
