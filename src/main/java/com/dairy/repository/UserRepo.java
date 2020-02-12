package com.dairy.repository;

import com.dairy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User , Long> {

    User findByContact(String mobileno);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);


}
