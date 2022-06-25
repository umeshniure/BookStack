package com.secure;

import java.util.Base64;
import java.util.Base64.Decoder;

public class Decrypt {

    public String decrypt(String password) {
        Decoder decoder = Base64.getDecoder();
        byte[] decodedpassword = decoder.decode(password);
        return new String(decodedpassword);
    }
}
