package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductAvailability {

    AVAILABILE(0), OUT_OF_STOCK(1);

    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (ProductAvailability tbRange : ProductAvailability.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static ProductAvailability valueOf(int i) {
        return (ProductAvailability) map.get(i);
    }

    private ProductAvailability(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }

}
