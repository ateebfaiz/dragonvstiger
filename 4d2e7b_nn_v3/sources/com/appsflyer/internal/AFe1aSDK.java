package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;

public final class AFe1aSDK extends AFa1sSDK {
    @Nullable
    public final AFd1rSDK getLevel;

    @Deprecated
    public AFe1aSDK() {
        this.getLevel = null;
    }

    public final AFd1rSDK AFInAppEventType() {
        AFd1rSDK aFd1rSDK = this.getLevel;
        if (aFd1rSDK != null) {
            return aFd1rSDK;
        }
        return AFd1rSDK.CACHED_EVENT;
    }

    public AFe1aSDK(String str, byte[] bArr, String str2, @Nullable AFd1rSDK aFd1rSDK) {
        super((String) null, str, Boolean.FALSE, (Context) null);
        this.afRDLog = str2;
        AFInAppEventType(bArr);
        this.getLevel = aFd1rSDK;
    }
}
