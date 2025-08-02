package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class r extends GmsClientSupervisor {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f6804a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f6805b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f6806c;

    /* renamed from: d  reason: collision with root package name */
    private final q f6807d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionTracker f6808e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6809f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final long f6810g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Executor f6811h;

    r(Context context, Looper looper, Executor executor) {
        q qVar = new q(this, (zzq) null);
        this.f6807d = qVar;
        this.f6805b = context.getApplicationContext();
        this.f6806c = new zzi(looper, qVar);
        this.f6808e = ConnectionTracker.getInstance();
        this.f6809f = 5000;
        this.f6810g = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.f6811h = executor;
    }

    /* access modifiers changed from: package-private */
    public final void f(Executor executor) {
        synchronized (this.f6804a) {
            this.f6811h = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(Looper looper) {
        synchronized (this.f6804a) {
            this.f6806c = new zzi(looper, this.f6807d);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzo zzo, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6804a) {
            try {
                p pVar = (p) this.f6804a.get(zzo);
                if (pVar == null) {
                    String obj = zzo.toString();
                    throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
                } else if (pVar.h(serviceConnection)) {
                    pVar.f(serviceConnection, str);
                    if (pVar.i()) {
                        this.f6806c.sendMessageDelayed(this.f6806c.obtainMessage(0, zzo), this.f6809f);
                    }
                } else {
                    String obj2 = zzo.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc(zzo zzo, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j10;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6804a) {
            try {
                p pVar = (p) this.f6804a.get(zzo);
                if (executor == null) {
                    executor = this.f6811h;
                }
                if (pVar == null) {
                    pVar = new p(this, zzo);
                    pVar.d(serviceConnection, serviceConnection, str);
                    pVar.e(str, executor);
                    this.f6804a.put(zzo, pVar);
                } else {
                    this.f6806c.removeMessages(0, zzo);
                    if (!pVar.h(serviceConnection)) {
                        pVar.d(serviceConnection, serviceConnection, str);
                        int a10 = pVar.a();
                        if (a10 == 1) {
                            serviceConnection.onServiceConnected(pVar.b(), pVar.c());
                        } else if (a10 == 2) {
                            pVar.e(str, executor);
                        }
                    } else {
                        String obj = zzo.toString();
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                    }
                }
                j10 = pVar.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return j10;
    }
}
