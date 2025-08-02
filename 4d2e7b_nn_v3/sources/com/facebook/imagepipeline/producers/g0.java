package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import e5.j;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f20086a;

    /* renamed from: b  reason: collision with root package name */
    private final d f20087b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f20088c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f20089d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final int f20090e;

    /* renamed from: f  reason: collision with root package name */
    j f20091f = null;

    /* renamed from: g  reason: collision with root package name */
    int f20092g = 0;

    /* renamed from: h  reason: collision with root package name */
    f f20093h = f.IDLE;

    /* renamed from: i  reason: collision with root package name */
    long f20094i = 0;

    /* renamed from: j  reason: collision with root package name */
    long f20095j = 0;

    class a implements Runnable {
        a() {
        }

        public void run() {
            g0.this.d();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            g0.this.j();
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20098a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.imagepipeline.producers.g0$f[] r0 = com.facebook.imagepipeline.producers.g0.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20098a = r0
                com.facebook.imagepipeline.producers.g0$f r1 = com.facebook.imagepipeline.producers.g0.f.IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20098a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.imagepipeline.producers.g0$f r1 = com.facebook.imagepipeline.producers.g0.f.QUEUED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20098a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.imagepipeline.producers.g0$f r1 = com.facebook.imagepipeline.producers.g0.f.RUNNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20098a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.imagepipeline.producers.g0$f r1 = com.facebook.imagepipeline.producers.g0.f.RUNNING_AND_PENDING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.g0.c.<clinit>():void");
        }
    }

    public interface d {
        void a(j jVar, int i10);
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private static ScheduledExecutorService f20099a;

        static ScheduledExecutorService a() {
            if (f20099a == null) {
                f20099a = Executors.newSingleThreadScheduledExecutor();
            }
            return f20099a;
        }
    }

    enum f {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public g0(Executor executor, d dVar, int i10) {
        this.f20086a = executor;
        this.f20087b = dVar;
        this.f20090e = i10;
    }

    /* access modifiers changed from: private */
    public void d() {
        j jVar;
        int i10;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            jVar = this.f20091f;
            i10 = this.f20092g;
            this.f20091f = null;
            this.f20092g = 0;
            this.f20093h = f.RUNNING;
            this.f20095j = uptimeMillis;
        }
        try {
            if (i(jVar, i10)) {
                this.f20087b.a(jVar, i10);
            }
        } finally {
            j.h(jVar);
            g();
        }
    }

    private void e(long j10) {
        Runnable a10 = f5.a.a(this.f20089d, "JobScheduler_enqueueJob");
        if (j10 > 0) {
            e.a().schedule(a10, j10, TimeUnit.MILLISECONDS);
        } else {
            a10.run();
        }
    }

    private void g() {
        boolean z10;
        long j10;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            try {
                if (this.f20093h == f.RUNNING_AND_PENDING) {
                    j10 = Math.max(this.f20095j + ((long) this.f20090e), uptimeMillis);
                    this.f20094i = uptimeMillis;
                    this.f20093h = f.QUEUED;
                    z10 = true;
                } else {
                    this.f20093h = f.IDLE;
                    j10 = 0;
                    z10 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z10) {
            e(j10 - uptimeMillis);
        }
    }

    private static boolean i(j jVar, int i10) {
        if (c.d(i10) || c.m(i10, 4) || j.J(jVar)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f20086a.execute(f5.a.a(this.f20088c, "JobScheduler_submitJob"));
    }

    public void c() {
        j jVar;
        synchronized (this) {
            jVar = this.f20091f;
            this.f20091f = null;
            this.f20092g = 0;
        }
        j.h(jVar);
    }

    public synchronized long f() {
        return this.f20095j - this.f20094i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r3 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        e(r5 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            monitor-enter(r7)
            e5.j r2 = r7.f20091f     // Catch:{ all -> 0x0012 }
            int r3 = r7.f20092g     // Catch:{ all -> 0x0012 }
            boolean r2 = i(r2, r3)     // Catch:{ all -> 0x0012 }
            r3 = 0
            if (r2 != 0) goto L_0x0014
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            return r3
        L_0x0012:
            r0 = move-exception
            goto L_0x0045
        L_0x0014:
            int[] r2 = com.facebook.imagepipeline.producers.g0.c.f20098a     // Catch:{ all -> 0x0012 }
            com.facebook.imagepipeline.producers.g0$f r4 = r7.f20093h     // Catch:{ all -> 0x0012 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x0012 }
            r2 = r2[r4]     // Catch:{ all -> 0x0012 }
            r4 = 1
            if (r2 == r4) goto L_0x002c
            r5 = 3
            if (r2 == r5) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            com.facebook.imagepipeline.producers.g0$f r2 = com.facebook.imagepipeline.producers.g0.f.RUNNING_AND_PENDING     // Catch:{ all -> 0x0012 }
            r7.f20093h = r2     // Catch:{ all -> 0x0012 }
        L_0x0029:
            r5 = 0
            goto L_0x003d
        L_0x002c:
            long r2 = r7.f20095j     // Catch:{ all -> 0x0012 }
            int r5 = r7.f20090e     // Catch:{ all -> 0x0012 }
            long r5 = (long) r5     // Catch:{ all -> 0x0012 }
            long r2 = r2 + r5
            long r5 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x0012 }
            r7.f20094i = r0     // Catch:{ all -> 0x0012 }
            com.facebook.imagepipeline.producers.g0$f r2 = com.facebook.imagepipeline.producers.g0.f.QUEUED     // Catch:{ all -> 0x0012 }
            r7.f20093h = r2     // Catch:{ all -> 0x0012 }
            r3 = r4
        L_0x003d:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x0044
            long r5 = r5 - r0
            r7.e(r5)
        L_0x0044:
            return r4
        L_0x0045:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.g0.h():boolean");
    }

    public boolean k(j jVar, int i10) {
        j jVar2;
        if (!i(jVar, i10)) {
            return false;
        }
        synchronized (this) {
            jVar2 = this.f20091f;
            this.f20091f = j.b(jVar);
            this.f20092g = i10;
        }
        j.h(jVar2);
        return true;
    }
}
