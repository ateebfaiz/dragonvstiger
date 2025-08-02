package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1xSDK;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    private static final AppsFlyerProperties AFInAppEventType = new AppsFlyerProperties();
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_NETWORK_DATA = "disableCollectNetworkData";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    private boolean AFInAppEventParameterName = false;
    private final Map<String, Object> AFKeystoreWrapper = new HashMap();
    public String valueOf;
    public boolean values;

    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        
        private final int values;

        private EmailsCryptType(int i10) {
            this.values = i10;
        }

        public final int getValue() {
            return this.values;
        }
    }

    private AppsFlyerProperties() {
    }

    private boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName;
    }

    public static AppsFlyerProperties getInstance() {
        return AFInAppEventType;
    }

    public final boolean AFKeystoreWrapper() {
        return this.values;
    }

    public boolean getBoolean(String str, boolean z10) {
        String string = getString(str);
        if (string == null) {
            return z10;
        }
        return Boolean.parseBoolean(string);
    }

    public int getInt(String str, int i10) {
        String string = getString(str);
        if (string == null) {
            return i10;
        }
        return Integer.parseInt(string);
    }

    public long getLong(String str, long j10) {
        String string = getString(str);
        if (string == null) {
            return j10;
        }
        return Long.parseLong(string);
    }

    public synchronized Object getObject(String str) {
        return this.AFKeystoreWrapper.get(str);
    }

    public String getReferrer(Context context) {
        String str = this.valueOf;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return AFb1xSDK.AFKeystoreWrapper(context).getString(Constants.REFERRER, (String) null);
    }

    @Nullable
    public synchronized String getString(String str) {
        return (String) this.AFKeystoreWrapper.get(str);
    }

    public boolean isEnableLog() {
        AFLogger.LogLevel logLevel = AFLogger.LogLevel.NONE;
        if (getInt("logLevel", logLevel.getLevel()) > logLevel.getLevel()) {
            return true;
        }
        return false;
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadProperties(android.content.Context r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.AFInAppEventParameterName()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            android.content.SharedPreferences r6 = com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper((android.content.Context) r6)     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = "savedProperties"
            r1 = 0
            java.lang.String r0 = r6.getString(r0, r1)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x007d
            java.lang.String r1 = "Loading properties.."
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0042 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0044 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0044 }
            java.util.Iterator r0 = r1.keys()     // Catch:{ JSONException -> 0x0044 }
        L_0x0024:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0044 }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0044 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.AFKeystoreWrapper     // Catch:{ JSONException -> 0x0044 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ JSONException -> 0x0044 }
            if (r3 != 0) goto L_0x0024
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.AFKeystoreWrapper     // Catch:{ JSONException -> 0x0044 }
            java.lang.String r4 = r1.getString(r2)     // Catch:{ JSONException -> 0x0044 }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x0044 }
            goto L_0x0024
        L_0x0042:
            r6 = move-exception
            goto L_0x007f
        L_0x0044:
            r6 = move-exception
            goto L_0x0065
        L_0x0046:
            java.lang.String r0 = "AppsFlyerKey"
            java.lang.String r1 = "custom_host"
            java.lang.String r2 = "custom_host_prefix"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2}     // Catch:{ JSONException -> 0x0044 }
            r1 = 0
        L_0x0051:
            r2 = 3
            if (r1 >= r2) goto L_0x005e
            r2 = r0[r1]     // Catch:{ JSONException -> 0x0044 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.AFKeystoreWrapper     // Catch:{ JSONException -> 0x0044 }
            r3.remove(r2)     // Catch:{ JSONException -> 0x0044 }
            int r1 = r1 + 1
            goto L_0x0051
        L_0x005e:
            r5.saveProperties(r6)     // Catch:{ JSONException -> 0x0044 }
            r6 = 1
            r5.AFInAppEventParameterName = r6     // Catch:{ JSONException -> 0x0044 }
            goto L_0x006a
        L_0x0065:
            java.lang.String r0 = "Failed loading properties"
            com.appsflyer.AFLogger.afErrorLog(r0, r6)     // Catch:{ all -> 0x0042 }
        L_0x006a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = "Done loading properties: "
            r6.<init>(r0)     // Catch:{ all -> 0x0042 }
            boolean r0 = r5.AFInAppEventParameterName     // Catch:{ all -> 0x0042 }
            r6.append(r0)     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0042 }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ all -> 0x0042 }
        L_0x007d:
            monitor-exit(r5)
            return
        L_0x007f:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerProperties.loadProperties(android.content.Context):void");
    }

    public synchronized void remove(String str) {
        this.AFKeystoreWrapper.remove(str);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        this.AFKeystoreWrapper.remove("AppsFlyerKey");
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.AFKeystoreWrapper).toString()).apply();
    }

    public synchronized void set(String str, String str2) {
        this.AFKeystoreWrapper.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.AFKeystoreWrapper.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public synchronized void setUserEmails(String str) {
        this.AFKeystoreWrapper.put(USER_EMAILS, str);
    }

    public synchronized void set(String str, String[] strArr) {
        this.AFKeystoreWrapper.put(str, strArr);
    }

    public synchronized void set(String str, int i10) {
        this.AFKeystoreWrapper.put(str, Integer.toString(i10));
    }

    public synchronized void set(String str, long j10) {
        this.AFKeystoreWrapper.put(str, Long.toString(j10));
    }

    public synchronized void set(String str, boolean z10) {
        this.AFKeystoreWrapper.put(str, Boolean.toString(z10));
    }
}
