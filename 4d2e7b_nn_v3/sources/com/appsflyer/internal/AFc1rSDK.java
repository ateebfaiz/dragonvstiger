package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.webkit.ProxyConfig;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

@WorkerThread
public class AFc1rSDK implements AFc1oSDK, AFc1wSDK, AFd1uSDK {
    @VisibleForTesting
    private static String AFInAppEventType;
    @VisibleForTesting
    private static String valueOf;
    @NonNull
    private final String AFInAppEventParameterName;
    @Nullable
    private final byte[] AFKeystoreWrapper;
    private boolean AFLogger;
    private int AFVersionDeclaration;
    private boolean afDebugLog;
    private boolean afErrorLog;
    private final boolean afInfoLog;
    @NonNull
    private final Map<String, String> afRDLog;
    @NonNull
    private final String values;

    public AFc1rSDK() {
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFInAppEventType == null) {
            AFKeystoreWrapper(AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().getLevel().values);
        }
        String str2 = AFInAppEventType;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, valueOf));
        }
    }

    public static void AFKeystoreWrapper(String str) {
        AFInAppEventType = str;
        if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                if (i10 == 0 || i10 == str.length() - 1) {
                    sb2.append(str.charAt(i10));
                } else {
                    sb2.append(ProxyConfig.MATCH_ALL_SCHEMES);
                }
            }
            valueOf = sb2.toString();
        }
    }

    @Nullable
    public byte[] AFInAppEventType() {
        return this.AFKeystoreWrapper;
    }

    @NonNull
    public Map<String, String> AFLogger() {
        return this.afRDLog;
    }

    public boolean AFLogger$LogLevel() {
        return this.AFLogger;
    }

    @NonNull
    public String afDebugLog() {
        return this.values;
    }

    public boolean afErrorLog() {
        return this.afInfoLog;
    }

    public AFc1rSDK afErrorLogForExcManagerOnly() {
        this.AFLogger = false;
        return this;
    }

    public boolean afInfoLog() {
        return this.afErrorLog;
    }

    public int afRDLog() {
        return this.AFVersionDeclaration;
    }

    public boolean afWarnLog() {
        return this.afDebugLog;
    }

    @NonNull
    public String valueOf() {
        return this.AFInAppEventParameterName;
    }

    public AFc1rSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z10) {
        this.afErrorLog = true;
        this.afDebugLog = false;
        this.AFLogger = true;
        this.AFVersionDeclaration = -1;
        this.AFInAppEventParameterName = str;
        this.AFKeystoreWrapper = bArr;
        this.values = str2;
        this.afRDLog = map;
        this.afInfoLog = z10;
    }

    public AFc1rSDK valueOf(int i10) {
        this.AFVersionDeclaration = i10;
        return this;
    }

    public AFc1rSDK AFKeystoreWrapper(boolean z10) {
        this.afDebugLog = z10;
        return this;
    }

    public AFc1rSDK(String str, String str2) {
        this(str, (byte[]) null, str2, new HashMap(), false);
    }
}
