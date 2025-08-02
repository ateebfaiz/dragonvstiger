package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzby;

abstract class h {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f7522d;

    /* renamed from: a  reason: collision with root package name */
    private final z0 f7523a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f7524b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile long f7525c;

    h(z0 z0Var) {
        Preconditions.checkNotNull(z0Var);
        this.f7523a = z0Var;
        this.f7524b = new g(this, z0Var);
    }

    private final Handler f() {
        Handler handler;
        if (f7522d != null) {
            return f7522d;
        }
        synchronized (h.class) {
            try {
                if (f7522d == null) {
                    f7522d = new zzby(this.f7523a.zzau().getMainLooper());
                }
                handler = f7522d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f7525c = 0;
        f().removeCallbacks(this.f7524b);
    }

    public abstract void c();

    public final void d(long j10) {
        b();
        if (j10 >= 0) {
            this.f7525c = this.f7523a.zzav().currentTimeMillis();
            if (!f().postDelayed(this.f7524b, j10)) {
                this.f7523a.zzay().zzd().zzb("Failed to schedule delayed post. time", Long.valueOf(j10));
            }
        }
    }

    public final boolean e() {
        return this.f7525c != 0;
    }
}
