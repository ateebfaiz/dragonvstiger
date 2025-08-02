package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;

public final class AFc1xSDK implements AFc1ySDK {
    private final SharedPreferences AFInAppEventType;

    public AFc1xSDK(SharedPreferences sharedPreferences) {
        this.AFInAppEventType = sharedPreferences;
    }

    public final long AFInAppEventParameterName(String str, long j10) {
        try {
            return this.AFInAppEventType.getLong(str, j10);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return j10;
        }
    }

    public final void AFInAppEventType(String str, boolean z10) {
        this.AFInAppEventType.edit().putBoolean(str, z10).apply();
    }

    public final boolean AFKeystoreWrapper(String str) {
        try {
            return this.AFInAppEventType.getBoolean(str, false);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return false;
        }
    }

    public final void valueOf(String str, String str2) {
        this.AFInAppEventType.edit().putString(str, str2).apply();
    }

    public final String values(String str, String str2) {
        try {
            return this.AFInAppEventType.getString(str, str2);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return str2;
        }
    }

    public final void AFInAppEventType(String str, long j10) {
        this.AFInAppEventType.edit().putLong(str, j10).apply();
    }

    public final void valueOf(String str) {
        this.AFInAppEventType.edit().remove(str).apply();
    }

    public final int AFInAppEventType(String str, int i10) {
        try {
            return this.AFInAppEventType.getInt(str, i10);
        } catch (ClassCastException e10) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e10);
            return i10;
        }
    }

    public final void AFKeystoreWrapper(String str, int i10) {
        this.AFInAppEventType.edit().putInt(str, i10).apply();
    }
}
