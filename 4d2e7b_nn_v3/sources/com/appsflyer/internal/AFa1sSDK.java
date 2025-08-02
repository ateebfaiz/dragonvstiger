package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AFa1sSDK {
    @Nullable
    Map<String, Object> AFInAppEventParameterName;
    @Nullable
    public Application AFInAppEventType;
    public final Map<String, Object> AFKeystoreWrapper;
    String AFLogger;
    private byte[] AFLogger$LogLevel;
    private final boolean AFVersionDeclaration;
    String afDebugLog;
    public String afErrorLog;
    public int afInfoLog;
    public String afRDLog;
    @Nullable
    String valueOf;
    @Nullable
    public AppsFlyerRequestListener values;

    public AFa1sSDK() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public final boolean AFInAppEventParameterName() {
        return this.afDebugLog == null && this.afRDLog == null;
    }

    public final AFa1sSDK AFInAppEventType(byte[] bArr) {
        this.AFLogger$LogLevel = bArr;
        return this;
    }

    public abstract AFd1rSDK AFInAppEventType();

    public AFa1sSDK AFKeystoreWrapper(String str) {
        this.afErrorLog = str;
        return this;
    }

    public boolean AFLogger() {
        return true;
    }

    public boolean afDebugLog() {
        return true;
    }

    public boolean afErrorLog() {
        return true;
    }

    public boolean afRDLog() {
        return false;
    }

    public final boolean valueOf() {
        return this.AFVersionDeclaration;
    }

    public final byte[] values() {
        return this.AFLogger$LogLevel;
    }

    public AFa1sSDK(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Context context) {
        this.AFKeystoreWrapper = new HashMap();
        this.afDebugLog = str;
        this.afErrorLog = str2;
        this.AFVersionDeclaration = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.AFInAppEventType = (Application) context.getApplicationContext();
        }
    }

    public static boolean values(double d10) {
        if (d10 < 0.0d || d10 >= 1.0d) {
            return false;
        }
        if (d10 == 0.0d) {
            return true;
        }
        int i10 = (int) (1.0d / d10);
        if (i10 + 1 > 0) {
            return ((int) ((Math.random() * ((double) i10)) + 1.0d)) != i10;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }

    public final AFa1sSDK AFInAppEventParameterName(int i10) {
        this.afInfoLog = i10;
        synchronized (this.AFKeystoreWrapper) {
            try {
                if (this.AFKeystoreWrapper.containsKey("counter")) {
                    this.AFKeystoreWrapper.put("counter", Integer.toString(i10));
                }
                if (this.AFKeystoreWrapper.containsKey("launch_counter")) {
                    this.AFKeystoreWrapper.put("launch_counter", Integer.toString(i10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public final AFa1sSDK AFKeystoreWrapper(Map<String, ?> map) {
        synchronized (map) {
            this.AFKeystoreWrapper.putAll(map);
        }
        return this;
    }

    public final AFa1sSDK AFKeystoreWrapper(String str, Object obj) {
        synchronized (this.AFKeystoreWrapper) {
            this.AFKeystoreWrapper.put(str, obj);
        }
        return this;
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        return this.AFKeystoreWrapper;
    }
}
