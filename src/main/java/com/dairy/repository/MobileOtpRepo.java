package com.dairy.repository;

import com.dairy.model.MobileOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileOtpRepo extends JpaRepository<MobileOtp , Long> {


}
