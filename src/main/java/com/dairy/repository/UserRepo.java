package com.dairy.repository;

import com.dairy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User , Long> {

    User findByContact(String mobileno);

    User findByUuid(String uuid);

}
