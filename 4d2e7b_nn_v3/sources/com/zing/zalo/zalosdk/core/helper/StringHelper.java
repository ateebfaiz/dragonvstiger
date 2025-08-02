package com.zing.zalo.zalosdk.core.helper;

import com.alibaba.pdns.f;
import com.alibaba.pdns.j;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHelper {
    public static String formatPrice(long j10) {
        String valueOf = String.valueOf(j10);
        if (valueOf.length() <= 3) {
            return valueOf;
        }
        int length = valueOf.length();
        String substring = valueOf.substring(length - 3);
        int i10 = length - 6;
        while (i10 >= 0) {
            substring = valueOf.substring(i10, i10 + 3) + f.G + substring;
            i10 -= 3;
        }
        int i11 = i10 + 3;
        if (i11 <= 0) {
            return substring;
        }
        return valueOf.substring(0, i11) + f.G + substring;
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17955b);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
