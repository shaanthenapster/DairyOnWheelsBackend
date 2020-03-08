package com.dairy.model;

import com.dairy.enums.PaymentMode;
import com.dairy.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Setter
@Getter
public class Payment{

    private String id;

    @Indexed
    private String orderId;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

}
