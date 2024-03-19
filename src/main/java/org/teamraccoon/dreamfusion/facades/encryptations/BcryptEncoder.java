package org.teamraccoon.dreamfusion.facades.encryptations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.teamraccoon.dreamfusion.generic.IEncoder;

public class BcryptEncoder implements IEncoder {

    BCryptPasswordEncoder encoder;

    public BcryptEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String data) {
        String dataEncode = encoder.encode(data);
        return dataEncode;
    }
}
