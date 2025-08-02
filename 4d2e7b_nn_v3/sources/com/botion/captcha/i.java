package com.botion.captcha;

import android.annotation.SuppressLint;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

final class i {
    @SuppressLint({"SdCardPath"})

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f18530a = {"/sdcard/.system_log.trace", "/sdcard/tencent/.DrvZPZQ", "/sdcard/alipay/.Wg83DS3"};

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r8 = f18530a;
        r7 = com.botion.captcha.l.a(new java.io.FileReader(r8[1]));
        r15 = new org.json.JSONObject(new java.lang.String(com.botion.captcha.e.a(android.util.Base64.decode(r7, 2), "VedaT=ZbPq0Zv7Do")));
        com.botion.captcha.h.a(r0, "boc_di", r7);
        a(r7, r8[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0096, code lost:
        return new android.util.Pair<>(r15.getString("gee_id"), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r8 = f18530a;
        r7 = com.botion.captcha.l.a(new java.io.FileReader(r8[2]));
        r14 = new org.json.JSONObject(new java.lang.String(com.botion.captcha.e.a(android.util.Base64.decode(r7, 2), "VedaT=ZbPq0Zv7Do")));
        com.botion.captcha.h.a(r0, "boc_di", r7);
        a(r7, r8[0]);
        a(r7, r8[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00cc, code lost:
        return new android.util.Pair<>(r14.getString("gee_id"), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7 = java.util.UUID.randomUUID().toString();
        r8 = new org.json.JSONObject();
        r8.put("gee_id", r7);
        r8.put("ts", java.lang.System.currentTimeMillis());
        r8.put("ver", "1.0.0");
        r8 = r8.toString();
        r9 = new java.lang.String(com.botion.captcha.e.a());
        r8 = r8.getBytes("utf-8");
        r11 = "VedaT=ZbPq0Zv7Do".getBytes("utf-8");
        r9 = r9.getBytes("utf-8");
        r9 = java.lang.Class.forName(com.botion.captcha.e.a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new java.lang.Class[]{r5}).newInstance(new java.lang.Object[]{r9});
        r11 = java.lang.Class.forName(com.botion.captcha.e.a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new java.lang.Class[]{r5, r4}).newInstance(new java.lang.Object[]{r11, "AES"});
        r12 = java.lang.Class.forName(com.botion.captcha.e.a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        r4 = r12.getMethod("getInstance", new java.lang.Class[]{r4}).invoke(r12, new java.lang.Object[]{"AES/CBC/PKCS5Padding"});
        r12.getMethod("init", new java.lang.Class[]{java.lang.Integer.TYPE, java.security.Key.class, java.security.spec.AlgorithmParameterSpec.class}).invoke(r4, new java.lang.Object[]{1, r11, r9});
        r1 = com.botion.captcha.l.a(android.util.Base64.encode((byte[]) r12.getMethod("doFinal", new java.lang.Class[]{r5}).invoke(r4, new java.lang.Object[]{r8}), 2), "utf-8");
        com.botion.captcha.h.a(r0, "boc_di", r1);
        r0 = f18530a;
        a(r1, r0[0]);
        a(r1, r0[1]);
        a(r1, r0[2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x01b6, code lost:
        return new android.util.Pair<>(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x01b7, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00cd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.util.Pair<java.lang.String, java.lang.String> a(android.content.Context r17) {
        /*
            r0 = r17
            r1 = 3
            r2 = 1
            r3 = 0
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class<byte[]> r5 = byte[].class
            java.lang.String r6 = "boc_di"
            java.lang.String r7 = com.botion.captcha.h.a(r0, r6)
            boolean r8 = com.botion.captcha.h.a(r7)
            r9 = 0
            java.lang.String r10 = "utf-8"
            java.lang.String r11 = "gee_id"
            java.lang.String r12 = "VedaT=ZbPq0Zv7Do"
            r13 = 2
            if (r8 == 0) goto L_0x01bb
            int r7 = android.os.Process.myPid()
            int r8 = android.os.Process.myUid()
            java.lang.String r14 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r7 = r0.checkPermission(r14, r7, r8)
            if (r7 != 0) goto L_0x01b9
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 29
            if (r7 < r8) goto L_0x003a
            boolean r7 = android.os.Environment.isExternalStorageLegacy()
            if (r7 != 0) goto L_0x003a
            return r9
        L_0x003a:
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ Exception -> 0x0066 }
            java.lang.String[] r8 = f18530a     // Catch:{ Exception -> 0x0066 }
            r8 = r8[r3]     // Catch:{ Exception -> 0x0066 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r7 = com.botion.captcha.l.a(r7)     // Catch:{ Exception -> 0x0066 }
            byte[] r8 = android.util.Base64.decode(r7, r13)     // Catch:{ Exception -> 0x0066 }
            byte[] r8 = com.botion.captcha.e.a(r8, r12)     // Catch:{ Exception -> 0x0066 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0066 }
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x0066 }
            r15.<init>(r8)     // Catch:{ Exception -> 0x0066 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x0066 }
            com.botion.captcha.h.a(r0, r6, r7)     // Catch:{ Exception -> 0x0066 }
            android.util.Pair r8 = new android.util.Pair     // Catch:{ Exception -> 0x0066 }
            java.lang.String r14 = r14.getString(r11)     // Catch:{ Exception -> 0x0066 }
            r8.<init>(r14, r7)     // Catch:{ Exception -> 0x0066 }
            return r8
        L_0x0066:
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ Exception -> 0x0097 }
            java.lang.String[] r8 = f18530a     // Catch:{ Exception -> 0x0097 }
            r14 = r8[r2]     // Catch:{ Exception -> 0x0097 }
            r7.<init>(r14)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r7 = com.botion.captcha.l.a(r7)     // Catch:{ Exception -> 0x0097 }
            byte[] r14 = android.util.Base64.decode(r7, r13)     // Catch:{ Exception -> 0x0097 }
            byte[] r14 = com.botion.captcha.e.a(r14, r12)     // Catch:{ Exception -> 0x0097 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x0097 }
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x0097 }
            r9.<init>(r14)     // Catch:{ Exception -> 0x0097 }
            r15.<init>(r9)     // Catch:{ Exception -> 0x0097 }
            com.botion.captcha.h.a(r0, r6, r7)     // Catch:{ Exception -> 0x0097 }
            r8 = r8[r3]     // Catch:{ Exception -> 0x0097 }
            a(r7, r8)     // Catch:{ Exception -> 0x0097 }
            android.util.Pair r8 = new android.util.Pair     // Catch:{ Exception -> 0x0097 }
            java.lang.String r9 = r15.getString(r11)     // Catch:{ Exception -> 0x0097 }
            r8.<init>(r9, r7)     // Catch:{ Exception -> 0x0097 }
            return r8
        L_0x0097:
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ Exception -> 0x00cd }
            java.lang.String[] r8 = f18530a     // Catch:{ Exception -> 0x00cd }
            r9 = r8[r13]     // Catch:{ Exception -> 0x00cd }
            r7.<init>(r9)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r7 = com.botion.captcha.l.a(r7)     // Catch:{ Exception -> 0x00cd }
            byte[] r9 = android.util.Base64.decode(r7, r13)     // Catch:{ Exception -> 0x00cd }
            byte[] r9 = com.botion.captcha.e.a(r9, r12)     // Catch:{ Exception -> 0x00cd }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cd }
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x00cd }
            r15.<init>(r9)     // Catch:{ Exception -> 0x00cd }
            r14.<init>(r15)     // Catch:{ Exception -> 0x00cd }
            com.botion.captcha.h.a(r0, r6, r7)     // Catch:{ Exception -> 0x00cd }
            r9 = r8[r3]     // Catch:{ Exception -> 0x00cd }
            a(r7, r9)     // Catch:{ Exception -> 0x00cd }
            r8 = r8[r2]     // Catch:{ Exception -> 0x00cd }
            a(r7, r8)     // Catch:{ Exception -> 0x00cd }
            android.util.Pair r8 = new android.util.Pair     // Catch:{ Exception -> 0x00cd }
            java.lang.String r9 = r14.getString(r11)     // Catch:{ Exception -> 0x00cd }
            r8.<init>(r9, r7)     // Catch:{ Exception -> 0x00cd }
            return r8
        L_0x00cd:
            java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01b7 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x01b7 }
            r8.<init>()     // Catch:{ Exception -> 0x01b7 }
            r8.put(r11, r7)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r9 = "ts"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b7 }
            r8.put(r9, r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r9 = "ver"
            java.lang.String r11 = "1.0.0"
            r8.put(r9, r11)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x01b7 }
            byte[] r11 = com.botion.captcha.e.a()     // Catch:{ Exception -> 0x01b7 }
            r9.<init>(r11)     // Catch:{ Exception -> 0x01b7 }
            byte[] r8 = r8.getBytes(r10)     // Catch:{ Exception -> 0x01b7 }
            byte[] r11 = r12.getBytes(r10)     // Catch:{ Exception -> 0x01b7 }
            byte[] r9 = r9.getBytes(r10)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r12 = "amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj"
            java.lang.String r12 = com.botion.captcha.e.a(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class[] r14 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x01b7 }
            r14[r3] = r5     // Catch:{ Exception -> 0x01b7 }
            java.lang.reflect.Constructor r12 = r12.getConstructor(r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01b7 }
            r14[r3] = r9     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object r9 = r12.newInstance(r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r12 = "amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw=="
            java.lang.String r12 = com.botion.captcha.e.a(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x01b7 }
            r14[r3] = r5     // Catch:{ Exception -> 0x01b7 }
            r14[r2] = r4     // Catch:{ Exception -> 0x01b7 }
            java.lang.reflect.Constructor r12 = r12.getConstructor(r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x01b7 }
            r14[r3] = r11     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r11 = "AES"
            r14[r2] = r11     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object r11 = r12.newInstance(r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r12 = "amF2YXguY3J5cHRvLkNpcGhlcg=="
            java.lang.String r12 = com.botion.captcha.e.a(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r14 = "getInstance"
            java.lang.Class[] r15 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x01b7 }
            r15[r3] = r4     // Catch:{ Exception -> 0x01b7 }
            java.lang.reflect.Method r4 = r12.getMethod(r14, r15)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r15 = "AES/CBC/PKCS5Padding"
            r14[r3] = r15     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object r4 = r4.invoke(r12, r14)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r14 = "init"
            java.lang.Class[] r15 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class r16 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x01b7 }
            r15[r3] = r16     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class<java.security.Key> r16 = java.security.Key.class
            r15[r2] = r16     // Catch:{ Exception -> 0x01b7 }
            java.lang.Class<java.security.spec.AlgorithmParameterSpec> r16 = java.security.spec.AlgorithmParameterSpec.class
            r15[r13] = r16     // Catch:{ Exception -> 0x01b7 }
            java.lang.reflect.Method r14 = r12.getMethod(r14, r15)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x01b7 }
            r1[r3] = r15     // Catch:{ Exception -> 0x01b7 }
            r1[r2] = r11     // Catch:{ Exception -> 0x01b7 }
            r1[r13] = r9     // Catch:{ Exception -> 0x01b7 }
            r14.invoke(r4, r1)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r1 = "doFinal"
            java.lang.Class[] r9 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x01b7 }
            r9[r3] = r5     // Catch:{ Exception -> 0x01b7 }
            java.lang.reflect.Method r1 = r12.getMethod(r1, r9)     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01b7 }
            r5[r3] = r8     // Catch:{ Exception -> 0x01b7 }
            java.lang.Object r1 = r1.invoke(r4, r5)     // Catch:{ Exception -> 0x01b7 }
            byte[] r1 = (byte[]) r1     // Catch:{ Exception -> 0x01b7 }
            byte[] r1 = android.util.Base64.encode(r1, r13)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String r1 = com.botion.captcha.l.a((byte[]) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x01b7 }
            com.botion.captcha.h.a(r0, r6, r1)     // Catch:{ Exception -> 0x01b7 }
            java.lang.String[] r0 = f18530a     // Catch:{ Exception -> 0x01b7 }
            r3 = r0[r3]     // Catch:{ Exception -> 0x01b7 }
            a(r1, r3)     // Catch:{ Exception -> 0x01b7 }
            r2 = r0[r2]     // Catch:{ Exception -> 0x01b7 }
            a(r1, r2)     // Catch:{ Exception -> 0x01b7 }
            r0 = r0[r13]     // Catch:{ Exception -> 0x01b7 }
            a(r1, r0)     // Catch:{ Exception -> 0x01b7 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ Exception -> 0x01b7 }
            r0.<init>(r7, r1)     // Catch:{ Exception -> 0x01b7 }
            return r0
        L_0x01b7:
            r0 = 0
            goto L_0x01ba
        L_0x01b9:
            r0 = r9
        L_0x01ba:
            return r0
        L_0x01bb:
            byte[] r0 = android.util.Base64.decode(r7, r13)     // Catch:{ Exception -> 0x01d6 }
            byte[] r0 = com.botion.captcha.e.a(r0, r12)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = com.botion.captcha.l.a((byte[]) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x01d6 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d6 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01d6 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r1 = r1.getString(r11)     // Catch:{ Exception -> 0x01d6 }
            r0.<init>(r1, r7)     // Catch:{ Exception -> 0x01d6 }
            return r0
        L_0x01d6:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.botion.captcha.i.a(android.content.Context):android.util.Pair");
    }

    private static void a(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str2);
            l.a(str, (Writer) fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }
}
