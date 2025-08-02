package com.alibaba.pdns;

import com.alibaba.pdns.u.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class p {
    public static String a(String str) {
        byte[] bArr;
        try {
            MessageDigest instance = MessageDigest.getInstance(j.f17956c);
            instance.update(str.getBytes());
            bArr = instance.digest();
        } catch (NoSuchAlgorithmException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            bArr = null;
            return a(bArr);
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            bArr = null;
            return a(bArr);
        }
        return a(bArr);
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str;
    }
}
