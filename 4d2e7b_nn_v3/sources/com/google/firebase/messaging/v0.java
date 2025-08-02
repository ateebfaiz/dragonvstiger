package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

abstract class v0 {

    /* renamed from: a  reason: collision with root package name */
    static final long f9314a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f9315b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static WakeLock f9316c;

    private static void b(Context context) {
        if (f9316c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f9316c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (f9315b) {
            try {
                if (f9316c != null && d(intent)) {
                    g(intent, false);
                    f9316c.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void f(Context context, a1 a1Var, Intent intent) {
        synchronized (f9315b) {
            try {
                b(context);
                boolean d10 = d(intent);
                g(intent, true);
                if (!d10) {
                    f9316c.acquire(f9314a);
                }
                a1Var.c(intent).addOnCompleteListener(new u0(intent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(Intent intent, boolean z10) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.content.ComponentName h(android.content.Context r3, android.content.Intent r4) {
        /*
            java.lang.Object r0 = f9315b
            monitor-enter(r0)
            b(r3)     // Catch:{ all -> 0x0017 }
            boolean r1 = d(r4)     // Catch:{ all -> 0x0017 }
            r2 = 1
            g(r4, r2)     // Catch:{ all -> 0x0017 }
            android.content.ComponentName r3 = r3.startService(r4)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r3 = 0
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x0024
        L_0x0019:
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.stats.WakeLock r4 = f9316c     // Catch:{ all -> 0x0017 }
            long r1 = f9314a     // Catch:{ all -> 0x0017 }
            r4.acquire(r1)     // Catch:{ all -> 0x0017 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r3
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.v0.h(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
