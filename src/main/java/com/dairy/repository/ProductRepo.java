package com.dairy.repository;

import com.dairy.enums.BrandCategory;
import com.dairy.enums.ProductAvailability;
import com.dairy.enums.ProductType;
import com.dairy.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends MongoRepository<Products , Long> {

    Products findByProductId(String productId);

    @Override
    List<Products> findAll();

    @Override
    Products save(Products products);

    Optional<List<Products>> findByProductType(ProductType productType);

    void deleteByProductId(String id);

    List<Products> findByProductAvailability(ProductAvailability productAvailability);

    List<Products> findByBrandCategory(BrandCategory brandCategory);

}
