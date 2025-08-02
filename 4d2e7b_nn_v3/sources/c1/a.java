package c1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f17205a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f17206b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f17207c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f17208d;

    /* renamed from: e  reason: collision with root package name */
    private final ExecutorService f17209e;

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17212a;

        static {
            int[] iArr = new int[s.values().length];
            iArr[s.ERROR_REQUEST.ordinal()] = 1;
            iArr[s.SESSION_REQUEST.ordinal()] = 2;
            iArr[s.IO.ordinal()] = 3;
            iArr[s.INTERNAL_REPORT.ordinal()] = 4;
            iArr[s.DEFAULT.ordinal()] = 5;
            f17212a = iArr;
        }
    }

    public a() {
        this((ExecutorService) null, (ExecutorService) null, (ExecutorService) null, (ExecutorService) null, (ExecutorService) null, 31, (DefaultConstructorMarker) null);
    }

    private final void a(ExecutorService executorService) {
        try {
            executorService.awaitTermination(1500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
    }

    public final void b(s sVar, Runnable runnable) {
        int i10 = b.f17212a[sVar.ordinal()];
        if (i10 == 1) {
            this.f17205a.execute(runnable);
        } else if (i10 == 2) {
            this.f17206b.execute(runnable);
        } else if (i10 == 3) {
            this.f17207c.execute(runnable);
        } else if (i10 == 4) {
            this.f17208d.execute(runnable);
        } else if (i10 == 5) {
            this.f17209e.execute(runnable);
        }
    }

    public final void c() {
        this.f17208d.shutdownNow();
        this.f17209e.shutdownNow();
        this.f17205a.shutdown();
        this.f17206b.shutdown();
        this.f17207c.shutdown();
        a(this.f17205a);
        a(this.f17206b);
        a(this.f17207c);
    }

    public final Future d(s sVar, Runnable runnable) {
        return e(sVar, Executors.callable(runnable));
    }

    public final Future e(s sVar, Callable callable) {
        FutureTask futureTask = new FutureTask(callable);
        b(sVar, futureTask);
        return new C0222a(futureTask, sVar);
    }

    /* renamed from: c1.a$a  reason: collision with other inner class name */
    private static final class C0222a implements Future {

        /* renamed from: a  reason: collision with root package name */
        private final FutureTask f17210a;

        /* renamed from: b  reason: collision with root package name */
        private final s f17211b;

        public C0222a(FutureTask futureTask, s sVar) {
            this.f17210a = futureTask;
            this.f17211b = sVar;
        }

        private final void a() {
            if (!this.f17210a.isDone() && c.d(Thread.currentThread()) == this.f17211b) {
                this.f17210a.run();
            }
        }

        public boolean cancel(boolean z10) {
            return this.f17210a.cancel(z10);
        }

        public Object get() {
            a();
            return this.f17210a.get();
        }

        public boolean isCancelled() {
            return this.f17210a.isCancelled();
        }

        public boolean isDone() {
            return this.f17210a.isDone();
        }

        public Object get(long j10, TimeUnit timeUnit) {
            a();
            return this.f17210a.get(j10, timeUnit);
        }
    }

    public a(ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3, ExecutorService executorService4, ExecutorService executorService5) {
        this.f17205a = executorService;
        this.f17206b = executorService2;
        this.f17207c = executorService3;
        this.f17208d = executorService4;
        this.f17209e = executorService5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.util.concurrent.ExecutorService r4, java.util.concurrent.ExecutorService r5, java.util.concurrent.ExecutorService r6, java.util.concurrent.ExecutorService r7, java.util.concurrent.ExecutorService r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 1
            if (r10 == 0) goto L_0x000d
            java.lang.String r4 = "Bugsnag Error thread"
            c1.s r10 = c1.s.ERROR_REQUEST
            java.util.concurrent.ExecutorService r4 = c1.c.b(r4, r10, r0)
        L_0x000d:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0019
            java.lang.String r5 = "Bugsnag Session thread"
            c1.s r10 = c1.s.SESSION_REQUEST
            java.util.concurrent.ExecutorService r5 = c1.c.b(r5, r10, r0)
        L_0x0019:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0026
            java.lang.String r5 = "Bugsnag IO thread"
            c1.s r6 = c1.s.IO
            java.util.concurrent.ExecutorService r6 = c1.c.b(r5, r6, r0)
        L_0x0026:
            r0 = r6
            r5 = r9 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0034
            java.lang.String r5 = "Bugsnag Internal Report thread"
            c1.s r7 = c1.s.INTERNAL_REPORT
            java.util.concurrent.ExecutorService r7 = c1.c.b(r5, r7, r6)
        L_0x0034:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0041
            java.lang.String r5 = "Bugsnag Default thread"
            c1.s r7 = c1.s.DEFAULT
            java.util.concurrent.ExecutorService r8 = c1.c.b(r5, r7, r6)
        L_0x0041:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.a.<init>(java.util.concurrent.ExecutorService, java.util.concurrent.ExecutorService, java.util.concurrent.ExecutorService, java.util.concurrent.ExecutorService, java.util.concurrent.ExecutorService, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
