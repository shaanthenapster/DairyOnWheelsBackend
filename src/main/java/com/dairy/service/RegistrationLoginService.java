package com.dairy.service;

import com.dairy.requestDto.MobileOtpDto;
import com.dairy.repository.MobileOtpRepo;
import com.dairy.exception.CustomException;
import com.dairy.exception.UserException;
import com.dairy.model.MobileOtp;
import com.dairy.model.User;
import com.dairy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class RegistrationLoginService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    MobileOtpRepo mobileOtpRepo;


    @Transactional(propagation = Propagation.MANDATORY , readOnly = true , isolation = Isolation.SERIALIZABLE)
    public void registerationByMobileNumber(MobileOtpDto mobileOtpDto) throws UserException, IOException {

        User user = userRepo.findByContact(mobileOtpDto.getMobileNo());

        if(user != null)
            throw new UserException("User Already Exists" , CustomException.USER_ALREADY_EXISTS);
        String otp = "" + ((int) (Math.random() * 900000) + 100000);
        String apiKey = "28fENBSODEmKvXt4BYld3g";
        String senderId = "TESTIN";
        String channel = "2";
        String DCS = "0";
        String flashsms = "0";
        String mobile = mobileOtpDto.getMobileNo();
        String message = "Your OTP for Dairy App is : " + otp;
        String route = "1";
        String requestUrl = "";
        requestUrl = "https://www.smsgatewayhub.com/api/mt/SendSMS?" + "APIKey=" + URLEncoder.encode(apiKey, "UTF-8")
            + "&senderid=" + URLEncoder.encode(senderId, "UTF-8") + "&channel="
            + URLEncoder.encode(channel, "UTF-8") + "&DCS=" + URLEncoder.encode(DCS, "UTF-8") + "&flashsms="
            + URLEncoder.encode(flashsms, "UTF-8") + "&number=" + URLEncoder.encode(mobile, "UTF-8") + "&text="
            + URLEncoder.encode(message, "UTF-8") + "&route=" + URLEncoder.encode(route, "UTF-8");
        URL url = new URL(requestUrl);
        System.out.println("url is ================> " + url);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        System.out.println("Response message: " + uc.getResponseMessage() + uc.getResponseCode());
        uc.disconnect();
        MobileOtp mobileotp = new MobileOtp();
        mobileotp.setMobileNumber(mobileOtpDto.getMobileNo());
        mobileotp.setIpAddress(mobileOtpDto.getIpAddress());
        mobileotp.setOtp(otp);
        mobileOtpRepo.save(mobileotp);


    }
}
