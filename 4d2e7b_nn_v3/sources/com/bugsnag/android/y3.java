package com.bugsnag.android;

import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class y3 {

    /* renamed from: a  reason: collision with root package name */
    private final File f19156a;

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantReadWriteLock f19157b = new ReentrantReadWriteLock();

    public y3(File file) {
        this.f19156a = file;
    }

    public final File a() {
        return this.f19156a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        tb.c.a(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bugsnag.android.k2.a b(kotlin.jvm.functions.Function1 r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r4.f19157b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.io.File r1 = r4.a()     // Catch:{ all -> 0x0020 }
            java.nio.charset.Charset r2 = kotlin.text.d.f797b     // Catch:{ all -> 0x0020 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0020 }
            r3.<init>(r1)     // Catch:{ all -> 0x0020 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0020 }
            r1.<init>(r3, r2)     // Catch:{ all -> 0x0020 }
            boolean r2 = r1 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0022
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x0020 }
            goto L_0x002a
        L_0x0020:
            r5 = move-exception
            goto L_0x0044
        L_0x0022:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0020 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0020 }
            r1 = r2
        L_0x002a:
            android.util.JsonReader r2 = new android.util.JsonReader     // Catch:{ all -> 0x003d }
            r2.<init>(r1)     // Catch:{ all -> 0x003d }
            java.lang.Object r5 = r5.invoke(r2)     // Catch:{ all -> 0x003d }
            com.bugsnag.android.k2$a r5 = (com.bugsnag.android.k2.a) r5     // Catch:{ all -> 0x003d }
            r2 = 0
            tb.c.a(r1, r2)     // Catch:{ all -> 0x0020 }
            r0.unlock()
            return r5
        L_0x003d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            tb.c.a(r1, r5)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0044:
            r0.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.y3.b(kotlin.jvm.functions.Function1):com.bugsnag.android.k2$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        tb.c.a(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.bugsnag.android.k2.a r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r4.f19157b
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.io.File r1 = r4.a()     // Catch:{ all -> 0x0020 }
            java.nio.charset.Charset r2 = kotlin.text.d.f797b     // Catch:{ all -> 0x0020 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0020 }
            r3.<init>(r1)     // Catch:{ all -> 0x0020 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0020 }
            r1.<init>(r3, r2)     // Catch:{ all -> 0x0020 }
            boolean r2 = r1 instanceof java.io.BufferedWriter     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0022
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x0020 }
            goto L_0x002a
        L_0x0020:
            r5 = move-exception
            goto L_0x0041
        L_0x0022:
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ all -> 0x0020 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0020 }
            r1 = r2
        L_0x002a:
            com.bugsnag.android.k2 r2 = new com.bugsnag.android.k2     // Catch:{ all -> 0x003a }
            r2.<init>(r1)     // Catch:{ all -> 0x003a }
            r5.toStream(r2)     // Catch:{ all -> 0x003a }
            r5 = 0
            tb.c.a(r1, r5)     // Catch:{ all -> 0x0020 }
            r0.unlock()
            return
        L_0x003a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003c }
        L_0x003c:
            r2 = move-exception
            tb.c.a(r1, r5)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0041:
            r0.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.y3.c(com.bugsnag.android.k2$a):void");
    }
}
