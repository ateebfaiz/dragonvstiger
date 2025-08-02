package com.zing.zalo.zalosdk.core.servicemap;

import com.alibaba.pdns.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class ServiceMapTools {
    private static String AES_KEY = "zalo@123";
    private static String USER_NAME = "ZALO";

    ServiceMapTools() {
    }

    private static byte[] decompress(byte[] bArr) throws IOException {
        return zipInputToByteArrayOutputStream(new GZIPInputStream(new ByteArrayInputStream(bArr))).toByteArray();
    }

    private static byte[] decryptPass(String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IllegalArgumentException {
        String str4 = str3 + str2;
        MessageDigest instance = MessageDigest.getInstance(j.f17955b);
        instance.update(str4.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(instance.digest(), "AES");
        byte[] hexToByte = hexToByte(str);
        Cipher instance2 = Cipher.getInstance("AES/ECB/NoPadding");
        instance2.init(2, secretKeySpec);
        return instance2.doFinal(hexToByte);
    }

    static String decryptString(String str) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return new String(decompress(decryptPass(str, USER_NAME, AES_KEY)));
    }

    private static byte[] hexToByte(String str) throws IllegalArgumentException {
        if (str == null || str.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid hex string :" + str);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 2;
            byteArrayOutputStream.write((byte) Integer.parseInt(str.substring(i10, i11), 16));
            i10 = i11;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static ByteArrayOutputStream zipInputToByteArrayOutputStream(GZIPInputStream gZIPInputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream;
            }
        }
    }
}
