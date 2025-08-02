package com.appsflyer.internal;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AFb1cSDK {
    @Nullable
    public static Application AFKeystoreWrapper;
    public long AFInAppEventParameterName;
    @Nullable
    public String AFInAppEventType;
    @Nullable
    public AFf1tSDK AFLogger;
    @Nullable
    public String afDebugLog;
    @Nullable
    public Throwable afInfoLog;
    public int afRDLog;
    public long valueOf;
    @NonNull
    public String values;

    public AFb1cSDK() {
    }

    public AFb1cSDK(String str, String str2, long j10, long j11, int i10, AFf1tSDK aFf1tSDK, String str3, Throwable th) {
        this.AFInAppEventType = str;
        this.values = str2;
        this.AFInAppEventParameterName = j10;
        this.valueOf = j11;
        this.afRDLog = i10;
        this.AFLogger = aFf1tSDK;
        this.afDebugLog = str3;
        this.afInfoLog = th;
    }
}
