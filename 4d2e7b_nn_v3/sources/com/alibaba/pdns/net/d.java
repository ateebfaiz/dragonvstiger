package com.alibaba.pdns.net;

import com.alibaba.pdns.f;
import com.alibaba.pdns.model.b;
import com.alibaba.pdns.o;
import com.alibaba.pdns.u.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f18098a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile HttpsHostnameVerifier f18099b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final int f18100c = 5000;

    /* renamed from: d  reason: collision with root package name */
    private static final int f18101d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private static final String f18102e = "dns.alidns.com";

    /* renamed from: f  reason: collision with root package name */
    public static final String f18103f = "c";

    /* renamed from: g  reason: collision with root package name */
    public static final String f18104g = "se";

    /* renamed from: h  reason: collision with root package name */
    public static final String f18105h = "ne";

    /* renamed from: i  reason: collision with root package name */
    public static final String f18106i = "Cv";

    /* renamed from: j  reason: collision with root package name */
    public static final String f18107j = "S";

    private d() {
        f18099b = new HttpsHostnameVerifier(f18102e);
    }

    public static d a() {
        if (f18098a == null) {
            synchronized (d.class) {
                try {
                    if (f18098a == null) {
                        f18098a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18098a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.HttpURLConnection b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x004a, Error -> 0x0045 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x004a, Error -> 0x0045 }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x004a, Error -> 0x0045 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x004a, Error -> 0x0045 }
            if (r4 == 0) goto L_0x0053
            java.lang.String r0 = "GET"
            r4.setRequestMethod(r0)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            r0 = 0
            r4.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            r0 = 5000(0x1388, float:7.006E-42)
            r4.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            r4.setReadTimeout(r0)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "Keep-Alive"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            java.lang.String r0 = "Charset"
            java.lang.String r1 = "UTF-8"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            java.lang.String r0 = "Host"
            java.lang.String r1 = "dns.alidns.com"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            boolean r0 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            if (r0 == 0) goto L_0x0053
            r0 = r4
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            com.alibaba.pdns.net.HttpsHostnameVerifier r1 = f18099b     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x0043, Error -> 0x0041 }
            goto L_0x0053
        L_0x0041:
            r0 = move-exception
            goto L_0x004c
        L_0x0043:
            r0 = move-exception
            goto L_0x004c
        L_0x0045:
            r4 = move-exception
        L_0x0046:
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x004c
        L_0x004a:
            r4 = move-exception
            goto L_0x0046
        L_0x004c:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0053
            r0.printStackTrace()
        L_0x0053:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.d.b(java.lang.String):java.net.HttpURLConnection");
    }

    private HttpURLConnection c(String str) {
        HttpURLConnection httpURLConnection;
        Throwable e10;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{new HttpTrustManager()}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HttpsNotCheckVerifier());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
            } catch (Error | Exception e11) {
                e10 = e11;
            }
        } catch (Error | Exception e12) {
            e10 = e12;
            httpURLConnection = null;
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection a(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0062, Error -> 0x005d }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0062, Error -> 0x005d }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x0062, Error -> 0x005d }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0062, Error -> 0x005d }
            if (r4 == 0) goto L_0x006b
            java.lang.String r0 = "POST"
            r4.setRequestMethod(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r0 = 1
            r4.setDoOutput(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r4.setDoInput(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r0 = 0
            r4.setUseCaches(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r4.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r0 = 5000(0x1388, float:7.006E-42)
            r4.setConnectTimeout(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r4.setReadTimeout(r0)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            java.lang.String r0 = "Accept"
            java.lang.String r1 = "*/*"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "keep-alive"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            java.lang.String r0 = "Charset"
            java.lang.String r1 = "UTF-8"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "application/json; charset=UTF-8"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            java.lang.String r0 = "Host"
            java.lang.String r1 = "dns.alidns.com"
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            boolean r0 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            if (r0 == 0) goto L_0x006b
            r0 = r4
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            com.alibaba.pdns.net.HttpsHostnameVerifier r1 = f18099b     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x005b, Error -> 0x0059 }
            goto L_0x006b
        L_0x0059:
            r0 = move-exception
            goto L_0x0064
        L_0x005b:
            r0 = move-exception
            goto L_0x0064
        L_0x005d:
            r4 = move-exception
        L_0x005e:
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0064
        L_0x0062:
            r4 = move-exception
            goto L_0x005e
        L_0x0064:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x006b
            r0.printStackTrace()
        L_0x006b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.d.a(java.lang.String):java.net.HttpURLConnection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (com.alibaba.pdns.u.a.f18279a == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0066, code lost:
        if (com.alibaba.pdns.u.a.f18279a == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0068, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[Catch:{ all -> 0x0016 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058 A[SYNTHETIC, Splitter:B:33:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[Catch:{ IOException -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0073 A[SYNTHETIC, Splitter:B:46:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007b A[Catch:{ IOException -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.net.HttpURLConnection r4, int r5, com.alibaba.pdns.model.b r6) {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r5 == r1) goto L_0x001c
            java.io.InputStream r5 = r4.getErrorStream()     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            if (r6 == 0) goto L_0x0020
            java.util.concurrent.atomic.AtomicInteger r6 = r6.f17992b     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            r6.incrementAndGet()     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            goto L_0x0020
        L_0x0016:
            r5 = move-exception
            goto L_0x0070
        L_0x0018:
            r5 = move-exception
            goto L_0x004f
        L_0x001a:
            r5 = move-exception
            goto L_0x004f
        L_0x001c:
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
        L_0x0020:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x001a, Error -> 0x0018 }
        L_0x002a:
            java.lang.String r5 = r6.readLine()     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            if (r5 == 0) goto L_0x003f
            r0.append(r5)     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            java.lang.String r5 = "\n"
            r0.append(r5)     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            goto L_0x002a
        L_0x0039:
            r5 = move-exception
            goto L_0x0071
        L_0x003b:
            r5 = move-exception
            goto L_0x004e
        L_0x003d:
            r5 = move-exception
            goto L_0x004e
        L_0x003f:
            r6.close()     // Catch:{ IOException -> 0x0048 }
            if (r4 == 0) goto L_0x006b
            r4.disconnect()     // Catch:{ IOException -> 0x0048 }
            goto L_0x006b
        L_0x0048:
            r4 = move-exception
            boolean r5 = com.alibaba.pdns.u.a.f18279a
            if (r5 == 0) goto L_0x006b
            goto L_0x0068
        L_0x004e:
            r2 = r6
        L_0x004f:
            boolean r6 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0016 }
            if (r6 == 0) goto L_0x0056
            r5.printStackTrace()     // Catch:{ all -> 0x0016 }
        L_0x0056:
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x005e
        L_0x005c:
            r4 = move-exception
            goto L_0x0064
        L_0x005e:
            if (r4 == 0) goto L_0x006b
            r4.disconnect()     // Catch:{ IOException -> 0x005c }
            goto L_0x006b
        L_0x0064:
            boolean r5 = com.alibaba.pdns.u.a.f18279a
            if (r5 == 0) goto L_0x006b
        L_0x0068:
            r4.printStackTrace()
        L_0x006b:
            java.lang.String r4 = r0.toString()
            return r4
        L_0x0070:
            r6 = r2
        L_0x0071:
            if (r6 == 0) goto L_0x0079
            r6.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r4 = move-exception
            goto L_0x007f
        L_0x0079:
            if (r4 == 0) goto L_0x0086
            r4.disconnect()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0086
        L_0x007f:
            boolean r6 = com.alibaba.pdns.u.a.f18279a
            if (r6 == 0) goto L_0x0086
            r4.printStackTrace()
        L_0x0086:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.d.a(java.net.HttpURLConnection, int, com.alibaba.pdns.model.b):java.lang.String");
    }

    public String a(String str, String str2) {
        try {
            HttpURLConnection b10 = b(str);
            b10.connect();
            int responseCode = b10.getResponseCode();
            String a10 = a(b10, responseCode, (b) null);
            f.f17932y.set(false);
            a.a("=====================================================");
            a.a("Request url:" + str);
            a.a("Response statusCode:" + responseCode);
            a.a("Response result:" + a10);
            a.a("=====================================================");
            return responseCode == 200 ? a10 : "";
        } catch (Exception e10) {
            f.f17932y.set(true);
            if (!a.f18279a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0197 A[Catch:{ all -> 0x00be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.e a(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.alibaba.pdns.model.f r23, com.alibaba.pdns.model.e r24, com.alibaba.pdns.model.b r25) {
        /*
            r18 = this;
            r7 = r20
            r3 = r21
            r4 = r22
            r8 = r24
            r6 = r25
            monitor-enter(r20)
            r9 = 0
            java.net.HttpURLConnection r0 = r18.b(r19)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r1 = "c"
            float r1 = com.alibaba.pdns.f.a((java.lang.String) r7, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x003c
            r2 = 1167867904(0x459c4000, float:5000.0)
            int r5 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0023
            r1 = r2
        L_0x0023:
            java.lang.String r2 = "c"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r0.setRequestProperty(r2, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r1 = "c"
            com.alibaba.pdns.f.b(r7, r3, r4, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            goto L_0x003c
        L_0x0032:
            r0 = move-exception
            r12 = r18
            goto L_0x019c
        L_0x0037:
            r0 = move-exception
            r12 = r18
            goto L_0x017a
        L_0x003c:
            if (r6 == 0) goto L_0x0070
            int r1 = com.alibaba.pdns.f.b(r20, r21, r22)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            if (r1 <= 0) goto L_0x0057
            java.lang.String r2 = "se"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r0.setRequestProperty(r2, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r1 = "se"
            com.alibaba.pdns.f.b(r7, r3, r4, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.util.concurrent.atomic.AtomicInteger r1 = r6.f17993c     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r1.set(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
        L_0x0057:
            int r1 = com.alibaba.pdns.f.a(r20, r21, r22)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            if (r1 <= 0) goto L_0x0070
            java.lang.String r2 = "ne"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r0.setRequestProperty(r2, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r1 = "ne"
            com.alibaba.pdns.f.b(r7, r3, r4, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.util.concurrent.atomic.AtomicInteger r1 = r6.f17994d     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r1.set(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
        L_0x0070:
            long r1 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r0.connect()     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            int r5 = r0.getResponseCode()     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            long r10 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            java.util.concurrent.atomic.AtomicBoolean r12 = com.alibaba.pdns.f.f17932y     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r12.set(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0032 }
            r12 = r18
            java.lang.String r13 = r12.a(r0, r5, r6)     // Catch:{ Exception -> 0x00c1 }
            long r10 = r10 - r1
            r1 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r10 / r1
            long r1 = r0.getDate()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r14 = "S"
            java.lang.String r14 = r0.getHeaderField(r14)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r15.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r9 = "sourceIp:"
            r15.append(r9)     // Catch:{ Exception -> 0x00c1 }
            r15.append(r14)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r9 = r15.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r9)     // Catch:{ Exception -> 0x00c1 }
            boolean r9 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x00c1 }
            if (r9 != 0) goto L_0x00c4
            java.lang.String r9 = ""
            boolean r9 = android.text.TextUtils.equals(r9, r14)     // Catch:{ Exception -> 0x00c1 }
            if (r9 != 0) goto L_0x00c4
            com.alibaba.pdns.f.f17921n = r14     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c4
        L_0x00be:
            r0 = move-exception
            goto L_0x019c
        L_0x00c1:
            r0 = move-exception
            goto L_0x017a
        L_0x00c4:
            java.lang.String r9 = "Cv"
            java.lang.String r9 = r0.getHeaderField(r9)     // Catch:{ Exception -> 0x00c1 }
            boolean r14 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00c1 }
            if (r14 != 0) goto L_0x00f8
            java.lang.String r14 = ""
            boolean r14 = android.text.TextUtils.equals(r14, r9)     // Catch:{ Exception -> 0x00c1 }
            if (r14 != 0) goto L_0x00f8
            long r14 = java.lang.Long.parseLong(r9)     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.f.f17917j = r14     // Catch:{ Exception -> 0x00c1 }
            long r14 = com.alibaba.pdns.f.f17918k     // Catch:{ Exception -> 0x00c1 }
            r16 = 0
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x00f2
            long r14 = com.alibaba.pdns.f.f17917j     // Catch:{ Exception -> 0x00c1 }
            long r16 = com.alibaba.pdns.f.f17918k     // Catch:{ Exception -> 0x00c1 }
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x00f2
            com.alibaba.pdns.f.b()     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00f8
        L_0x00f2:
            long r14 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.f.f17923p = r14     // Catch:{ Exception -> 0x00c1 }
        L_0x00f8:
            java.lang.String r14 = "====================================================="
            com.alibaba.pdns.u.a.a((java.lang.String) r14)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r14.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r15 = "Data:"
            r14.append(r15)     // Catch:{ Exception -> 0x00c1 }
            long r3 = r0.getDate()     // Catch:{ Exception -> 0x00c1 }
            r14.append(r3)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r14.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r0.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = "statusCode:"
            r0.append(r3)     // Catch:{ Exception -> 0x00c1 }
            r0.append(r5)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r0.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = "result:"
            r0.append(r3)     // Catch:{ Exception -> 0x00c1 }
            r0.append(r13)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r0.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = "耗时rtt:"
            r0.append(r3)     // Catch:{ Exception -> 0x00c1 }
            r0.append(r10)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r0.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = "ACLVersion:"
            r0.append(r3)     // Catch:{ Exception -> 0x00c1 }
            r0.append(r9)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r0 = "====================================================="
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00c1 }
            if (r8 == 0) goto L_0x019a
            float r0 = (float) r10     // Catch:{ Exception -> 0x00c1 }
            r8.a((float) r0)     // Catch:{ Exception -> 0x00c1 }
            r8.a((int) r5)     // Catch:{ Exception -> 0x00c1 }
            r8.a((long) r1)     // Catch:{ Exception -> 0x00c1 }
            r8.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x019a
        L_0x017a:
            java.util.concurrent.atomic.AtomicBoolean r1 = com.alibaba.pdns.f.f17932y     // Catch:{ all -> 0x00be }
            r2 = 1
            r1.set(r2)     // Catch:{ all -> 0x00be }
            r1 = r18
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r25
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00be }
            r1 = 0
            com.alibaba.pdns.DNSResolver.setEnableIPv6(r1)     // Catch:{ all -> 0x00be }
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x019a
            r0.printStackTrace()     // Catch:{ all -> 0x00be }
        L_0x019a:
            monitor-exit(r20)     // Catch:{ all -> 0x00be }
            return r8
        L_0x019c:
            monitor-exit(r20)     // Catch:{ all -> 0x00be }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.d.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.pdns.model.f, com.alibaba.pdns.model.e, com.alibaba.pdns.model.b):com.alibaba.pdns.model.e");
    }

    private void a(String str, String str2, String str3, com.alibaba.pdns.model.f fVar, b bVar) {
        if (bVar != null) {
            bVar.f17994d.incrementAndGet();
            bVar.f17995e.incrementAndGet();
            int intValue = bVar.f17994d.intValue();
            f.I.put(o.a(str, str2, str3, f18105h), Integer.valueOf(intValue));
        }
        f.a(fVar);
    }
}
