package com.sensorsdata.analytics.android.sdk.network;

import android.text.TextUtils;
import com.alibaba.pdns.s.e.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class HttpUtils {
    private static final int HTTP_307 = 307;

    HttpUtils() {
    }

    static String getLocation(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField(FirebaseAnalytics.Param.LOCATION);
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith(c.f18246k) || headerField.startsWith(c.f18247l)) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b A[SYNTHETIC, Splitter:B:29:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0055 A[SYNTHETIC, Splitter:B:34:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006c A[SYNTHETIC, Splitter:B:44:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String getRetString(java.io.InputStream r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r5, r3)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r0.<init>()     // Catch:{ Exception -> 0x0023 }
        L_0x0012:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x0025
            r0.append(r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0012
        L_0x0021:
            r0 = move-exception
            goto L_0x0060
        L_0x0023:
            r0 = move-exception
            goto L_0x0046
        L_0x0025:
            r5.close()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x0034:
            r5.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x003c:
            return r0
        L_0x003d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0060
        L_0x0042:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0046:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0053:
            if (r5 == 0) goto L_0x005d
            r5.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x005d:
            java.lang.String r5 = ""
            return r5
        L_0x0060:
            if (r1 == 0) goto L_0x006a
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x006a:
            if (r5 == 0) goto L_0x0074
            r5.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0074:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.HttpUtils.getRetString(java.io.InputStream):java.lang.String");
    }

    static boolean needRedirects(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 307;
    }
}
