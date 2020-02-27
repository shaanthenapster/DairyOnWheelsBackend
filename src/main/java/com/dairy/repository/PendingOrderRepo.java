package com.dairy.repository;

import com.dairy.model.PendingOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PendingOrderRepo extends MongoRepository<PendingOrder , Long> {


}
