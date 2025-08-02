package com.botion.captcha;

import java.security.MessageDigest;

public final class j {
    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return k.a(instance.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
