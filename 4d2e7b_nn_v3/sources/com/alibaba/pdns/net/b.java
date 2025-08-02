package com.alibaba.pdns.net;

import android.text.TextUtils;
import com.alibaba.pdns.model.e;
import com.alibaba.pdns.model.f;
import com.alibaba.pdns.o;
import com.alibaba.pdns.u.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18081b = "b";

    /* renamed from: a  reason: collision with root package name */
    private int f18082a = 3;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r18, java.lang.String r19, boolean r20, java.lang.String r21, com.alibaba.pdns.model.e r22, int r23) {
        /*
            r17 = this;
            if (r22 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r22.b()     // Catch:{ Exception -> 0x0079, Error -> 0x0075 }
            java.lang.String r1 = "Ts is expired"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x0079, Error -> 0x0075 }
            if (r1 == 0) goto L_0x0066
            int r9 = r23 + 1
            r10 = r17
            int r0 = r10.f18082a     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            if (r9 <= r0) goto L_0x0018
            return
        L_0x0018:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            com.alibaba.pdns.model.f r3 = com.alibaba.pdns.f.c((java.lang.Object) r0)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            if (r3 == 0) goto L_0x0082
            java.lang.String r12 = r3.f18049e     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            if (r0 == 0) goto L_0x0082
            long r15 = r22.a()     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            r11 = r19
            r13 = r21
            r14 = r20
            java.lang.String r2 = com.alibaba.pdns.f.a(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            if (r0 != 0) goto L_0x003f
            return
        L_0x003f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            r0.<init>()     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            java.lang.String r1 = "reurl:"
            r0.append(r1)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            r0.append(r2)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            r4 = 0
            r1 = r17
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            goto L_0x0082
        L_0x0062:
            r0 = move-exception
            goto L_0x007b
        L_0x0064:
            r0 = move-exception
            goto L_0x007b
        L_0x0066:
            r10 = r17
            java.lang.String r1 = "User is unauthorized"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            if (r0 == 0) goto L_0x0071
            goto L_0x0082
        L_0x0071:
            r17.a(r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0064, Error -> 0x0062 }
            goto L_0x0082
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            r10 = r17
            goto L_0x007b
        L_0x0079:
            r0 = move-exception
            goto L_0x0076
        L_0x007b:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0082
            r0.printStackTrace()
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.b.b(java.lang.String, java.lang.String, boolean, java.lang.String, com.alibaba.pdns.model.e, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(java.lang.String r15, com.alibaba.pdns.model.f r16, java.util.HashMap<java.lang.String, java.lang.String> r17, java.lang.String r18, boolean r19, java.lang.String r20, com.alibaba.pdns.model.e r21, int r22) {
        /*
            r14 = this;
            r0 = r16
            r9 = r18
            r10 = r20
            boolean r1 = com.alibaba.pdns.e.a((java.lang.String) r15)
            r11 = 0
            if (r1 != 0) goto L_0x000e
            return r11
        L_0x000e:
            boolean r1 = com.alibaba.pdns.e.a((java.lang.String) r18)
            if (r1 != 0) goto L_0x0015
            return r11
        L_0x0015:
            if (r21 == 0) goto L_0x0023
            com.alibaba.pdns.model.b r1 = r21.d()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r12 = r1
            goto L_0x0024
        L_0x001d:
            r0 = move-exception
            goto L_0x00d8
        L_0x0020:
            r0 = move-exception
            goto L_0x00d8
        L_0x0023:
            r12 = r11
        L_0x0024:
            java.lang.String r13 = r0.f18049e     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            com.alibaba.pdns.net.d r1 = com.alibaba.pdns.net.d.a()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r2 = r15
            r3 = r13
            r4 = r18
            r5 = r20
            r6 = r16
            r7 = r21
            r8 = r12
            com.alibaba.pdns.model.e r11 = r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            if (r11 == 0) goto L_0x00df
            if (r12 == 0) goto L_0x00df
            int r1 = r11.e()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            com.alibaba.pdns.g.a((com.alibaba.pdns.model.e) r11, (int) r1)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            if (r1 <= 0) goto L_0x00df
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 == r2) goto L_0x00bc
            r0 = 401(0x191, float:5.62E-43)
            java.lang.String r2 = "se"
            if (r1 == r0) goto L_0x0095
            r0 = 500(0x1f4, float:7.0E-43)
            if (r1 == r0) goto L_0x006e
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.incrementAndGet()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.String r1 = com.alibaba.pdns.o.a(r13, r9, r10, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.concurrent.atomic.AtomicInteger r2 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            long r2 = r2.longValue()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            goto L_0x00df
        L_0x006e:
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.incrementAndGet()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.String r1 = com.alibaba.pdns.o.a(r13, r9, r10, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.concurrent.atomic.AtomicInteger r2 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0 = r14
            r1 = r15
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r11
            r6 = r22
            r0.a(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            goto L_0x00df
        L_0x0095:
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.incrementAndGet()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.String r1 = com.alibaba.pdns.o.a(r13, r9, r10, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.concurrent.atomic.AtomicInteger r2 = r12.f17993c     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r0 = r14
            r1 = r15
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r11
            r6 = r22
            r0.b(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            goto L_0x00df
        L_0x00bc:
            java.lang.String r1 = "c"
            java.lang.String r1 = com.alibaba.pdns.o.a(r13, r9, r10, r1)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            float r2 = r11.c()     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.util.Map<java.lang.String, java.lang.Object> r3 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.Float r4 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            r3.put(r1, r4)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            com.alibaba.pdns.f.a((com.alibaba.pdns.model.f) r0, (float) r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            java.lang.String r0 = "ne"
            com.alibaba.pdns.f.b(r13, r9, r10, r0)     // Catch:{ Exception -> 0x0020, Error -> 0x001d }
            goto L_0x00df
        L_0x00d8:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x00df
            r0.printStackTrace()
        L_0x00df:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.b.a(java.lang.String, com.alibaba.pdns.model.f, java.util.HashMap, java.lang.String, boolean, java.lang.String, com.alibaba.pdns.model.e, int):java.lang.Object");
    }

    private void a(String str, String str2, boolean z10, String str3, e eVar, int i10) {
        f a10;
        int i11 = i10 + 1;
        int i12 = this.f18082a;
        if (i11 <= i12) {
            if (i11 < i12) {
                f c10 = com.alibaba.pdns.f.c((Object) Integer.valueOf(i11));
                if (c10 != null) {
                    String str4 = c10.f18049e;
                    if (com.alibaba.pdns.e.a(str4)) {
                        String b10 = o.b(str4, (String) null, str);
                        a.b("reLoad", b10);
                        a(b10, c10, (HashMap<String, String>) null, str2, z10, str3, eVar, i11);
                    }
                }
            } else if (i11 == i12 && (a10 = com.alibaba.pdns.f.a(com.alibaba.pdns.f.M)) != null) {
                String str5 = a10.f18049e;
                if (com.alibaba.pdns.e.a(str5)) {
                    String b11 = o.b(str5, (String) null, str);
                    a.b("reLoad", b11);
                    a(b11, a10, (HashMap<String, String>) null, str2, z10, str3, eVar, i11);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d8, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d9, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ee, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ef, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0114, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011d, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0122, code lost:
        if (com.alibaba.pdns.u.a.f18279a != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0124, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0129, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012c, code lost:
        if (com.alibaba.pdns.u.a.f18279a != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012e, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012f, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x013b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0140, code lost:
        if (com.alibaba.pdns.u.a.f18279a != false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0142, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0146, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0149, code lost:
        if (com.alibaba.pdns.u.a.f18279a != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014b, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d8 A[Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0114 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0119 A[SYNTHETIC, Splitter:B:52:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0137 A[SYNTHETIC, Splitter:B:66:0x0137] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            r0 = 1
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "上传json:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            com.alibaba.pdns.u.a.a((java.lang.String) r2)
            r2 = 0
            java.lang.String r3 = "TLS"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            com.alibaba.pdns.net.HttpTrustManager r4 = new com.alibaba.pdns.net.HttpTrustManager     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.<init>()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            javax.net.ssl.TrustManager[] r5 = new javax.net.ssl.TrustManager[r0]     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r5[r1] = r4     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.security.SecureRandom r4 = new java.security.SecureRandom     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.<init>()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.init(r2, r5, r4)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            com.alibaba.pdns.net.HttpsNotCheckVerifier r3 = new com.alibaba.pdns.net.HttpsNotCheckVerifier     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.<init>()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.<init>(r6)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.setDoOutput(r0)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.setDoInput(r0)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.setUseCaches(r1)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = "Connection"
            java.lang.String r5 = "Keep-Alive"
            r3.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = "Charset"
            java.lang.String r5 = "UTF-8"
            r3.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json; charset=UTF-8"
            r3.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = "accept"
            java.lang.String r5 = "application/json"
            r3.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            if (r7 == 0) goto L_0x0099
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            if (r4 != 0) goto L_0x0099
            byte[] r4 = r7.getBytes()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r5 = "Content-Length"
            int r4 = r4.length     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r3.setRequestProperty(r5, r4)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.write(r7)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.flush()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.close()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
        L_0x0099:
            int r7 = r3.getResponseCode()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4 = 200(0xc8, float:2.8E-43)
            if (r7 != r4) goto L_0x00f6
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.io.InputStream r3 = r3.getInputStream()     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r4.<init>(r3)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            r7.<init>(r4)     // Catch:{ Exception -> 0x010f, Error -> 0x010d }
            java.lang.String r2 = r7.readLine()     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            r3.<init>()     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            java.lang.String r4 = "上传json结果:"
            r3.append(r4)     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            r3.append(r2)     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            com.alibaba.pdns.u.a.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00f1, Error -> 0x00ee, all -> 0x00d8 }
            float r1 = a(r2)     // Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }
            if (r6 == 0) goto L_0x00e0
            java.lang.String r2 = "https://dnsrepo-pub.alibaba.com/api/internet/putTermData"
            boolean r2 = r6.equals(r2)     // Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }
            if (r2 == 0) goto L_0x00e0
            com.alibaba.pdns.g.f17939f = r1     // Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }
            goto L_0x00ec
        L_0x00d8:
            r6 = move-exception
            r2 = r7
            goto L_0x0135
        L_0x00dc:
            r6 = move-exception
            goto L_0x00f3
        L_0x00de:
            r6 = move-exception
            goto L_0x00f3
        L_0x00e0:
            if (r6 == 0) goto L_0x00ec
            java.lang.String r2 = "https://dnsrepo-pub.alibaba.com/api/internet/putTermStatusData"
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }
            if (r6 == 0) goto L_0x00ec
            com.alibaba.pdns.g.f17940g = r1     // Catch:{ Exception -> 0x00de, Error -> 0x00dc, all -> 0x00d8 }
        L_0x00ec:
            r2 = r7
            goto L_0x00f7
        L_0x00ee:
            r6 = move-exception
        L_0x00ef:
            r0 = r1
            goto L_0x00f3
        L_0x00f1:
            r6 = move-exception
            goto L_0x00ef
        L_0x00f3:
            r2 = r7
            r1 = r0
            goto L_0x0110
        L_0x00f6:
            r0 = r1
        L_0x00f7:
            if (r2 == 0) goto L_0x0134
            r2.close()     // Catch:{ IOException -> 0x0105, Exception -> 0x00ff, Error -> 0x00fd }
            goto L_0x0134
        L_0x00fd:
            r6 = move-exception
            goto L_0x0100
        L_0x00ff:
            r6 = move-exception
        L_0x0100:
            boolean r7 = com.alibaba.pdns.u.a.f18279a
            if (r7 == 0) goto L_0x0134
            goto L_0x0125
        L_0x0105:
            r6 = move-exception
            boolean r7 = com.alibaba.pdns.u.a.f18279a
            if (r7 == 0) goto L_0x0134
            goto L_0x012f
        L_0x010b:
            r6 = move-exception
            goto L_0x0135
        L_0x010d:
            r6 = move-exception
            goto L_0x0110
        L_0x010f:
            r6 = move-exception
        L_0x0110:
            boolean r7 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x010b }
            if (r7 == 0) goto L_0x0117
            r6.printStackTrace()     // Catch:{ all -> 0x010b }
        L_0x0117:
            if (r2 == 0) goto L_0x0133
            r2.close()     // Catch:{ IOException -> 0x0129, Exception -> 0x011f, Error -> 0x011d }
            goto L_0x0133
        L_0x011d:
            r6 = move-exception
            goto L_0x0120
        L_0x011f:
            r6 = move-exception
        L_0x0120:
            boolean r7 = com.alibaba.pdns.u.a.f18279a
            if (r7 == 0) goto L_0x0133
            r0 = r1
        L_0x0125:
            r6.printStackTrace()
            goto L_0x0134
        L_0x0129:
            r6 = move-exception
            boolean r7 = com.alibaba.pdns.u.a.f18279a
            if (r7 == 0) goto L_0x0133
            r0 = r1
        L_0x012f:
            r6.printStackTrace()
            goto L_0x0134
        L_0x0133:
            r0 = r1
        L_0x0134:
            return r0
        L_0x0135:
            if (r2 == 0) goto L_0x014e
            r2.close()     // Catch:{ IOException -> 0x0146, Exception -> 0x013d, Error -> 0x013b }
            goto L_0x014e
        L_0x013b:
            r7 = move-exception
            goto L_0x013e
        L_0x013d:
            r7 = move-exception
        L_0x013e:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x014e
            r7.printStackTrace()
            goto L_0x014e
        L_0x0146:
            r7 = move-exception
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x014e
            r7.printStackTrace()
        L_0x014e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.b.a(java.lang.String, java.lang.String):boolean");
    }

    private static float a(String str) {
        String optString;
        if (str == null) {
            return 1.0f;
        }
        try {
            if (TextUtils.equals(str, "")) {
                return 1.0f;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data") || (optString = new JSONObject(jSONObject.optString("data")).optString("reportFrequency")) == null || optString.isEmpty()) {
                return 1.0f;
            }
            return Float.parseFloat(optString);
        } catch (JSONException e10) {
            if (!a.f18279a) {
                return 1.0f;
            }
            e10.printStackTrace();
            return 1.0f;
        } catch (Error | Exception e11) {
            if (!a.f18279a) {
                return 1.0f;
            }
            e11.printStackTrace();
            return 1.0f;
        }
    }
}
