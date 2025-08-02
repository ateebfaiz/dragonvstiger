package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class q0 {

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference f9277d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f9278a;

    /* renamed from: b  reason: collision with root package name */
    private m0 f9279b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f9280c;

    private q0(SharedPreferences sharedPreferences, Executor executor) {
        this.f9280c = executor;
        this.f9278a = sharedPreferences;
    }

    public static synchronized q0 b(Context context, Executor executor) {
        q0 q0Var;
        synchronized (q0.class) {
            try {
                WeakReference weakReference = f9277d;
                if (weakReference != null) {
                    q0Var = (q0) weakReference.get();
                } else {
                    q0Var = null;
                }
                if (q0Var == null) {
                    q0Var = new q0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    q0Var.d();
                    f9277d = new WeakReference(q0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return q0Var;
    }

    private synchronized void d() {
        this.f9279b = m0.d(this.f9278a, "topic_operation_queue", ",", this.f9280c);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(p0 p0Var) {
        return this.f9279b.b(p0Var.e());
    }

    /* access modifiers changed from: package-private */
    public synchronized p0 c() {
        return p0.a(this.f9279b.f());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean e(p0 p0Var) {
        return this.f9279b.g(p0Var.e());
    }
}
