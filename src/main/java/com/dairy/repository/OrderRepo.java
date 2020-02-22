package com.dairy.repository;

import com.dairy.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order , Long> {
}
