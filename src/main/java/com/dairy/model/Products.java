package com.dairy.model;


import com.dairy.enums.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Products {

    private String  id;

    @Indexed
    private String productId;

    private String productName;

    private String productDescription;

    private String productImage;

    private ProductCategory productCategory;

    private ProductType productType;

    private ProductAvailability productAvailability;

    private BrandCategory brandCategory;

    private double productPrice;

    private double productRating;

    private double discount;

    private ProductPackagingWeight productPackagingWeight;

    private int inventoryCount; // number of products available in stock of the same category.
}
