package com.dairy.enums;

import java.util.HashMap;
import java.util.Map;

public enum BrandCategory {
    
    IN_HOUSE(0) , AMUL(1) , SUDHA(2) , RAAJ(3) , MOTHER_DAIRY(4) , OTHERS(5);

    private static Map<Integer, Object> map = new HashMap<>();
    private Integer status;
    static {
        for (BrandCategory tbRange : BrandCategory.values()) {
            map.put(tbRange.status, tbRange);
        }
    }
    public static BrandCategory valueOf(int i) {
        return (BrandCategory) map.get(i);
    }

    private BrandCategory(Integer k) {
        this.status = k;
    }

    public Integer getStatus() {
        return status;
    }
}
