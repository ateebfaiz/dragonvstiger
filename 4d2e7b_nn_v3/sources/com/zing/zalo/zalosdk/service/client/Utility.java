package com.zing.zalo.zalosdk.service.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Utility {
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";

    Utility() {
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : digest) {
            sb2.append(Integer.toHexString((b10 >> 4) & 15));
            sb2.append(Integer.toHexString(b10 & 15));
        }
        return sb2.toString();
    }

    private static String hashWithAlgorithm(String str, String str2) {
        return hashWithAlgorithm(str, str2.getBytes());
    }

    static String sha1hash(byte[] bArr) {
        return hashWithAlgorithm("SHA-1", bArr);
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            return hashBytes(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
