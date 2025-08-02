package com.sensorsdata.analytics.android.sdk.encrypt.encryptor;

import bd.a;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager;
import com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt;
import com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class SAECEncrypt extends AbsSAEncrypt {
    byte[] aesKey;
    String mEncryptKey;

    static {
        Class<a> cls = a.class;
        try {
            xc.a aVar = a.f32b;
            Security.addProvider(cls.newInstance());
        } catch (Exception e10) {
            SALog.i("SA.SAECEncrypt", e10.toString());
        }
    }

    public String asymmetricEncryptType() {
        return "EC";
    }

    public String decryptEventRecord(String str) {
        return AESSecretManager.getInstance().decryptAES(str);
    }

    public String encryptEvent(byte[] bArr) {
        return EncryptUtils.symmetricEncrypt(this.aesKey, bArr, SymmetricEncryptMode.AES);
    }

    public String encryptEventRecord(String str) {
        return AESSecretManager.getInstance().encryptAES(str);
    }

    public String encryptSymmetricKeyWithPublicKey(String str) {
        if (this.mEncryptKey == null) {
            try {
                byte[] generateSymmetricKey = EncryptUtils.generateSymmetricKey(SymmetricEncryptMode.AES);
                this.aesKey = generateSymmetricKey;
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "EC");
            } catch (NoSuchAlgorithmException e10) {
                SALog.printStackTrace(e10);
                return null;
            }
        }
        return this.mEncryptKey;
    }

    public String symmetricEncryptType() {
        return "AES";
    }
}
