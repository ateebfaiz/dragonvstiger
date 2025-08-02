package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;

public abstract class AFf1vSDK extends AFe1bSDK {
    AFf1vSDK() {
        this((String) null, (Boolean) null, (Context) null);
    }

    public final boolean AFLogger() {
        return false;
    }

    public final boolean afDebugLog() {
        return false;
    }

    public final boolean afErrorLog() {
        return false;
    }

    AFf1vSDK(@Nullable String str, @Nullable Boolean bool, @Nullable Context context) {
        super(str, (String) null, Boolean.FALSE, (Boolean) null, bool, context);
    }
}
