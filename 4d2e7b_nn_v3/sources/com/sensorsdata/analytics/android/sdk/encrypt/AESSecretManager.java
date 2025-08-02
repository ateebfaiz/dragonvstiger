package com.sensorsdata.analytics.android.sdk.encrypt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESSecretManager {
    private static final String ALGORITHM = "AES";
    private static final String CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String CHARSET_NAME = "UTF-8";
    private static final String SECRET_KEY_FILE = "com.sensorsdata.analytics.android.sdk.other";
    private static final String TAG = "SA.AESSecretManager";
    private static final byte[] ZERO_IV = new byte[16];
    private String mAESSecret;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final AESSecretManager INSTANCE = new AESSecretManager();

        private SingletonHolder() {
        }
    }

    private String generateAESKey() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(ALGORITHM);
            instance.init(128);
            return new String(Base64Coder.encode(instance.generateKey().getEncoded()));
        } catch (Exception e10) {
            SALog.i(TAG, "generateAESKey fail, msg: " + e10);
            return "";
        }
    }

    public static AESSecretManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private SecretKey strKey2SecretKey(String str) {
        return new SecretKeySpec(Base64Coder.decode(str), ALGORITHM);
    }

    public String decryptAES(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(this.mAESSecret)) {
                return str;
            }
            Cipher instance = Cipher.getInstance(CBC_PKCS5_PADDING);
            instance.init(2, strKey2SecretKey(this.mAESSecret), new IvParameterSpec(ZERO_IV));
            return new String(instance.doFinal(Base64Coder.decode(str)), "UTF-8");
        } catch (Exception e10) {
            SALog.i(TAG, "decryptAES fail, msg: " + e10);
            return "";
        }
    }

    public String encryptAES(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(this.mAESSecret)) {
                return str;
            }
            Cipher instance = Cipher.getInstance(CBC_PKCS5_PADDING);
            instance.init(1, strKey2SecretKey(this.mAESSecret), new IvParameterSpec(ZERO_IV));
            return new String(Base64Coder.encode(instance.doFinal(str.getBytes("UTF-8"))));
        } catch (Exception e10) {
            SALog.i(TAG, "encryptAES fail, msg: " + e10);
            return "";
        }
    }

    public void initSecretKey(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SECRET_KEY_FILE, 0);
        String string = sharedPreferences.getString(Base64Coder.encodeString(SAStoreManager.SECRET_KEY), "");
        this.mAESSecret = string;
        if (TextUtils.isEmpty(string)) {
            this.mAESSecret = generateAESKey();
            sharedPreferences.edit().putString(Base64Coder.encodeString(SAStoreManager.SECRET_KEY), this.mAESSecret).apply();
        }
    }

    private AESSecretManager() {
    }
}
