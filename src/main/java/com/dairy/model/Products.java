package com.dairy.model;


import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productId;

    private String productName;

    private String productDescription;

    private String productImage;

    private ProductCategory productCategory;

    private ProductType productType;

    private ProductAvailability productAvalibility;

    private double productPrice;

    private double productRating;

    private double discount;

    private double InventoryCount; // number of products available in stock of the same category.
}
