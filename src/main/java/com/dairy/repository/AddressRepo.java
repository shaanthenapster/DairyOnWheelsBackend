package com.dairy.repository;

import com.dairy.model.DeliveryAddress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepo extends MongoRepository<DeliveryAddress , Long> {

}
