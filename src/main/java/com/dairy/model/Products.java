package com.dairy.model;


import com.dairy.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date createdAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Kolkata")
    private Date modifiedAt;

}
