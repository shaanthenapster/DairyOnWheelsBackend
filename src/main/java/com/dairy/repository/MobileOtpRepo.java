package com.dairy.repository;

import com.dairy.model.MobileOtp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileOtpRepo extends MongoRepository<MobileOtp , Long> {


}
