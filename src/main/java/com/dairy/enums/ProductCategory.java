package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum  ProductCategory {

    DAIRY(0) , VEGETABLES(1) , WATER(2) ;

    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (ProductCategory tbRange : ProductCategory.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static ProductCategory valueOf(int i) {
        return (ProductCategory) map.get(i);
    }

    private ProductCategory(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
}
