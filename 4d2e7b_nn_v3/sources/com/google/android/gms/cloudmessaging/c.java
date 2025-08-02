package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class c implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    int f6636a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f6637b = new Messenger(new zzf(Looper.getMainLooper(), new zzf(this)));

    /* renamed from: c  reason: collision with root package name */
    d f6638c;

    /* renamed from: d  reason: collision with root package name */
    final Queue f6639d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    final SparseArray f6640e = new SparseArray();

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzs f6641f;

    /* synthetic */ c(zzs zzs, zzl zzl) {
        this.f6641f = zzs;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i10, String str) {
        b(i10, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i10, String str, Throwable th) {
        String str2;
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "Disconnected: ".concat(valueOf);
                } else {
                    str2 = new String("Disconnected: ");
                }
                Log.d("MessengerIpcClient", str2);
            }
            int i11 = this.f6636a;
            if (i11 == 0) {
                throw new IllegalStateException();
            } else if (i11 == 1 || i11 == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f6636a = 4;
                ConnectionTracker.getInstance().unbindService(this.f6641f.zzb, this);
                zzq zzq = new zzq(i10, str, th);
                for (f c10 : this.f6639d) {
                    c10.c(zzq);
                }
                this.f6639d.clear();
                for (int i12 = 0; i12 < this.f6640e.size(); i12++) {
                    ((f) this.f6640e.valueAt(i12)).c(zzq);
                }
                this.f6640e.clear();
            } else if (i11 == 3) {
                this.f6636a = 4;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f6641f.zzc.execute(new zzh(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f6636a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i10) {
        f fVar = (f) this.f6640e.get(i10);
        if (fVar != null) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Timing out request: ");
            sb2.append(i10);
            Log.w("MessengerIpcClient", sb2.toString());
            this.f6640e.remove(i10);
            fVar.c(new zzq(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f6636a     // Catch:{ all -> 0x0026 }
            r1 = 2
            if (r0 != r1) goto L_0x003a
            java.util.Queue r0 = r2.f6639d     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x003a
            android.util.SparseArray r0 = r2.f6640e     // Catch:{ all -> 0x0026 }
            int r0 = r0.size()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "MessengerIpcClient"
            java.lang.String r1 = "Finished handling requests, unbinding"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x003c
        L_0x0028:
            r0 = 3
            r2.f6636a = r0     // Catch:{ all -> 0x0026 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x0026 }
            com.google.android.gms.cloudmessaging.zzs r1 = r2.f6641f     // Catch:{ all -> 0x0026 }
            android.content.Context r1 = r1.zzb     // Catch:{ all -> 0x0026 }
            r0.unbindService(r1, r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return
        L_0x003a:
            monitor-exit(r2)
            return
        L_0x003c:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.c.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(f fVar) {
        boolean z10;
        int i10 = this.f6636a;
        if (i10 == 0) {
            this.f6639d.add(fVar);
            if (this.f6636a == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f6636a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!ConnectionTracker.getInstance().bindService(this.f6641f.zzb, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.f6641f.zzc.schedule(new zzi(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e10) {
                b(0, "Unable to bind to service", e10);
            }
        } else if (i10 == 1) {
            this.f6639d.add(fVar);
            return true;
        } else if (i10 != 2) {
            return false;
        } else {
            this.f6639d.add(fVar);
            c();
            return true;
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f6641f.zzc.execute(new zzj(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f6641f.zzc.execute(new zzg(this));
    }
}
