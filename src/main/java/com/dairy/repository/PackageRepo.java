package com.dairy.repository;

import com.dairy.model.Packages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepo extends MongoRepository<Packages , Long> {
}
