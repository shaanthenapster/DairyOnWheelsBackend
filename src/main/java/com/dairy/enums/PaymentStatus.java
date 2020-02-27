package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentStatus {
    
    PENDING(0) , SUCCESSFUL(1) , DECLINED(2) , TIME_OUT(3) , REFUNDED(4);


    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (PaymentStatus tbRange : PaymentStatus.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static PaymentStatus valueOf(int i) {
        return (PaymentStatus) map.get(i);
    }

    private PaymentStatus(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
}
