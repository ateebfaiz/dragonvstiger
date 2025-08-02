package com.appsflyer.internal;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

public final class AFe1qSDK {
    public static final Charset AFInAppEventType = Charset.forName("UTF-8");
    public final AFc1ySDK AFInAppEventParameterName;
    public long AFKeystoreWrapper;
    public AFb1iSDK valueOf = values();
    public long values;

    public AFe1qSDK(AFc1ySDK aFc1ySDK) {
        this.AFInAppEventParameterName = aFc1ySDK;
        this.AFKeystoreWrapper = aFc1ySDK.AFInAppEventParameterName("af_rc_timestamp", 0);
        this.values = aFc1ySDK.AFInAppEventParameterName("af_rc_max_age", 0);
    }

    @Nullable
    private AFb1iSDK values() {
        String values2 = this.AFInAppEventParameterName.values("af_remote_config", (String) null);
        if (values2 == null) {
            AFLogger.afDebugLog("CFG: No configuration found in cache");
            return null;
        }
        try {
            return new AFb1iSDK(new String(Base64.decode(values2, 2), AFInAppEventType));
        } catch (Exception e10) {
            AFLogger.afErrorLog("CFG: Error reading malformed configuration from cache, requires fetching from remote again", e10, true);
            return null;
        }
    }
}
