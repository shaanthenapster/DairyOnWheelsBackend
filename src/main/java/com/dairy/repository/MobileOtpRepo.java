package com.dairy.repository;

import com.dairy.model.MobileOtp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MobileOtpRepo extends MongoRepository<MobileOtp , Long> {


}
