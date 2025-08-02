package com.sensorsdata.analytics.android.sdk.encrypt.impl;

import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;

public interface SAEncryptAPI {
    String decryptAES(String str);

    String encryptAES(String str);

    <T> T encryptEventData(T t10);

    <T> T encryptEventData(T t10, SecreteKey secreteKey);

    String loadSecretKey();

    void storeSecretKey(String str);

    String verifySecretKey(Uri uri);
}
