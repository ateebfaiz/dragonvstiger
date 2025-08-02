package com.sensorsdata.analytics.android.sdk.encrypt.utils;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SymmetricEncryptMode;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import xc.a;

public class EncryptUtils {
    private static final String TAG = "SensorsDataEncrypt";

    public static String encryptAESKey(String str, byte[] bArr, String str2) {
        return publicKeyEncrypt(str, str2, bArr);
    }

    public static byte[] generateSymmetricKey(SymmetricEncryptMode symmetricEncryptMode) throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance(symmetricEncryptMode.algorithm);
        instance.init(128);
        return instance.generateKey().getEncoded();
    }

    public static boolean isECEncrypt() {
        try {
            a aVar = bd.a.f32b;
            return true;
        } catch (Exception unused) {
            SALog.i("SA.Encrypt", "No integrated ECC encryption library");
            return false;
        }
    }

    private static String publicKeyEncrypt(String str, String str2, byte[] bArr) {
        Cipher cipher;
        byte[] bArr2;
        if (TextUtils.isEmpty(str)) {
            SALog.i(TAG, "PublicKey is null.");
            return null;
        }
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Coder.decode(str));
            if ("EC".equals(str2)) {
                cipher = Cipher.getInstance("ECIES", "SC");
                cipher.init(1, (ECPublicKey) KeyFactory.getInstance("EC", "SC").generatePublic(x509EncodedKeySpec));
            } else {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
                cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
                cipher.init(1, generatePublic);
            }
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i10 = 0;
            while (true) {
                int i11 = length - i10;
                if (i11 > 0) {
                    if (i11 > 245) {
                        bArr2 = cipher.doFinal(bArr, i10, 245);
                    } else {
                        bArr2 = cipher.doFinal(bArr, i10, i11);
                    }
                    byteArrayOutputStream.write(bArr2, 0, bArr2.length);
                    i10 += 245;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return new String(Base64Coder.encode(byteArray));
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public static String symmetricEncrypt(byte[] bArr, byte[] bArr2, SymmetricEncryptMode symmetricEncryptMode) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                byte[] bArr3 = new byte[16];
                new SecureRandom().nextBytes(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, symmetricEncryptMode.algorithm);
                Cipher instance = Cipher.getInstance(symmetricEncryptMode.transformation);
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                byte[] doFinal = instance.doFinal(bArr2);
                ByteBuffer allocate = ByteBuffer.allocate(16 + doFinal.length);
                allocate.put(bArr3);
                allocate.put(doFinal);
                return new String(Base64Coder.encode(allocate.array()));
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
        return null;
    }
}
