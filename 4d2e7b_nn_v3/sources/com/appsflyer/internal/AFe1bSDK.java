package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;

public abstract class AFe1bSDK extends AFa1sSDK {
    private final boolean AFLogger$LogLevel;
    public boolean AFVersionDeclaration;
    private final boolean afWarnLog;

    AFe1bSDK() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    public final boolean AFLogger$LogLevel() {
        return this.AFLogger$LogLevel;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        return this.AFVersionDeclaration;
    }

    public final boolean afWarnLog() {
        return this.afWarnLog;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1bSDK(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z10 = true;
        this.afWarnLog = bool != null ? bool.booleanValue() : true;
        this.AFLogger$LogLevel = bool2 != null ? bool2.booleanValue() : z10;
    }
}
