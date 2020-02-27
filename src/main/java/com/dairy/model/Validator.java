package com.dairy.model;

import com.dairy.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Validator {

    static UserRepo userRepo;

    public static boolean isValidPhoneNumber(String phonenumber) {
        String PhoneNumber = "^[0-9][0-9]{7,13}$";
        Pattern ptn = Pattern.compile(PhoneNumber);
        if (phonenumber == null)
            return false;
        return ptn.matcher(phonenumber).matches();
    }
    public static boolean isValidIP(String ipaddress) {
        String IpAddress = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern ptn = Pattern.compile(IpAddress);
        if (ipaddress == null)
            return false;
        return ptn.matcher(ipaddress).matches();
    }


    public static String isvalidUserId(String uuid){
        User user = userRepo.findByUuid(uuid);
        if(user == null)
            return null;
        return user.getUuid();
    }
}
