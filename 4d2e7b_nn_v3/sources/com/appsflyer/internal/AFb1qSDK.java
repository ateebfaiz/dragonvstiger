package com.appsflyer.internal;

import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1qSDK {
    public final int AFInAppEventParameterName;
    public final int AFInAppEventType;
    public final long valueOf;
    public final String values;

    public AFb1qSDK() {
    }

    @Nullable
    static JSONObject values(String str) {
        JSONObject AFInAppEventParameterName2 = AFa1oSDK.AFInAppEventParameterName(str);
        if (AFInAppEventParameterName2 != null) {
            try {
                boolean z10 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                boolean optBoolean = AFInAppEventParameterName2.optBoolean("monitor", false);
                AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                if (!optBoolean || z10) {
                    afErrorLogForExcManagerOnly.AFInAppEventType();
                    afErrorLogForExcManagerOnly.values();
                } else {
                    afErrorLogForExcManagerOnly.AFInAppEventParameterName();
                }
                if (AFInAppEventParameterName2.has("ol_id")) {
                    String optString = AFInAppEventParameterName2.optString("ol_scheme", (String) null);
                    String optString2 = AFInAppEventParameterName2.optString("ol_domain", (String) null);
                    String optString3 = AFInAppEventParameterName2.optString("ol_ver", (String) null);
                    if (optString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                    }
                    if (optString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                    }
                    if (optString3 != null) {
                        AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("Error in handleResponse: ");
                sb2.append(th.getMessage());
                AFLogger.afErrorLogForExcManagerOnly(sb2.toString(), th);
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType();
                AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().values();
            }
        }
        return AFInAppEventParameterName2;
    }

    public final String AFInAppEventType() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_ver", this.values);
            jSONObject.put("min", this.AFInAppEventParameterName);
            jSONObject.put("expire", this.AFInAppEventType);
            jSONObject.put("ttl", this.valueOf);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final int hashCode() {
        int i10;
        String str = this.values;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return (((((i10 * 31) + this.AFInAppEventParameterName) * 31) + this.AFInAppEventType) * 31) + ((int) this.valueOf);
    }

    public AFb1qSDK(String str, int i10, int i11, long j10) {
        this.values = str;
        this.AFInAppEventParameterName = i10;
        this.AFInAppEventType = i11;
        this.valueOf = j10;
    }
}
