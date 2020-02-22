package com.dairy.model;


import com.dairy.enums.ProductAvailability;
import com.dairy.enums.ProductCategory;
import com.dairy.enums.ProductType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document
@Setter
@Getter
public class Products {

    @Id
    private int id;

    @Indexed
    private String productId;

    private String productName;

    private String productDescription;

    private String productImage;

    private ProductCategory productCategory;

    private ProductType productType;

    private ProductAvailability productAvailability;

    private double productPrice;

    private double productRating;

    private double discount;

    private double InventoryCount; // number of products available in stock of the same category.
}
