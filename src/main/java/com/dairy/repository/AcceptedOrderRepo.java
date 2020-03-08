package com.dairy.repository;

import com.dairy.model.AcceptedOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcceptedOrderRepo extends MongoRepository<AcceptedOrder, Long> {

    AcceptedOrder findByOrderId(String  id);

}
