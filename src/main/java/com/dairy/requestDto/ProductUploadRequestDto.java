package com.dairy.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUploadRequestDto {

    private String productName;

    private String productDescription;

    private String productImage; // URL SAVE

    private int productCategory;

    private int productType;

    private double productPrice;

    private double discount;

    private int inventoryCount;

    private int brandType;

    private int productSizeVariant;
}
