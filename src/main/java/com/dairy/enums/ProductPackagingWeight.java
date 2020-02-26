package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductPackagingWeight {
    
    GMS_200(0) , GMS_250(1) , GMS_500(2) , KG_1(3) , KG_2(4) , KG_5(5);


    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (ProductPackagingWeight tbRange : ProductPackagingWeight.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static ProductPackagingWeight valueOf(int i) {
        return (ProductPackagingWeight) map.get(i);
    }

    private ProductPackagingWeight(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
    
}
