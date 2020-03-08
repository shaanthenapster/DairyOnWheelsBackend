package com.dairy.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class UtilityServices {

    public static String genricIdgenerator(int idRequestSource) {
        String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom secureRnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(14);
        for (int i = 0; i < 14; i++)
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        /*Request 0 for Dairy Unique Product Id*/
        if (idRequestSource == 0)
            return "DAIRY-" + sb.toString();
        if( idRequestSource == 1)
            return "PENDING-ORDER-" + sb.toString();
        else
            return new ObjectId().toString();
    }
}
