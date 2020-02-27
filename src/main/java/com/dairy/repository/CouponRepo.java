package com.dairy.repository;

import com.dairy.model.Coupons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepo extends MongoRepository<Coupons , Long> {

    Coupons findByCouponCode(String coupon);


}
