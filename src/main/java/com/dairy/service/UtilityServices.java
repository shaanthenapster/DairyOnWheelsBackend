package com.dairy.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class UtilityServices {

    public static String productIdgenerator(int idRequestSource) {
        String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom secureRnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(14);
        for (int i = 0; i < 14; i++)
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        if (idRequestSource == 0)
            return "DAIRY-" + sb.toString();
        else
            return new ObjectId().toString();
    }
}
