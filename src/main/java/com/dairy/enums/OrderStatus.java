package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum  OrderStatus {

    RECEIVED(0) , PROCESSING_THE_REQUEST(1) , AWAITING_CONFIRMATION(2) , CONFIRMED(3),
    DISPATCHED(4) , DELIVERED(5) , RETURNED(6)  ,
    DECLINED(7);


    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (OrderStatus tbRange : OrderStatus.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static OrderStatus valueOf(int i) {
        return (OrderStatus) map.get(i);
    }

    private OrderStatus(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
    
    
    
    
    
}
