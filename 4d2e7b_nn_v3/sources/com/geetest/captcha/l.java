package com.geetest.captcha;

import android.annotation.SuppressLint;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public final class l {
    @SuppressLint({"SdCardPath"})

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f5828a = {"/sdcard/.system_log.trace", "/sdcard/tencent/.DrvZPZQ", "/sdcard/alipay/.Wg83DS3"};

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r9 = f5828a;
        r4 = com.geetest.captcha.n.a(new java.io.FileReader(r9[2]));
        r11 = new org.json.JSONObject(new java.lang.String(com.geetest.captcha.i.a(android.util.Base64.decode(r4, 2), "VedaT=ZbPq0Zv7Do")));
        com.geetest.captcha.i.a(r13, "gt_di", r4);
        a(r4, r9[0]);
        a(r4, r9[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ce, code lost:
        return new android.util.Pair<>(r11.getString("gee_id"), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r4 = java.util.UUID.randomUUID().toString();
        r9 = new org.json.JSONObject();
        r9.put("gee_id", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r9.put("ts", java.lang.System.currentTimeMillis());
        r9.put("ver", "1.0.0");
        r5 = com.geetest.captcha.n.a(android.util.Base64.encode(com.geetest.captcha.i.a(r9.toString(), "VedaT=ZbPq0Zv7Do"), 2), "utf-8");
        com.geetest.captcha.i.a(r13, "gt_di", r5);
        r13 = f5828a;
        a(r5, r13[0]);
        a(r5, r13[1]);
        a(r5, r13[2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
        return new android.util.Pair<>(r4, r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0099 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00cf */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.String, java.lang.String> a(android.content.Context r13) {
        /*
            java.lang.String r0 = "gt_di"
            r1 = 0
            r2 = 0
            java.lang.String r3 = "gt_fp"
            android.content.SharedPreferences r3 = r13.getSharedPreferences(r3, r2)     // Catch:{ Exception -> 0x000f }
            java.lang.String r3 = r3.getString(r0, r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0011
        L_0x000f:
            java.lang.String r3 = "$unknown"
        L_0x0011:
            boolean r4 = com.geetest.captcha.i.b(r3)
            java.lang.String r5 = "utf-8"
            java.lang.String r6 = "gee_id"
            java.lang.String r7 = "VedaT=ZbPq0Zv7Do"
            r8 = 2
            if (r4 == 0) goto L_0x011a
            int r3 = android.os.Process.myPid()
            int r4 = android.os.Process.myUid()
            java.lang.String r9 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r3 = r13.checkPermission(r9, r3, r4)
            if (r3 != 0) goto L_0x0119
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x003b
            boolean r3 = android.os.Environment.isExternalStorageLegacy()
            if (r3 != 0) goto L_0x003b
            return r1
        L_0x003b:
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0067 }
            java.lang.String[] r4 = f5828a     // Catch:{ Exception -> 0x0067 }
            r4 = r4[r2]     // Catch:{ Exception -> 0x0067 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = com.geetest.captcha.n.a(r3)     // Catch:{ Exception -> 0x0067 }
            byte[] r4 = android.util.Base64.decode(r3, r8)     // Catch:{ Exception -> 0x0067 }
            byte[] r4 = com.geetest.captcha.i.a((byte[]) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x0067 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0067 }
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0067 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0067 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0067 }
            com.geetest.captcha.i.a(r13, r0, r3)     // Catch:{ Exception -> 0x0067 }
            android.util.Pair r4 = new android.util.Pair     // Catch:{ Exception -> 0x0067 }
            java.lang.String r9 = r9.getString(r6)     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r9, r3)     // Catch:{ Exception -> 0x0067 }
            return r4
        L_0x0067:
            r3 = 1
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0099 }
            java.lang.String[] r9 = f5828a     // Catch:{ Exception -> 0x0099 }
            r10 = r9[r3]     // Catch:{ Exception -> 0x0099 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r4 = com.geetest.captcha.n.a(r4)     // Catch:{ Exception -> 0x0099 }
            byte[] r10 = android.util.Base64.decode(r4, r8)     // Catch:{ Exception -> 0x0099 }
            byte[] r10 = com.geetest.captcha.i.a((byte[]) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x0099 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0099 }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x0099 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0099 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0099 }
            com.geetest.captcha.i.a(r13, r0, r4)     // Catch:{ Exception -> 0x0099 }
            r9 = r9[r2]     // Catch:{ Exception -> 0x0099 }
            a(r4, r9)     // Catch:{ Exception -> 0x0099 }
            android.util.Pair r9 = new android.util.Pair     // Catch:{ Exception -> 0x0099 }
            java.lang.String r10 = r11.getString(r6)     // Catch:{ Exception -> 0x0099 }
            r9.<init>(r10, r4)     // Catch:{ Exception -> 0x0099 }
            return r9
        L_0x0099:
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x00cf }
            java.lang.String[] r9 = f5828a     // Catch:{ Exception -> 0x00cf }
            r10 = r9[r8]     // Catch:{ Exception -> 0x00cf }
            r4.<init>(r10)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = com.geetest.captcha.n.a(r4)     // Catch:{ Exception -> 0x00cf }
            byte[] r10 = android.util.Base64.decode(r4, r8)     // Catch:{ Exception -> 0x00cf }
            byte[] r10 = com.geetest.captcha.i.a((byte[]) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x00cf }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cf }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x00cf }
            r12.<init>(r10)     // Catch:{ Exception -> 0x00cf }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00cf }
            com.geetest.captcha.i.a(r13, r0, r4)     // Catch:{ Exception -> 0x00cf }
            r10 = r9[r2]     // Catch:{ Exception -> 0x00cf }
            a(r4, r10)     // Catch:{ Exception -> 0x00cf }
            r9 = r9[r3]     // Catch:{ Exception -> 0x00cf }
            a(r4, r9)     // Catch:{ Exception -> 0x00cf }
            android.util.Pair r9 = new android.util.Pair     // Catch:{ Exception -> 0x00cf }
            java.lang.String r10 = r11.getString(r6)     // Catch:{ Exception -> 0x00cf }
            r9.<init>(r10, r4)     // Catch:{ Exception -> 0x00cf }
            return r9
        L_0x00cf:
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0119 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0119 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0119 }
            r9.<init>()     // Catch:{ Exception -> 0x0119 }
            r9.put(r6, r4)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "ts"
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0119 }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = "ver"
            java.lang.String r10 = "1.0.0"
            r9.put(r6, r10)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x0119 }
            byte[] r6 = com.geetest.captcha.i.a((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x0119 }
            byte[] r6 = android.util.Base64.encode(r6, r8)     // Catch:{ Exception -> 0x0119 }
            java.lang.String r5 = com.geetest.captcha.n.a((byte[]) r6, (java.lang.String) r5)     // Catch:{ Exception -> 0x0119 }
            com.geetest.captcha.i.a(r13, r0, r5)     // Catch:{ Exception -> 0x0119 }
            java.lang.String[] r13 = f5828a     // Catch:{ Exception -> 0x0119 }
            r0 = r13[r2]     // Catch:{ Exception -> 0x0119 }
            a(r5, r0)     // Catch:{ Exception -> 0x0119 }
            r0 = r13[r3]     // Catch:{ Exception -> 0x0119 }
            a(r5, r0)     // Catch:{ Exception -> 0x0119 }
            r13 = r13[r8]     // Catch:{ Exception -> 0x0119 }
            a(r5, r13)     // Catch:{ Exception -> 0x0119 }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x0119 }
            r13.<init>(r4, r5)     // Catch:{ Exception -> 0x0119 }
            return r13
        L_0x0119:
            return r1
        L_0x011a:
            byte[] r13 = android.util.Base64.decode(r3, r8)     // Catch:{ Exception -> 0x0135 }
            byte[] r13 = com.geetest.captcha.i.a((byte[]) r13, (java.lang.String) r7)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r13 = com.geetest.captcha.n.a((byte[]) r13, (java.lang.String) r5)     // Catch:{ Exception -> 0x0135 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0135 }
            r0.<init>(r13)     // Catch:{ Exception -> 0x0135 }
            android.util.Pair r13 = new android.util.Pair     // Catch:{ Exception -> 0x0135 }
            java.lang.String r0 = r0.getString(r6)     // Catch:{ Exception -> 0x0135 }
            r13.<init>(r0, r3)     // Catch:{ Exception -> 0x0135 }
            return r13
        L_0x0135:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.l.a(android.content.Context):android.util.Pair");
    }

    public static void a(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str2);
            n.a(str, (Writer) fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }
}
