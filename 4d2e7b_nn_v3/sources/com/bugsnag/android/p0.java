package com.bugsnag.android;

import android.net.TrafficStats;
import c1.p;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class p0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    private final g0 f18909a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18910b;

    public p0(g0 g0Var, s2 s2Var) {
        this.f18909a = g0Var;
        this.f18910b = s2Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        tb.c.a(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bc, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        tb.c.a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c0, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d(int r6, java.net.HttpURLConnection r7, com.bugsnag.android.v0 r8) {
        /*
            r5 = this;
            kotlin.o$a r0 = kotlin.o.f12592b     // Catch:{ all -> 0x0036 }
            com.bugsnag.android.s2 r0 = r5.f18910b     // Catch:{ all -> 0x0036 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "Request completed with code "
            r1.append(r2)     // Catch:{ all -> 0x0036 }
            r1.append(r6)     // Catch:{ all -> 0x0036 }
            java.lang.String r6 = ", message: "
            r1.append(r6)     // Catch:{ all -> 0x0036 }
            java.lang.String r6 = r7.getResponseMessage()     // Catch:{ all -> 0x0036 }
            r1.append(r6)     // Catch:{ all -> 0x0036 }
            java.lang.String r6 = ", headers: "
            r1.append(r6)     // Catch:{ all -> 0x0036 }
            java.util.Map r6 = r7.getHeaderFields()     // Catch:{ all -> 0x0036 }
            r1.append(r6)     // Catch:{ all -> 0x0036 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0036 }
            r0.f(r6)     // Catch:{ all -> 0x0036 }
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0036 }
            kotlin.o.b(r6)     // Catch:{ all -> 0x0036 }
            goto L_0x0040
        L_0x0036:
            r6 = move-exception
            kotlin.o$a r0 = kotlin.o.f12592b
            java.lang.Object r6 = kotlin.p.a(r6)
            kotlin.o.b(r6)
        L_0x0040:
            r6 = 0
            r0 = 8192(0x2000, float:1.14794E-41)
            java.io.InputStream r1 = r7.getInputStream()     // Catch:{ all -> 0x0055 }
            java.nio.charset.Charset r2 = kotlin.text.d.f797b     // Catch:{ all -> 0x0055 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0055 }
            r3.<init>(r1, r2)     // Catch:{ all -> 0x0055 }
            boolean r1 = r3 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0057
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r1 = move-exception
            goto L_0x007e
        L_0x0057:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0055 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0055 }
            r3 = r1
        L_0x005d:
            com.bugsnag.android.s2 r1 = r5.f18910b     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "Received request response: "
            java.lang.String r4 = tb.o.f(r3)     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = kotlin.jvm.internal.m.n(r2, r4)     // Catch:{ all -> 0x0077 }
            r1.d(r2)     // Catch:{ all -> 0x0077 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0077 }
            tb.c.a(r3, r6)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0055 }
            kotlin.o.b(r1)     // Catch:{ all -> 0x0055 }
            goto L_0x0087
        L_0x0077:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r2 = move-exception
            tb.c.a(r3, r1)     // Catch:{ all -> 0x0055 }
            throw r2     // Catch:{ all -> 0x0055 }
        L_0x007e:
            kotlin.o$a r2 = kotlin.o.f12592b
            java.lang.Object r1 = kotlin.p.a(r1)
            kotlin.o.b(r1)
        L_0x0087:
            com.bugsnag.android.v0 r1 = com.bugsnag.android.v0.DELIVERED     // Catch:{ all -> 0x009d }
            if (r8 == r1) goto L_0x00c1
            java.io.InputStream r7 = r7.getErrorStream()     // Catch:{ all -> 0x009d }
            java.nio.charset.Charset r8 = kotlin.text.d.f797b     // Catch:{ all -> 0x009d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x009d }
            r1.<init>(r7, r8)     // Catch:{ all -> 0x009d }
            boolean r7 = r1 instanceof java.io.BufferedReader     // Catch:{ all -> 0x009d }
            if (r7 == 0) goto L_0x009f
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x009d }
            goto L_0x00a5
        L_0x009d:
            r6 = move-exception
            goto L_0x00c7
        L_0x009f:
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x009d }
            r7.<init>(r1, r0)     // Catch:{ all -> 0x009d }
            r1 = r7
        L_0x00a5:
            com.bugsnag.android.s2 r7 = r5.f18910b     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "Request error details: "
            java.lang.String r0 = tb.o.f(r1)     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = kotlin.jvm.internal.m.n(r8, r0)     // Catch:{ all -> 0x00ba }
            r7.g(r8)     // Catch:{ all -> 0x00ba }
            kotlin.Unit r7 = kotlin.Unit.f12577a     // Catch:{ all -> 0x00ba }
            tb.c.a(r1, r6)     // Catch:{ all -> 0x009d }
            goto L_0x00c1
        L_0x00ba:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r7 = move-exception
            tb.c.a(r1, r6)     // Catch:{ all -> 0x009d }
            throw r7     // Catch:{ all -> 0x009d }
        L_0x00c1:
            kotlin.Unit r6 = kotlin.Unit.f12577a     // Catch:{ all -> 0x009d }
            kotlin.o.b(r6)     // Catch:{ all -> 0x009d }
            goto L_0x00d0
        L_0x00c7:
            kotlin.o$a r7 = kotlin.o.f12592b
            java.lang.Object r6 = kotlin.p.a(r6)
            kotlin.o.b(r6)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p0.d(int, java.net.HttpURLConnection, com.bugsnag.android.v0):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        tb.c.a(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection e(java.net.URL r2, byte[] r3, java.lang.String r4, java.util.Map r5) {
        /*
            r1 = this;
            java.net.URLConnection r2 = r2.openConnection()
            if (r2 == 0) goto L_0x0053
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
            r0 = 1
            r2.setDoOutput(r0)
            int r0 = r3.length
            r2.setFixedLengthStreamingMode(r0)
            if (r4 != 0) goto L_0x0013
            goto L_0x0018
        L_0x0013:
            java.lang.String r0 = "Bugsnag-Integrity"
            r2.addRequestProperty(r0, r4)
        L_0x0018:
            java.util.Set r4 = r5.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0020:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x003e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r0 = r5.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0020
            r2.addRequestProperty(r0, r5)
            goto L_0x0020
        L_0x003e:
            java.io.OutputStream r4 = r2.getOutputStream()
            r4.write(r3)     // Catch:{ all -> 0x004c }
            kotlin.Unit r3 = kotlin.Unit.f12577a     // Catch:{ all -> 0x004c }
            r3 = 0
            tb.c.a(r4, r3)
            return r2
        L_0x004c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x004e }
        L_0x004e:
            r3 = move-exception
            tb.c.a(r4, r2)
            throw r3
        L_0x0053:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p0.e(java.net.URL, byte[], java.lang.String, java.util.Map):java.net.HttpURLConnection");
    }

    public v0 a(s1 s1Var, u0 u0Var) {
        v0 c10 = c(u0Var.a(), s1.i(s1Var, 0, 1, (Object) null).a(), s1Var.e(), u0Var.b());
        this.f18910b.f(m.n("Error API request finished with status ", c10));
        return c10;
    }

    public v0 b(l3 l3Var, u0 u0Var) {
        v0 c10 = c(u0Var.a(), p.f17266a.g(l3Var), l3Var.f(), u0Var.b());
        this.f18910b.f(m.n("Session API request finished with status ", c10));
        return c10;
    }

    public final v0 c(String str, byte[] bArr, String str2, Map map) {
        TrafficStats.setThreadStatsTag(1);
        g0 g0Var = this.f18909a;
        if (g0Var != null && !g0Var.b()) {
            return v0.UNDELIVERED;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = e(new URL(str), bArr, str2, map);
            int responseCode = httpURLConnection.getResponseCode();
            v0 a10 = v0.f19030a.a(responseCode);
            d(responseCode, httpURLConnection, a10);
            httpURLConnection.disconnect();
            return a10;
        } catch (OutOfMemoryError e10) {
            this.f18910b.c("Encountered OOM delivering payload, falling back to persist on disk", e10);
            v0 v0Var = v0.UNDELIVERED;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return v0Var;
        } catch (IOException e11) {
            this.f18910b.c("IOException encountered in request", e11);
            v0 v0Var2 = v0.UNDELIVERED;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return v0Var2;
        } catch (Exception e12) {
            this.f18910b.c("Unexpected error delivering payload", e12);
            v0 v0Var3 = v0.FAILURE;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return v0Var3;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
