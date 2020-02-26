package com.dairy.repository;

import com.dairy.model.Images;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Images , Long> {

    Images findById(String id);

    void deleteById(String id);
}
