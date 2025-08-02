package com.appsflyer.internal;

import androidx.annotation.Nullable;

@Deprecated
public final class AFa1rSDK {
    private final AFb1sSDK AFInAppEventType;
    private final AFe1bSDK valueOf;

    public interface AFa1vSDK {
        void valueOf(String str);

        void values(@Nullable String str, @Nullable String str2, @Nullable String str3);
    }

    AFa1rSDK() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection AFInAppEventType(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = 0
            r2 = 1
            com.appsflyer.internal.AFe1bSDK r3 = r1.valueOf
            java.lang.String r4 = r3.afErrorLog
            java.util.Map r3 = r3.AFKeystoreWrapper()
            org.json.JSONObject r3 = com.appsflyer.internal.AFa1oSDK.AFKeystoreWrapper((java.util.Map<java.lang.String, ?>) r3)
            java.lang.String r3 = r3.toString()
            com.appsflyer.internal.AFe1bSDK r5 = r1.valueOf
            boolean r5 = r5.afErrorLogForExcManagerOnly()
            com.appsflyer.internal.AFe1bSDK r6 = r1.valueOf
            boolean r6 = r6.afWarnLog()
            com.appsflyer.internal.AFe1bSDK r7 = r1.valueOf
            boolean r7 = r7.AFLogger$LogLevel()
            com.appsflyer.internal.AFe1bSDK r8 = r1.valueOf
            boolean r8 = r8.valueOf()
            java.lang.String r9 = ""
            byte[] r10 = r3.getBytes()
            r11 = 0
            if (r5 == 0) goto L_0x0036
            return r11
        L_0x0036:
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x0069 }
            r5.<init>(r4)     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x007f
            com.appsflyer.internal.AFb1sSDK r12 = r1.AFInAppEventType     // Catch:{ all -> 0x0069 }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x0069 }
            r12.AFInAppEventParameterName(r13, r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r3.getBytes(r12)     // Catch:{ all -> 0x0069 }
            int r12 = r12.length     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x0069 }
            r13.append(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x0069 }
            r13.append(r12)     // Catch:{ all -> 0x0069 }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x0069 }
            if (r12 <= r2) goto L_0x006c
            java.lang.String r12 = "s"
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            goto L_0x0157
        L_0x006c:
            r12 = r9
        L_0x006d:
            r13.append(r12)     // Catch:{ all -> 0x0069 }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x0069 }
            r13.append(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = r13.toString()     // Catch:{ all -> 0x0069 }
            com.appsflyer.internal.AFc1rSDK.AFInAppEventParameterName(r3)     // Catch:{ all -> 0x0069 }
        L_0x007f:
            java.lang.String r3 = "AppsFlyer"
            int r3 = r3.hashCode()     // Catch:{ all -> 0x0069 }
            android.net.TrafficStats.setThreadStatsTag(r3)     // Catch:{ all -> 0x0069 }
            java.net.URLConnection r3 = r5.openConnection()     // Catch:{ all -> 0x0069 }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x0069 }
            r12 = 30000(0x7530, float:4.2039E-41)
            r3.setReadTimeout(r12)     // Catch:{ all -> 0x00a8 }
            r3.setConnectTimeout(r12)     // Catch:{ all -> 0x00a8 }
            java.lang.String r12 = "POST"
            r3.setRequestMethod(r12)     // Catch:{ all -> 0x00a8 }
            r3.setDoInput(r2)     // Catch:{ all -> 0x00a8 }
            r3.setDoOutput(r2)     // Catch:{ all -> 0x00a8 }
            java.lang.String r12 = "Content-Type"
            if (r8 == 0) goto L_0x00ac
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00ae
        L_0x00a8:
            r0 = move-exception
            r11 = r3
            goto L_0x0157
        L_0x00ac:
            java.lang.String r13 = "application/json"
        L_0x00ae:
            r3.setRequestProperty(r12, r13)     // Catch:{ all -> 0x00a8 }
            java.io.OutputStream r12 = r3.getOutputStream()     // Catch:{ all -> 0x00a8 }
            if (r8 == 0) goto L_0x012d
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0124 }
            r8[r0] = r18     // Catch:{ all -> 0x0124 }
            int r13 = android.view.View.MeasureSpec.getSize(r0)     // Catch:{ all -> 0x0124 }
            int r13 = r13 + 37
            float r14 = android.util.TypedValue.complexToFloat(r0)     // Catch:{ all -> 0x0124 }
            r15 = 0
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            int r14 = 36 - r14
            int r16 = android.view.ViewConfiguration.getScrollBarSize()     // Catch:{ all -> 0x0124 }
            int r15 = r16 >> 8
            char r15 = (char) r15     // Catch:{ all -> 0x0124 }
            java.lang.Object r13 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r13, r14, r15)     // Catch:{ all -> 0x0124 }
            java.lang.Class r13 = (java.lang.Class) r13     // Catch:{ all -> 0x0124 }
            java.lang.String r14 = "values"
            java.lang.Class[] r15 = new java.lang.Class[r2]     // Catch:{ all -> 0x0124 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r15[r0] = r16     // Catch:{ all -> 0x0124 }
            java.lang.reflect.Method r13 = r13.getMethod(r14, r15)     // Catch:{ all -> 0x0124 }
            java.lang.Object r8 = r13.invoke(r11, r8)     // Catch:{ all -> 0x0124 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x011b }
            r11[r0] = r10     // Catch:{ all -> 0x011b }
            int r10 = android.text.TextUtils.getOffsetBefore(r9, r0)     // Catch:{ all -> 0x011b }
            int r10 = r10 + 37
            int r13 = android.graphics.Color.rgb(r0, r0, r0)     // Catch:{ all -> 0x011b }
            r14 = -16777180(0xffffffffff000024, float:-1.7014191E38)
            int r14 = r14 - r13
            float r13 = android.util.TypedValue.complexToFloat(r0)     // Catch:{ all -> 0x011b }
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            char r13 = (char) r13     // Catch:{ all -> 0x011b }
            java.lang.Object r10 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r10, r14, r13)     // Catch:{ all -> 0x011b }
            java.lang.Class r10 = (java.lang.Class) r10     // Catch:{ all -> 0x011b }
            java.lang.String r13 = "valueOf"
            java.lang.Class[] r14 = new java.lang.Class[r2]     // Catch:{ all -> 0x011b }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r0] = r15     // Catch:{ all -> 0x011b }
            java.lang.reflect.Method r10 = r10.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x011b }
            java.lang.Object r8 = r10.invoke(r8, r11)     // Catch:{ all -> 0x011b }
            r10 = r8
            byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x011b }
            goto L_0x012d
        L_0x011b:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x00a8 }
            if (r5 == 0) goto L_0x0123
            throw r5     // Catch:{ all -> 0x00a8 }
        L_0x0123:
            throw r0     // Catch:{ all -> 0x00a8 }
        L_0x0124:
            r0 = move-exception
            java.lang.Throwable r5 = r0.getCause()     // Catch:{ all -> 0x00a8 }
            if (r5 == 0) goto L_0x012c
            throw r5     // Catch:{ all -> 0x00a8 }
        L_0x012c:
            throw r0     // Catch:{ all -> 0x00a8 }
        L_0x012d:
            r12.write(r10)     // Catch:{ all -> 0x00a8 }
            r12.close()     // Catch:{ all -> 0x00a8 }
            r3.connect()     // Catch:{ all -> 0x00a8 }
            int r8 = r3.getResponseCode()     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x0140
            java.lang.String r9 = com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper((java.net.HttpURLConnection) r3)     // Catch:{ all -> 0x00a8 }
        L_0x0140:
            if (r7 == 0) goto L_0x014b
            com.appsflyer.internal.AFb1sSDK r6 = r1.AFInAppEventType     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a8 }
            r6.AFKeystoreWrapper(r5, r8, r9)     // Catch:{ all -> 0x00a8 }
        L_0x014b:
            r5 = 200(0xc8, float:2.8E-43)
            if (r8 != r5) goto L_0x0155
            java.lang.String r5 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r5)     // Catch:{ all -> 0x00a8 }
            goto L_0x0166
        L_0x0155:
            r0 = r2
            goto L_0x0166
        L_0x0157:
            java.lang.String r3 = java.lang.String.valueOf(r4)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
            r0 = r2
            r3 = r11
        L_0x0166:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Connection "
            r2.<init>(r4)
            if (r0 == 0) goto L_0x0172
            java.lang.String r0 = "error"
            goto L_0x0174
        L_0x0172:
            java.lang.String r0 = "call succeeded"
        L_0x0174:
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1rSDK.AFInAppEventType(java.lang.String):java.net.HttpURLConnection");
    }

    public AFa1rSDK(AFe1bSDK aFe1bSDK, AFb1sSDK aFb1sSDK) {
        this.valueOf = aFe1bSDK;
        this.AFInAppEventType = aFb1sSDK;
    }
}
