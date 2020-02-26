package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductType {

    RAW_MILK(0) , PASTEURIZED_MILK(1) , GHEE(2) , CURD(3) , YOGURT(4) , ICE_CREAM(5) , PANEER(6) , CHEESEE(7);

    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (ProductType tbRange : ProductType.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static ProductType valueOf(int i) {
        return (ProductType) map.get(i);
    }

    private ProductType(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
}
