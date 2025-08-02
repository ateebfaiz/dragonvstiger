package com.sensorsdata.analytics.android.sdk.encrypt.impl;

import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;

public abstract class AbsSAEncrypt implements SAEncryptListener {
    public String decryptEventRecord(String str) {
        return str;
    }

    public String encryptEventRecord(String str) {
        return str;
    }
}
