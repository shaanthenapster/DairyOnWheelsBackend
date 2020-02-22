package com.dairy.model;


import com.dairy.enums.ProductAvailability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Packages {

    private String id;

    private String packageId;

    private String packageTitle;

    private String packageDescription;

    private double packagePrice;

    private double packageDiscount;

    private ProductAvailability packageAvailability;

    private List<Products> products = new ArrayList<>();

}
