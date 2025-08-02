package com.geetest.gtc4;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Random;

public class Utils {
    public static String getCert() {
        if (Build.VERSION.SDK_INT < 24) {
            return "";
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            if (instance.containsAlias("no506b3822wb")) {
                instance.deleteEntry("no506b3822wb");
            }
            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder("no506b3822wb", 12);
            byte[] bArr = new byte[8];
            new Random().nextBytes(bArr);
            KeyGenParameterSpec.Builder unused = builder.setAttestationChallenge(bArr);
            KeyPairGenerator instance2 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
            instance2.initialize(builder.build());
            instance2.generateKeyPair();
            return Base64.encodeToString(((X509Certificate) instance.getCertificateChain("no506b3822wb")[0]).getExtensionValue("1.3.6.1.4.1.11129.2.1.17"), 2);
        } catch (Exception unused2) {
            return "";
        }
    }

    private static String getSignature(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return "";
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
