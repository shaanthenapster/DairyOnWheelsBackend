package com.dairy.model;


import com.dairy.enums.ProductAvailability;
import com.dairy.enums.ProductCategory;
import com.dairy.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {


    @Id
    private String id;

    @Indexed
    private String productId;

    private String productName;

    private String productImage;

    private ProductCategory productCategory;

    private ProductType productType;

    private ProductAvailability productAvailability;

    private double productPrice;

    private double productRating;

    private double discount;

    private double InventoryCount; // number of products avaliable in stock of the same category.
}
