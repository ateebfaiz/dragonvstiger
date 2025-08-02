package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class p implements ServiceConnection, zzt {

    /* renamed from: a  reason: collision with root package name */
    private final Map f6796a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f6797b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6798c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f6799d;

    /* renamed from: e  reason: collision with root package name */
    private final zzo f6800e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f6801f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ r f6802g;

    public p(r rVar, zzo zzo) {
        this.f6802g = rVar;
        this.f6800e = zzo;
    }

    public final int a() {
        return this.f6797b;
    }

    public final ComponentName b() {
        return this.f6801f;
    }

    public final IBinder c() {
        return this.f6799d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f6796a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f6797b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            r rVar = this.f6802g;
            boolean zza = rVar.f6808e.zza(rVar.f6805b, str, this.f6800e.zzb(rVar.f6805b), this, 4225, executor);
            this.f6798c = zza;
            if (zza) {
                this.f6802g.f6806c.sendMessageDelayed(this.f6802g.f6806c.obtainMessage(1, this.f6800e), this.f6802g.f6810g);
            } else {
                this.f6797b = 2;
                try {
                    r rVar2 = this.f6802g;
                    rVar2.f6808e.unbindService(rVar2.f6805b, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f6796a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f6802g.f6806c.removeMessages(1, this.f6800e);
        r rVar = this.f6802g;
        rVar.f6808e.unbindService(rVar.f6805b, this);
        this.f6798c = false;
        this.f6797b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f6796a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f6796a.isEmpty();
    }

    public final boolean j() {
        return this.f6798c;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6802g.f6804a) {
            try {
                this.f6802g.f6806c.removeMessages(1, this.f6800e);
                this.f6799d = iBinder;
                this.f6801f = componentName;
                for (ServiceConnection onServiceConnected : this.f6796a.values()) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.f6797b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f6802g.f6804a) {
            try {
                this.f6802g.f6806c.removeMessages(1, this.f6800e);
                this.f6799d = null;
                this.f6801f = componentName;
                for (ServiceConnection onServiceDisconnected : this.f6796a.values()) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.f6797b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
