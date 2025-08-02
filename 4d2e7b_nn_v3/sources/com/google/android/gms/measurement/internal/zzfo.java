package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzfo extends y0 {
    /* access modifiers changed from: private */
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    @Nullable
    public f0 zzb;
    /* access modifiers changed from: private */
    @Nullable
    public f0 zzc;
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final BlockingQueue zze = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzf = new d0(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzg = new d0(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzh = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzi = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzj;

    zzfo(zzfr zzfr) {
        super(zzfr);
    }

    private final void zzt(e0 e0Var) {
        synchronized (this.zzh) {
            try {
                this.zzd.add(e0Var);
                f0 f0Var = this.zzb;
                if (f0Var == null) {
                    f0 f0Var2 = new f0(this, "Measurement Worker", this.zzd);
                    this.zzb = f0Var2;
                    f0Var2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    f0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzax() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r3 = r1.zzt.zzay().zzk();
        r3.zza("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.zzt.zzay().zzk().zza("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002a */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0028 }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()     // Catch:{ all -> 0x0028 }
            r0.zzp(r6)     // Catch:{ all -> 0x0028 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x002a }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.zza(r4)
        L_0x0027:
            return r2
        L_0x0028:
            r3 = move-exception
            goto L_0x004b
        L_0x002a:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0028 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0028 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0028 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r4.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0028 }
            r4.append(r5)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0028 }
            r3.zza(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            r2 = 0
            return r2
        L_0x004b:
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        e0 e0Var = new e0(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzt.zzay().zzk().zza("Callable skipped the worker queue.");
            }
            e0Var.run();
        } else {
            zzt(e0Var);
        }
        return e0Var;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        e0 e0Var = new e0(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            e0Var.run();
        } else {
            zzt(e0Var);
        }
        return e0Var;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        e0 e0Var = new e0(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            try {
                this.zze.add(e0Var);
                f0 f0Var = this.zzc;
                if (f0Var == null) {
                    f0 f0Var2 = new f0(this, "Measurement Network", this.zze);
                    this.zzc = f0Var2;
                    f0Var2.setUncaughtExceptionHandler(this.zzg);
                    this.zzc.start();
                } else {
                    f0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new e0(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new e0(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        if (Thread.currentThread() == this.zzb) {
            return true;
        }
        return false;
    }
}
