package com.onesignal;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import androidx.work.WorkRequest;
import com.onesignal.h0;
import com.onesignal.o3;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class b3 extends e1 {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f10392e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static b3 f10393f;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f10394d = 0L;

    static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference f10395a;

        a(Service service) {
            this.f10395a = new WeakReference(service);
        }

        /* access modifiers changed from: protected */
        public void a() {
            o3.a(o3.v.DEBUG, "LegacySyncRunnable:Stopped");
            if (this.f10395a.get() != null) {
                ((Service) this.f10395a.get()).stopSelf();
            }
        }
    }

    static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference f10396a;

        /* renamed from: b  reason: collision with root package name */
        private JobParameters f10397b;

        b(JobService jobService, JobParameters jobParameters) {
            this.f10396a = new WeakReference(jobService);
            this.f10397b = jobParameters;
        }

        /* access modifiers changed from: protected */
        public void a() {
            o3.v vVar = o3.v.DEBUG;
            o3.a(vVar, "LollipopSyncRunnable:JobFinished needsJobReschedule: " + b3.q().f10611a);
            boolean z10 = b3.q().f10611a;
            b3.q().f10611a = false;
            if (this.f10396a.get() != null) {
                ((JobService) this.f10396a.get()).jobFinished(this.f10397b, z10);
            }
        }
    }

    static abstract class c implements Runnable {

        class a implements h0.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BlockingQueue f10398a;

            a(BlockingQueue blockingQueue) {
                this.f10398a = blockingQueue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.onesignal.h0$d} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.onesignal.h0$d} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.onesignal.h0.d r2) {
                /*
                    r1 = this;
                    if (r2 == 0) goto L_0x0003
                    goto L_0x0008
                L_0x0003:
                    java.lang.Object r2 = new java.lang.Object
                    r2.<init>()
                L_0x0008:
                    java.util.concurrent.BlockingQueue r0 = r1.f10398a
                    r0.offer(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.b3.c.a.a(com.onesignal.h0$d):void");
            }

            public h0.f getType() {
                return h0.f.SYNC_SERVICE;
            }
        }

        c() {
        }

        /* access modifiers changed from: protected */
        public abstract void a();

        public final void run() {
            synchronized (e1.f10610c) {
                Long unused = b3.q().f10394d = 0L;
            }
            if (o3.z0() == null) {
                a();
                return;
            }
            o3.f10886d = o3.o0();
            e4.k();
            try {
                ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
                h0.g(o3.f10882b, false, false, new a(arrayBlockingQueue));
                Object take = arrayBlockingQueue.take();
                if (take instanceof h0.d) {
                    e4.w((h0.d) take);
                }
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            e4.u(true);
            o3.b0().d();
            a();
        }
    }

    b3() {
    }

    static b3 q() {
        if (f10393f == null) {
            synchronized (f10392e) {
                try {
                    if (f10393f == null) {
                        f10393f = new b3();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10393f;
    }

    /* access modifiers changed from: protected */
    public Class c() {
        return SyncJobService.class;
    }

    /* access modifiers changed from: protected */
    public Class d() {
        return SyncService.class;
    }

    /* access modifiers changed from: protected */
    public int e() {
        return 2071862118;
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "OS_SYNCSRV_BG_SYNC";
    }

    /* access modifiers changed from: package-private */
    public void p(Context context) {
        synchronized (e1.f10610c) {
            try {
                this.f10394d = 0L;
                if (!h0.m(context)) {
                    a(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(Context context, long j10) {
        o3.v vVar = o3.v.VERBOSE;
        o3.a(vVar, "OSSyncService scheduleLocationUpdateTask:delayMs: " + j10);
        t(context, j10);
    }

    /* access modifiers changed from: protected */
    public void s(Context context) {
        o3.a(o3.v.VERBOSE, "OSSyncService scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 30000");
        t(context, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    /* access modifiers changed from: protected */
    public void t(Context context, long j10) {
        synchronized (e1.f10610c) {
            try {
                if (this.f10394d.longValue() == 0 || o3.w0().b() + j10 <= this.f10394d.longValue()) {
                    if (j10 < 5000) {
                        j10 = 5000;
                    }
                    i(context, j10);
                    this.f10394d = Long.valueOf(o3.w0().b() + j10);
                    return;
                }
                o3.a(o3.v.VERBOSE, "OSSyncService scheduleSyncTask already update scheduled nextScheduledSyncTimeMs: " + this.f10394d);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
