package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class f0 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7495a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f7496b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7497c = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzfo f7498d;

    public f0(zzfo zzfo, String str, BlockingQueue blockingQueue) {
        this.f7498d = zzfo;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f7495a = new Object();
        this.f7496b = blockingQueue;
        setName(str);
    }

    private final void b() {
        synchronized (this.f7498d.zzh) {
            try {
                if (!this.f7497c) {
                    this.f7498d.zzi.release();
                    this.f7498d.zzh.notifyAll();
                    zzfo zzfo = this.f7498d;
                    if (this == zzfo.zzb) {
                        zzfo.zzb = null;
                    } else if (this == zzfo.zzc) {
                        zzfo.zzc = null;
                    } else {
                        zzfo.zzt.zzay().zzd().zza("Current scheduler thread is neither worker nor network");
                    }
                    this.f7497c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f7498d.zzt.zzay().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.f7495a) {
            this.f7495a.notifyAll();
        }
    }

    public final void run() {
        int i10;
        boolean z10 = false;
        while (!z10) {
            try {
                this.f7498d.zzi.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                c(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                e0 e0Var = (e0) this.f7496b.poll();
                if (e0Var != null) {
                    if (true != e0Var.f7468b) {
                        i10 = 10;
                    } else {
                        i10 = threadPriority;
                    }
                    Process.setThreadPriority(i10);
                    e0Var.run();
                } else {
                    synchronized (this.f7495a) {
                        if (this.f7496b.peek() == null) {
                            boolean unused = this.f7498d.zzj;
                            try {
                                this.f7495a.wait(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            } catch (InterruptedException e11) {
                                c(e11);
                            }
                        }
                    }
                    synchronized (this.f7498d.zzh) {
                        if (this.f7496b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
