package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import com.google.firebase.messaging.Constants;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class AFd1eSDK extends AFd1pSDK<Map<String, Object>> {
    private static final int afErrorLog = ((int) TimeUnit.SECONDS.toMillis(2));
    private final Map<String, Object> AFLogger;
    private Map<String, Object> afDebugLog;
    private final List<String> afErrorLogForExcManagerOnly;
    private final Uri afInfoLog;
    private final Context afRDLog;

    public AFd1eSDK(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull Uri uri, @NonNull List<String> list) {
        super(AFd1rSDK.RESOLVE_ESP, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "ResolveEsp");
        this.afRDLog = context;
        this.AFLogger = map;
        this.afInfoLog = uri;
        this.afErrorLogForExcManagerOnly = list;
    }

    private static Map<String, Object> values(Uri uri) {
        HashMap hashMap = new HashMap();
        try {
            StringBuilder sb2 = new StringBuilder("ESP deeplink resolving is started: ");
            sb2.append(uri.toString());
            AFLogger.afDebugLog(sb2.toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            int i10 = afErrorLog;
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.10.2");
            int responseCode = httpURLConnection.getResponseCode();
            hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                hashMap.put("res", httpURLConnection.getHeaderField("Location"));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
        } catch (Throwable th) {
            hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        return hashMap;
    }

    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        String str;
        Integer num;
        String str2;
        if (!AFInAppEventType(this.afInfoLog.toString())) {
            AFb1xSDK.AFInAppEventType().values(this.afRDLog, this.AFLogger, this.afInfoLog);
            return AFd1tSDK.SUCCESS;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.afInfoLog.toString();
        ArrayList arrayList = new ArrayList();
        Integer num2 = null;
        int i10 = 0;
        String str3 = null;
        while (true) {
            if (i10 >= 5) {
                break;
            }
            Map<String, Object> values = values(Uri.parse(obj));
            str = (String) values.get("res");
            num = (Integer) values.get(NotificationCompat.CATEGORY_STATUS);
            str2 = (String) values.get(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (str == null || !AFInAppEventType(str)) {
                Integer num3 = num;
                str3 = str2;
                obj = str;
                num2 = num3;
            } else {
                if (i10 < 4) {
                    arrayList.add(str);
                }
                i10++;
                Integer num4 = num;
                str3 = str2;
                obj = str;
                num2 = num4;
            }
        }
        Integer num32 = num;
        str3 = str2;
        obj = str;
        num2 = num32;
        HashMap hashMap = new HashMap();
        hashMap.put("res", obj != null ? obj : "");
        hashMap.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(num2 != null ? num2.intValue() : -1));
        if (str3 != null) {
            hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str3);
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("redirects", arrayList);
        }
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        synchronized (this.AFLogger) {
            this.AFLogger.put("af_deeplink_r", hashMap);
            this.AFLogger.put("af_deeplink", this.afInfoLog.toString());
        }
        AFb1xSDK.AFInAppEventType().values(this.afRDLog, this.AFLogger, obj != null ? Uri.parse(obj) : this.afInfoLog);
        this.afDebugLog = hashMap;
        return AFd1tSDK.SUCCESS;
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    public final long valueOf() {
        return 60000;
    }

    private boolean AFInAppEventType(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder("Validate if link ");
        sb2.append(str);
        sb2.append(" belongs to ESP domains: ");
        sb2.append(this.afErrorLogForExcManagerOnly);
        AFLogger.afRDLog(sb2.toString());
        try {
            return this.afErrorLogForExcManagerOnly.contains(new URL(str).getHost());
        } catch (MalformedURLException e10) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e10);
            return false;
        }
    }
}
