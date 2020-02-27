package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum  PaymentMode {
    
    DEBIT_CARD(0) , CREDIT_CARD(1) , UPI(2) , PAYTM(3) , CASH_ON_DELIVERY(4);


    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (PaymentMode tbRange : PaymentMode.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static PaymentMode valueOf(int i) {
        return (PaymentMode) map.get(i);
    }

    private PaymentMode(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
    
    
}
