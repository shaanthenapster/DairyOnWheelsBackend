package com.dairy.api;

import com.dairy.RequestDto.MobileOtpDto;
import com.dairy.enums.SuccessCodes;
import com.dairy.exception.CustomException;
import com.dairy.exception.UserException;
import com.dairy.model.Validator;
import com.dairy.responseDto.ErrorResponseDto;
import com.dairy.responseDto.SuccessResponseDto;
import com.dairy.service.RegistrationLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.regex.Pattern;

@RestController
public class RegisterationController {


    @Autowired
    RegistrationLoginService registrationLoginService;


    @PostMapping(value = "/getOtp")
    public ResponseEntity<?> registerStepOne(@RequestBody MobileOtpDto otpDto) throws UserException, IOException {


        if (otpDto.getIpAddress().isEmpty() || otpDto.getMobileNo().isEmpty())
            throw new UserException("Required Fields Missing", CustomException.REQUIRED_FIELD_MISSING);


        SuccessResponseDto sdto = new SuccessResponseDto();
       /* if (Validator.isValidIP(otpDto.getIpAddress()) || Validator.isValidPhoneNumber(otpDto.getMobileNo()))
            throw new UserException("Invalid Parameters", CustomException.INVALID_PARAMETERS);
*/
        registrationLoginService.registerationByMobileNumber(otpDto);
        sdto.getMsg().add("OTP is send on your Phone Number");
        sdto.setSuccessCode(SuccessCodes.OTP_SEND_ON_PHONE);
        return ResponseEntity.ok().body(sdto);



    }
}

