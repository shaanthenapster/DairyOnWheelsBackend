package com.dairy.RequestDto;

import com.dairy.enums.ProductCategory;
import com.dairy.enums.ProductType;
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

    private String productImage;

    private ProductCategory productCategory;

    private ProductType productType;

    private double productPrice;

    private double productRating;

    private double discount;

    private double InventoryCount;

}
