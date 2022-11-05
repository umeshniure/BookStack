package com.secure;

import java.util.Base64;

public class Decrypt {

    public String decrypt(String password) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedpassword = decoder.decode(password);
        return new String(decodedpassword);
    }
}
