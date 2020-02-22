package com.dairy.repository;

import com.dairy.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Products , Long> {
}
