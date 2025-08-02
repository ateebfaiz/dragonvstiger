package com.sensorsdata.analytics.android.sdk.encrypt.encryptor;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager;
import com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt;
import com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils;
import java.security.NoSuchAlgorithmException;

public class SARSAEncrypt extends AbsSAEncrypt {
    byte[] aesKey;
    String mEncryptKey;

    public String asymmetricEncryptType() {
        return "RSA";
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
                this.mEncryptKey = EncryptUtils.encryptAESKey(str, generateSymmetricKey, "RSA");
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
