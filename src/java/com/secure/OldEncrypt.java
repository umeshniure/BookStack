package com.secure;

import java.util.Base64;

public class OldEncrypt {

    public static String encryptPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedpassword = encoder.encodeToString(password.getBytes());
        return encryptedpassword;
    }
}
