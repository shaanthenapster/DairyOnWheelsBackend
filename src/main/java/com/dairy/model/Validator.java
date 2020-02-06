package com.dairy.model;

import java.util.regex.Pattern;

public class Validator {

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
}
