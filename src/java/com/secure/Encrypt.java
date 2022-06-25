package com.secure;

import java.util.Base64;

public class Encrypt {

    public String encryptPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedpassword = encoder.encodeToString(password.getBytes());
        return encryptedpassword;
    }
}
