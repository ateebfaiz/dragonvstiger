package com.appsflyer.internal;

public final class AFc1fSDK {
    private final int AFInAppEventType;

    public AFc1fSDK(int i10) {
        this.AFInAppEventType = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String AFInAppEventParameterName(java.net.HttpURLConnection r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x000b
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0008 }
            goto L_0x000f
        L_0x0008:
            r4 = move-exception
            r5 = r0
            goto L_0x004b
        L_0x000b:
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ all -> 0x0008 }
        L_0x000f:
            if (r4 != 0) goto L_0x0014
            java.lang.String r4 = ""
            return r4
        L_0x0014:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0008 }
            r5.<init>()     // Catch:{ all -> 0x0008 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0008 }
            r1.<init>(r4)     // Catch:{ all -> 0x0008 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0048 }
            r4.<init>(r1)     // Catch:{ all -> 0x0048 }
            r0 = 1
        L_0x0024:
            java.lang.String r2 = r4.readLine()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x003d
            if (r0 != 0) goto L_0x0038
            r0 = 10
            r5.append(r0)     // Catch:{ all -> 0x0032 }
            goto L_0x0038
        L_0x0032:
            r5 = move-exception
            r0 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x004b
        L_0x0038:
            r5.append(r2)     // Catch:{ all -> 0x0032 }
            r0 = 0
            goto L_0x0024
        L_0x003d:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0032 }
            r1.close()
            r4.close()
            return r5
        L_0x0048:
            r4 = move-exception
            r5 = r0
            r0 = r1
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()
        L_0x0050:
            if (r5 == 0) goto L_0x0055
            r5.close()
        L_0x0055:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1fSDK.AFInAppEventParameterName(java.net.HttpURLConnection, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x015b A[Catch:{ Exception -> 0x00fb, all -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x023d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1zSDK<java.lang.String> AFKeystoreWrapper(com.appsflyer.internal.AFc1rSDK r20) throws java.io.IOException {
        /*
            r19 = this;
            java.lang.String r1 = "ms"
            java.lang.String r2 = "\n took "
            java.lang.String r3 = "] "
            java.lang.String r4 = "HTTP: ["
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 0
            byte[] r0 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.<init>()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r11 = r20.afDebugLog()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.append(r11)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r11 = ":"
            r10.append(r11)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r11 = r20.valueOf()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.append(r11)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            byte[] r10 = r20.AFInAppEventType()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            if (r10 == 0) goto L_0x005b
            boolean r11 = r20.afErrorLog()     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            if (r11 == 0) goto L_0x004d
            java.lang.String r10 = "<encrypted>"
            goto L_0x0053
        L_0x0041:
            r0 = move-exception
            r8 = 0
            r10 = r19
            goto L_0x023b
        L_0x0047:
            r0 = move-exception
            r8 = 0
            r10 = r19
            goto L_0x01f7
        L_0x004d:
            java.lang.String r11 = new java.lang.String     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            r10 = r11
        L_0x0053:
            java.lang.String r11 = "\n payload: "
            r9.append(r11)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            r9.append(r10)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
        L_0x005b:
            java.util.Map r10 = r20.AFLogger()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
        L_0x0067:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            if (r11 == 0) goto L_0x0090
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.String r12 = "\n "
            r9.append(r12)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            r9.append(r12)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.String r12 = ": "
            r9.append(r12)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            r9.append(r11)     // Catch:{ Exception -> 0x0047, all -> 0x0041 }
            goto L_0x0067
        L_0x0090:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.<init>(r4)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            int r11 = r20.hashCode()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.append(r11)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.append(r3)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r10.append(r9)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r10 = r20.valueOf()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            r9.<init>(r10)     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Exception -> 0x01f3, all -> 0x01ee }
            java.lang.String r10 = r20.afDebugLog()     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
            r9.setRequestMethod(r10)     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
            boolean r10 = r20.afWarnLog()     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
            if (r10 == 0) goto L_0x00d5
            r9.setUseCaches(r7)     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
            goto L_0x00d5
        L_0x00c9:
            r0 = move-exception
            r10 = r19
        L_0x00cc:
            r8 = r9
            goto L_0x023b
        L_0x00cf:
            r0 = move-exception
            r10 = r19
        L_0x00d2:
            r8 = r9
            goto L_0x01f7
        L_0x00d5:
            boolean r10 = r20.AFLogger$LogLevel()     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
            if (r10 != 0) goto L_0x00de
            r9.setInstanceFollowRedirects(r7)     // Catch:{ Exception -> 0x00cf, all -> 0x00c9 }
        L_0x00de:
            r10 = r19
            int r11 = r10.AFInAppEventType     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r12 = r20.afRDLog()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r13 = -1
            if (r12 == r13) goto L_0x00ea
            r11 = r12
        L_0x00ea:
            r9.setConnectTimeout(r11)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r9.setReadTimeout(r11)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            boolean r11 = r20.afErrorLog()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            if (r11 == 0) goto L_0x00fd
            java.lang.String r11 = "application/octet-stream"
            goto L_0x00ff
        L_0x00f9:
            r0 = move-exception
            goto L_0x00cc
        L_0x00fb:
            r0 = move-exception
            goto L_0x00d2
        L_0x00fd:
            java.lang.String r11 = "application/json"
        L_0x00ff:
            java.lang.String r12 = "Content-Type"
            r9.addRequestProperty(r12, r11)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.Map r11 = r20.AFLogger()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
        L_0x0110:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            if (r12 == 0) goto L_0x012c
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.Object r13 = r12.getKey()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r9.setRequestProperty(r13, r12)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            goto L_0x0110
        L_0x012c:
            r11 = 1
            if (r0 == 0) goto L_0x015f
            r9.setDoOutput(r11)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r12 = "Content-Length"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r13.<init>()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r14 = r0.length     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r13.append(r14)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r9.setRequestProperty(r12, r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0157 }
            java.io.OutputStream r13 = r9.getOutputStream()     // Catch:{ all -> 0x0157 }
            r12.<init>(r13)     // Catch:{ all -> 0x0157 }
            r12.write(r0)     // Catch:{ all -> 0x0154 }
            r12.close()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            goto L_0x015f
        L_0x0154:
            r0 = move-exception
            r8 = r12
            goto L_0x0159
        L_0x0157:
            r0 = move-exception
            r8 = 0
        L_0x0159:
            if (r8 == 0) goto L_0x015e
            r8.close()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
        L_0x015e:
            throw r0     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
        L_0x015f:
            int r0 = r9.getResponseCode()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r0 = r0 / 100
            r12 = 2
            if (r0 != r12) goto L_0x0169
            goto L_0x016a
        L_0x0169:
            r11 = r7
        L_0x016a:
            boolean r0 = r20.afInfoLog()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r12 = ""
            if (r0 == 0) goto L_0x0178
            java.lang.String r0 = AFInAppEventParameterName(r9, r11)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r14 = r0
            goto L_0x0179
        L_0x0178:
            r14 = r12
        L_0x0179:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            long r12 = r12 - r5
            com.appsflyer.internal.AFc1hSDK r0 = new com.appsflyer.internal.AFc1hSDK     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = "response code:"
            r12.<init>(r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r13 = r9.getResponseCode()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = " "
            r12.append(r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = r9.getResponseMessage()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r13 = "\n body:"
            r12.append(r13)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r14)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r2)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            long r7 = r0.AFInAppEventType     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r7)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r12.append(r1)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r12 = r20.hashCode()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r8.append(r12)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r8.append(r3)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r8.append(r7)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            java.util.Map r8 = r9.getHeaderFields()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r8 = 0
            r7.remove(r8)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            com.appsflyer.internal.AFd1zSDK r8 = new com.appsflyer.internal.AFd1zSDK     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            int r15 = r9.getResponseCode()     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r13 = r8
            r16 = r11
            r17 = r7
            r18 = r0
            r13.<init>(r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x00fb, all -> 0x00f9 }
            r9.disconnect()
            return r8
        L_0x01ee:
            r0 = move-exception
            r10 = r19
            r8 = 0
            goto L_0x023b
        L_0x01f3:
            r0 = move-exception
            r10 = r19
            r8 = 0
        L_0x01f7:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x023a }
            long r11 = r11 - r5
            com.appsflyer.internal.AFc1hSDK r5 = new com.appsflyer.internal.AFc1hSDK     // Catch:{ all -> 0x023a }
            r5.<init>(r11)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            java.lang.String r7 = "error: "
            r6.<init>(r7)     // Catch:{ all -> 0x023a }
            r6.append(r0)     // Catch:{ all -> 0x023a }
            r6.append(r2)     // Catch:{ all -> 0x023a }
            long r11 = r5.AFInAppEventType     // Catch:{ all -> 0x023a }
            r6.append(r11)     // Catch:{ all -> 0x023a }
            r6.append(r1)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r2.<init>(r4)     // Catch:{ all -> 0x023a }
            int r4 = r20.hashCode()     // Catch:{ all -> 0x023a }
            r2.append(r4)     // Catch:{ all -> 0x023a }
            r2.append(r3)     // Catch:{ all -> 0x023a }
            r2.append(r1)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x023a }
            r2 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r2)     // Catch:{ all -> 0x023a }
            com.appsflyer.internal.components.network.http.exceptions.HttpException r1 = new com.appsflyer.internal.components.network.http.exceptions.HttpException     // Catch:{ all -> 0x023a }
            r1.<init>(r0, r5)     // Catch:{ all -> 0x023a }
            throw r1     // Catch:{ all -> 0x023a }
        L_0x023a:
            r0 = move-exception
        L_0x023b:
            if (r8 == 0) goto L_0x0240
            r8.disconnect()
        L_0x0240:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1fSDK.AFKeystoreWrapper(com.appsflyer.internal.AFc1rSDK):com.appsflyer.internal.AFd1zSDK");
    }
}
