package com.appsflyer.internal;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class AFc1iSDK {
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK((DefaultConstructorMarker) null);
    public static String valueOf = "https://%smonitorsdk.%s/remote-debug/exception-manager";
    public int AFInAppEventParameterName;
    public Map<String, String> AFInAppEventType;
    public byte[] AFKeystoreWrapper;

    public static final class AFa1wSDK {
        private AFa1wSDK() {
        }

        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFc1iSDK(byte[] bArr, Map<String, String> map, int i10) {
        m.f(bArr, "");
        this.AFKeystoreWrapper = bArr;
        this.AFInAppEventType = map;
        this.AFInAppEventParameterName = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0185, code lost:
        if (r10 == null) goto L_0x0187;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AFInAppEventType() {
        /*
            r21 = this;
            r1 = r21
            r0 = 1
            r2 = 0
            java.lang.String r3 = "\n\ttook "
            java.lang.String r4 = "[Exception Manager]: "
            java.lang.String r5 = "] "
            java.lang.String r6 = "HTTP: ["
            java.lang.String r7 = ""
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            java.lang.String r11 = valueOf     // Catch:{ all -> 0x01eb }
            com.appsflyer.AppsFlyerLib r12 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch:{ all -> 0x01eb }
            java.lang.String r12 = r12.getHostPrefix()     // Catch:{ all -> 0x01eb }
            com.appsflyer.internal.AFb1xSDK r13 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()     // Catch:{ all -> 0x01eb }
            java.lang.String r13 = r13.getHostName()     // Catch:{ all -> 0x01eb }
            r14 = 2
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ all -> 0x01eb }
            r14[r2] = r12     // Catch:{ all -> 0x01eb }
            r14[r0] = r13     // Catch:{ all -> 0x01eb }
            java.lang.String r11 = java.lang.String.format(r11, r14)     // Catch:{ all -> 0x01eb }
            kotlin.jvm.internal.m.e(r11, r7)     // Catch:{ all -> 0x01eb }
            kotlin.jvm.internal.m.f(r11, r7)     // Catch:{ all -> 0x01eb }
            java.net.URL r12 = new java.net.URL     // Catch:{ all -> 0x01eb }
            r12.<init>(r11)     // Catch:{ all -> 0x01eb }
            java.net.URLConnection r11 = r12.openConnection()     // Catch:{ all -> 0x01eb }
            if (r11 == 0) goto L_0x01ed
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x01eb }
            java.lang.String r10 = "POST"
            r11.setRequestMethod(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r12.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r13 = r11.getRequestMethod()     // Catch:{ all -> 0x00b3 }
            r12.append(r13)     // Catch:{ all -> 0x00b3 }
            r13 = 58
            r12.append(r13)     // Catch:{ all -> 0x00b3 }
            java.net.URL r13 = r11.getURL()     // Catch:{ all -> 0x00b3 }
            r12.append(r13)     // Catch:{ all -> 0x00b3 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00b3 }
            r10.<init>(r12)     // Catch:{ all -> 0x00b3 }
            java.lang.String r12 = "\n length: "
            r10.append(r12)     // Catch:{ all -> 0x00b3 }
            java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x00b3 }
            byte[] r13 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x00b3 }
            java.nio.charset.Charset r14 = kotlin.text.d.f797b     // Catch:{ all -> 0x00b3 }
            r12.<init>(r13, r14)     // Catch:{ all -> 0x00b3 }
            int r12 = r12.length()     // Catch:{ all -> 0x00b3 }
            r10.append(r12)     // Catch:{ all -> 0x00b3 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r1.AFInAppEventType     // Catch:{ all -> 0x00b3 }
            if (r12 == 0) goto L_0x00b7
            java.util.Set r12 = r12.entrySet()     // Catch:{ all -> 0x00b3 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00b3 }
        L_0x008a:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x00b3 }
            if (r13 == 0) goto L_0x00b7
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x00b3 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = "\n "
            r10.append(r14)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00b3 }
            r10.append(r14)     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = ": "
            r10.append(r14)     // Catch:{ all -> 0x00b3 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x00b3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00b3 }
            r10.append(r13)     // Catch:{ all -> 0x00b3 }
            goto L_0x008a
        L_0x00b3:
            r0 = move-exception
            r10 = r11
            goto L_0x01f5
        L_0x00b7:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r12.<init>(r6)     // Catch:{ all -> 0x00b3 }
            int r13 = r11.hashCode()     // Catch:{ all -> 0x00b3 }
            r12.append(r13)     // Catch:{ all -> 0x00b3 }
            r12.append(r5)     // Catch:{ all -> 0x00b3 }
            r12.append(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00b3 }
            kotlin.jvm.internal.m.f(r10, r7)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = r4.concat(r10)     // Catch:{ all -> 0x00b3 }
            com.appsflyer.AFLogger.afRDLog(r10)     // Catch:{ all -> 0x00b3 }
            r11.setInstanceFollowRedirects(r2)     // Catch:{ all -> 0x00b3 }
            r11.setUseCaches(r2)     // Catch:{ all -> 0x00b3 }
            int r10 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x00b3 }
            r11.setReadTimeout(r10)     // Catch:{ all -> 0x00b3 }
            int r10 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x00b3 }
            r11.setConnectTimeout(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = "Content-Type"
            java.lang.String r12 = "application/json"
            r11.addRequestProperty(r10, r12)     // Catch:{ all -> 0x00b3 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.AFInAppEventType     // Catch:{ all -> 0x00b3 }
            if (r10 == 0) goto L_0x011a
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x00b3 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00b3 }
        L_0x00fe:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x00b3 }
            if (r12 == 0) goto L_0x011a
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x00b3 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x00b3 }
            java.lang.Object r13 = r12.getKey()     // Catch:{ all -> 0x00b3 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00b3 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x00b3 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00b3 }
            r11.addRequestProperty(r13, r12)     // Catch:{ all -> 0x00b3 }
            goto L_0x00fe
        L_0x011a:
            r11.setDoOutput(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = "Content-Length"
            byte[] r10 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x00b3 }
            int r10 = r10.length     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00b3 }
            r11.setRequestProperty(r0, r10)     // Catch:{ all -> 0x00b3 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x0139 }
            kotlin.jvm.internal.m.e(r0, r7)     // Catch:{ all -> 0x0139 }
            boolean r10 = r0 instanceof java.io.BufferedOutputStream     // Catch:{ all -> 0x0139 }
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x013c
            java.io.BufferedOutputStream r0 = (java.io.BufferedOutputStream) r0     // Catch:{ all -> 0x0139 }
            goto L_0x0142
        L_0x0139:
            r0 = move-exception
            goto L_0x01ea
        L_0x013c:
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0139 }
            r10.<init>(r0, r12)     // Catch:{ all -> 0x0139 }
            r0 = r10
        L_0x0142:
            byte[] r10 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0139 }
            r0.write(r10)     // Catch:{ all -> 0x0139 }
            r0.close()     // Catch:{ all -> 0x00b3 }
            boolean r0 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0155
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x00b3 }
            goto L_0x0159
        L_0x0155:
            java.io.InputStream r0 = r11.getErrorStream()     // Catch:{ all -> 0x00b3 }
        L_0x0159:
            if (r0 == 0) goto L_0x0187
            kotlin.jvm.internal.m.e(r0, r7)     // Catch:{ all -> 0x00b3 }
            java.nio.charset.Charset r10 = kotlin.text.d.f797b     // Catch:{ all -> 0x00b3 }
            java.io.InputStreamReader r13 = new java.io.InputStreamReader     // Catch:{ all -> 0x00b3 }
            r13.<init>(r0, r10)     // Catch:{ all -> 0x00b3 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x00b3 }
            r0.<init>(r13, r12)     // Catch:{ all -> 0x00b3 }
            java.util.List r10 = tb.o.e(r0)     // Catch:{ all -> 0x00b3 }
            r12 = r10
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ all -> 0x00b3 }
            r19 = 63
            r20 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.String r10 = kotlin.collections.r.f0(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x00b3 }
            r0.close()     // Catch:{ all -> 0x00b3 }
            if (r10 != 0) goto L_0x0188
        L_0x0187:
            r10 = r7
        L_0x0188:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b3 }
            long r12 = r12 - r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = "response code:"
            r0.<init>(r14)     // Catch:{ all -> 0x00b3 }
            int r14 = r11.getResponseCode()     // Catch:{ all -> 0x00b3 }
            r0.append(r14)     // Catch:{ all -> 0x00b3 }
            r14 = 32
            r0.append(r14)     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = r11.getResponseMessage()     // Catch:{ all -> 0x00b3 }
            r0.append(r14)     // Catch:{ all -> 0x00b3 }
            java.lang.String r14 = "\n\tbody:"
            r0.append(r14)     // Catch:{ all -> 0x00b3 }
            r0.append(r10)     // Catch:{ all -> 0x00b3 }
            r0.append(r3)     // Catch:{ all -> 0x00b3 }
            r0.append(r12)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = "ms"
            r0.append(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r10.<init>(r6)     // Catch:{ all -> 0x00b3 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x00b3 }
            r10.append(r12)     // Catch:{ all -> 0x00b3 }
            r10.append(r5)     // Catch:{ all -> 0x00b3 }
            r10.append(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x00b3 }
            kotlin.jvm.internal.m.f(r0, r7)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x00b3 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x00b3 }
            boolean r2 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName((java.net.HttpURLConnection) r11)     // Catch:{ all -> 0x00b3 }
            r11.disconnect()
            goto L_0x0249
        L_0x01ea:
            throw r0     // Catch:{ all -> 0x00b3 }
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f5
        L_0x01ed:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x01eb }
            java.lang.String r11 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r11)     // Catch:{ all -> 0x01eb }
            throw r0     // Catch:{ all -> 0x01eb }
        L_0x01f5:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0226 }
            long r11 = r11 - r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0226 }
            java.lang.String r9 = "error: "
            r8.<init>(r9)     // Catch:{ all -> 0x0226 }
            r8.append(r0)     // Catch:{ all -> 0x0226 }
            r8.append(r3)     // Catch:{ all -> 0x0226 }
            r8.append(r11)     // Catch:{ all -> 0x0226 }
            java.lang.String r3 = "ms\n\t"
            r8.append(r3)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0226 }
            r8.append(r0)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0226 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0226 }
            r3.<init>(r6)     // Catch:{ all -> 0x0226 }
            if (r10 == 0) goto L_0x0228
            int r6 = r10.hashCode()     // Catch:{ all -> 0x0226 }
            goto L_0x0229
        L_0x0226:
            r0 = move-exception
            goto L_0x024a
        L_0x0228:
            r6 = r2
        L_0x0229:
            r3.append(r6)     // Catch:{ all -> 0x0226 }
            r3.append(r5)     // Catch:{ all -> 0x0226 }
            r3.append(r0)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0226 }
            kotlin.jvm.internal.m.f(r0, r7)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0226 }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x0226 }
            com.appsflyer.AFLogger.afRDLog(r0)     // Catch:{ all -> 0x0226 }
            if (r10 == 0) goto L_0x0249
            r10.disconnect()
        L_0x0249:
            return r2
        L_0x024a:
            if (r10 == 0) goto L_0x024f
            r10.disconnect()
        L_0x024f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1iSDK.AFInAppEventType():boolean");
    }
}
