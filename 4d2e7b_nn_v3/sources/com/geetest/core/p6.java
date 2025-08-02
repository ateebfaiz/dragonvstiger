package com.geetest.core;

public class p6 {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final p6 f6139a = new p6();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: byte[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ae, code lost:
        if (r1 == null) goto L_0x00b3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(com.geetest.core.m6<T> r10, com.geetest.core.s6<T> r11) {
        /*
            r9 = this;
            java.lang.String r0 = " Url: "
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Thread r1 = r1.getThread()
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00bd
            r1 = 0
            org.json.JSONObject r2 = r10.c()     // Catch:{ Exception -> 0x0020 }
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0026
        L_0x0020:
            r2 = move-exception
            goto L_0x002b
        L_0x0022:
            java.lang.String r2 = r10.d()     // Catch:{ Exception -> 0x0020 }
        L_0x0026:
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x0020 }
            goto L_0x002f
        L_0x002b:
            r2.printStackTrace()
            r2 = r1
        L_0x002f:
            java.lang.String r3 = r10.f6081a
            boolean r4 = r10.b()
            java.util.Map r5 = r10.a()
            android.net.Network r6 = r10.f6082b
            int r7 = r10.f6083c
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0051 }
            r8.<init>()     // Catch:{ Exception -> 0x0051 }
            java.net.HttpURLConnection r1 = com.geetest.core.c.a((java.lang.String) r3, (android.net.Network) r6, (java.lang.StringBuffer) r8)     // Catch:{ Exception -> 0x0051 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x00b3
            goto L_0x00b0
        L_0x004f:
            r10 = move-exception
            goto L_0x00b7
        L_0x0051:
            r2 = move-exception
            goto L_0x0093
        L_0x0053:
            com.geetest.core.c.a(r1, r4, r5, r7)     // Catch:{ Exception -> 0x0051 }
            if (r4 == 0) goto L_0x006a
            if (r2 == 0) goto L_0x006a
            int r4 = r2.length     // Catch:{ Exception -> 0x0051 }
            if (r4 <= 0) goto L_0x006a
            java.io.OutputStream r4 = r1.getOutputStream()     // Catch:{ Exception -> 0x0051 }
            r4.write(r2)     // Catch:{ Exception -> 0x0051 }
            r4.flush()     // Catch:{ Exception -> 0x0051 }
            r4.close()     // Catch:{ Exception -> 0x0051 }
        L_0x006a:
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x0051 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 != r4) goto L_0x007b
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x0051 }
            java.lang.String r0 = com.geetest.core.c.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0051 }
            goto L_0x00b0
        L_0x007b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0051 }
            r4.<init>()     // Catch:{ Exception -> 0x0051 }
            r4.append(r0)     // Catch:{ Exception -> 0x0051 }
            r4.append(r3)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r5 = ", ResponseCode: "
            r4.append(r5)     // Catch:{ Exception -> 0x0051 }
            r4.append(r2)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0051 }
            goto L_0x00b0
        L_0x0093:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r4.<init>()     // Catch:{ all -> 0x004f }
            r4.append(r0)     // Catch:{ all -> 0x004f }
            r4.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = ", Error: "
            r4.append(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x004f }
            r4.append(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x00b3
        L_0x00b0:
            r1.disconnect()
        L_0x00b3:
            r10.a(r0, r11)
            return
        L_0x00b7:
            if (r1 == 0) goto L_0x00bc
            r1.disconnect()
        L_0x00bc:
            throw r10
        L_0x00bd:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r11 = "Should not call GeeGateway on main thread."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.p6.a(com.geetest.core.m6, com.geetest.core.s6):void");
    }
}
