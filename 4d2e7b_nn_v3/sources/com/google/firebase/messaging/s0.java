package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class s0 {

    /* renamed from: i  reason: collision with root package name */
    private static final long f9288i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f9289a;

    /* renamed from: b  reason: collision with root package name */
    private final d0 f9290b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f9291c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f9292d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f9293e = new ArrayMap();

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f9294f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9295g = false;

    /* renamed from: h  reason: collision with root package name */
    private final q0 f9296h;

    private s0(FirebaseMessaging firebaseMessaging, d0 d0Var, q0 q0Var, a0 a0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f9292d = firebaseMessaging;
        this.f9290b = d0Var;
        this.f9296h = q0Var;
        this.f9291c = a0Var;
        this.f9289a = context;
        this.f9294f = scheduledExecutorService;
    }

    private void b(p0 p0Var, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.f9293e) {
            try {
                String e10 = p0Var.e();
                if (this.f9293e.containsKey(e10)) {
                    arrayDeque = (ArrayDeque) this.f9293e.get(e10);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f9293e.put(e10, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void c(Task task) {
        try {
            Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e10);
            }
        } catch (InterruptedException | TimeoutException e11) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e11);
        }
    }

    private void d(String str) {
        c(this.f9291c.l(this.f9292d.blockingGetToken(), str));
    }

    private void e(String str) {
        c(this.f9291c.m(this.f9292d.blockingGetToken(), str));
    }

    static Task f(FirebaseMessaging firebaseMessaging, d0 d0Var, a0 a0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new r0(context, scheduledExecutorService, firebaseMessaging, d0Var, a0Var));
    }

    static boolean h() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ s0 j(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, d0 d0Var, a0 a0Var) {
        return new s0(firebaseMessaging, d0Var, q0.b(context, scheduledExecutorService), a0Var, context, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(com.google.firebase.messaging.p0 r5) {
        /*
            r4 = this;
            java.util.Map r0 = r4.f9293e
            monitor-enter(r0)
            java.lang.String r5 = r5.e()     // Catch:{ all -> 0x0011 }
            java.util.Map r1 = r4.f9293e     // Catch:{ all -> 0x0011 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r5 = move-exception
            goto L_0x0034
        L_0x0013:
            java.util.Map r1 = r4.f9293e     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0011 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0011 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0011 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0027
            r3 = 0
            r2.setResult(r3)     // Catch:{ all -> 0x0011 }
        L_0x0027:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0032
            java.util.Map r1 = r4.f9293e     // Catch:{ all -> 0x0011 }
            r1.remove(r5)     // Catch:{ all -> 0x0011 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.s0.k(com.google.firebase.messaging.p0):void");
    }

    private void p() {
        if (!i()) {
            t(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (this.f9296h.c() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i() {
        return this.f9295g;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[Catch:{ IOException -> 0x001f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(com.google.firebase.messaging.p0 r7) {
        /*
            r6 = this;
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 0
            java.lang.String r2 = r7.b()     // Catch:{ IOException -> 0x001f }
            int r3 = r2.hashCode()     // Catch:{ IOException -> 0x001f }
            r4 = 83
            r5 = 1
            if (r3 == r4) goto L_0x0022
            r4 = 85
            if (r3 == r4) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            java.lang.String r3 = "U"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = r5
            goto L_0x002d
        L_0x001f:
            r7 = move-exception
            goto L_0x00a5
        L_0x0022:
            java.lang.String r3 = "S"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = r1
            goto L_0x002d
        L_0x002c:
            r2 = -1
        L_0x002d:
            java.lang.String r3 = " succeeded."
            if (r2 == 0) goto L_0x007c
            if (r2 == r5) goto L_0x0053
            boolean r2 = h()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = "Unknown topic operation"
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = "."
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
            goto L_0x00a4
        L_0x0053:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.e(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = h()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Unsubscribe from topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
            goto L_0x00a4
        L_0x007c:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.d(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = h()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Subscribe to topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
        L_0x00a4:
            return r5
        L_0x00a5:
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00cb
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00be
            goto L_0x00cb
        L_0x00be:
            java.lang.String r2 = r7.getMessage()
            if (r2 != 0) goto L_0x00ca
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r7)
            return r1
        L_0x00ca:
            throw r7
        L_0x00cb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.s0.l(com.google.firebase.messaging.p0):boolean");
    }

    /* access modifiers changed from: package-private */
    public void m(Runnable runnable, long j10) {
        this.f9294f.schedule(runnable, j10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public Task n(p0 p0Var) {
        this.f9296h.a(p0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(p0Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public synchronized void o(boolean z10) {
        this.f9295g = z10;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (g()) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public Task r(String str) {
        Task n10 = n(p0.f(str));
        q();
        return n10;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (l(r0) != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.q0 r0 = r2.f9296h     // Catch:{ all -> 0x0017 }
            com.google.firebase.messaging.p0 r0 = r0.c()     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001c
            boolean r0 = h()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r0 = move-exception
            goto L_0x002e
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            r0 = 1
            return r0
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            boolean r1 = r2.l(r0)
            if (r1 != 0) goto L_0x0025
            r0 = 0
            return r0
        L_0x0025:
            com.google.firebase.messaging.q0 r1 = r2.f9296h
            r1.e(r0)
            r2.k(r0)
            goto L_0x0000
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.s0.s():boolean");
    }

    /* access modifiers changed from: package-private */
    public void t(long j10) {
        m(new t0(this, this.f9289a, this.f9290b, Math.min(Math.max(30, 2 * j10), f9288i)), j10);
        o(true);
    }

    /* access modifiers changed from: package-private */
    public Task u(String str) {
        Task n10 = n(p0.g(str));
        q();
        return n10;
    }
}
