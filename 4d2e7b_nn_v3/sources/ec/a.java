package ec;

import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import cc.c0;
import cc.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlinx.coroutines.f0;

public final class a implements Executor, Closeable {
    public static final c0 C = new c0("NOT_IN_STACK");

    /* renamed from: h  reason: collision with root package name */
    public static final C0002a f168h = new C0002a((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f169i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f170j;

    /* renamed from: w  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f171w;
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f172a;

    /* renamed from: b  reason: collision with root package name */
    public final int f173b;

    /* renamed from: c  reason: collision with root package name */
    public final long f174c;
    private volatile long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f175d;

    /* renamed from: e  reason: collision with root package name */
    public final d f176e;

    /* renamed from: f  reason: collision with root package name */
    public final d f177f;

    /* renamed from: g  reason: collision with root package name */
    public final y f178g;
    private volatile long parkedWorkersStack;

    /* renamed from: ec.a$a  reason: collision with other inner class name */
    public static final class C0002a {
        private C0002a() {
        }

        public /* synthetic */ C0002a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f179a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                ec.a$d[] r0 = ec.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                ec.a$d r1 = ec.a.d.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                ec.a$d r1 = ec.a.d.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                ec.a$d r1 = ec.a.d.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                ec.a$d r1 = ec.a.d.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                ec.a$d r1 = ec.a.d.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f179a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ec.a.b.<clinit>():void");
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<a> cls = a.class;
        f169i = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f170j = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f171w = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public a(int i10, int i11, long j10, String str) {
        this.f172a = i10;
        this.f173b = i11;
        this.f174c = j10;
        this.f175d = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        } else if (i11 < i10) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        } else if (i11 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j10 > 0) {
            this.f176e = new d();
            this.f177f = new d();
            this.f178g = new y((i10 + 1) * 2);
            this.controlState = ((long) i10) << 42;
            this._isTerminated = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
    }

    private final void E(long j10, boolean z10) {
        if (!z10 && !K() && !I(j10)) {
            K();
        }
    }

    private final h H(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f183c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.taskContext.b() == 0 && cVar.f183c == d.BLOCKING) {
            return hVar;
        }
        cVar.f187g = true;
        return cVar.f181a.a(hVar, z10);
    }

    private final boolean I(long j10) {
        if (l.c(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f172a) {
            int j11 = j();
            if (j11 == 1 && this.f172a > 1) {
                j();
            }
            if (j11 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean J(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f170j.get(aVar);
        }
        return aVar.I(j10);
    }

    private final boolean K() {
        c w10;
        do {
            w10 = w();
            if (w10 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(w10, -1, 0));
        LockSupport.unpark(w10);
        return true;
    }

    private final boolean b(h hVar) {
        if (hVar.taskContext.b() == 1) {
            return this.f177f.a(hVar);
        }
        return this.f176e.a(hVar);
    }

    private final int j() {
        synchronized (this.f178g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f170j;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                int c10 = l.c(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (c10 >= this.f172a) {
                    return 0;
                }
                if (i10 >= this.f173b) {
                    return 0;
                }
                int i11 = ((int) (f170j.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f178g.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(this, i11);
                this.f178g.c(i11, cVar);
                if (i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i12 = c10 + 1;
                    cVar.start();
                    return i12;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final c m() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !m.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void p(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f212g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.n(runnable, iVar, z10);
    }

    private final int v(c cVar) {
        Object i10 = cVar.i();
        while (i10 != C) {
            if (i10 == null) {
                return 0;
            }
            c cVar2 = (c) i10;
            int h10 = cVar2.h();
            if (h10 != 0) {
                return h10;
            }
            i10 = cVar2.i();
        }
        return -1;
    }

    private final c w() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f169i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f178g.b((int) (2097151 & j10));
            if (cVar == null) {
                return null;
            }
            long j11 = (2097152 + j10) & -2097152;
            int v10 = v(cVar);
            if (v10 >= 0) {
                if (f169i.compareAndSet(this, j10, ((long) v10) | j11)) {
                    cVar.r(C);
                    return cVar;
                }
            }
        }
    }

    public final void A(c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f169i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & -2097152;
            if (i12 == i10) {
                if (i11 == 0) {
                    i12 = v(cVar);
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (f169i.compareAndSet(this, j10, j11 | ((long) i12))) {
                    return;
                }
            }
        }
    }

    public final void B(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            kotlinx.coroutines.b.a();
            throw th;
        }
        kotlinx.coroutines.b.a();
    }

    public final void C(long j10) {
        int i10;
        h hVar;
        if (f171w.compareAndSet(this, 0, 1)) {
            c m10 = m();
            synchronized (this.f178g) {
                i10 = (int) (f170j.get(this) & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    Object b10 = this.f178g.b(i11);
                    m.c(b10);
                    c cVar = (c) b10;
                    if (cVar != m10) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f181a.f(this.f177f);
                    }
                    if (i11 == i10) {
                        break;
                    }
                    i11++;
                }
            }
            this.f177f.b();
            this.f176e.b();
            while (true) {
                if (m10 != null) {
                    hVar = m10.g(true);
                    if (hVar != null) {
                        continue;
                        B(hVar);
                    }
                }
                hVar = (h) this.f176e.d();
                if (hVar == null && (hVar = (h) this.f177f.d()) == null) {
                    break;
                }
                B(hVar);
            }
            if (m10 != null) {
                m10.u(d.TERMINATED);
            }
            f169i.set(this, 0);
            f170j.set(this, 0);
        }
    }

    public final void G() {
        if (!K() && !J(this, 0, 1, (Object) null)) {
            K();
        }
    }

    public void close() {
        C(WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public void execute(Runnable runnable) {
        p(this, runnable, (i) null, false, 6, (Object) null);
    }

    public final boolean isTerminated() {
        if (f171w.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final h k(Runnable runnable, i iVar) {
        long a10 = l.f211f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a10, iVar);
        }
        h hVar = (h) runnable;
        hVar.submissionTime = a10;
        hVar.taskContext = iVar;
        return hVar;
    }

    public final void n(Runnable runnable, i iVar, boolean z10) {
        boolean z11;
        long j10;
        kotlinx.coroutines.b.a();
        h k10 = k(runnable, iVar);
        boolean z12 = false;
        if (k10.taskContext.b() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            j10 = f170j.addAndGet(this, 2097152);
        } else {
            j10 = 0;
        }
        c m10 = m();
        h H = H(m10, k10, z10);
        if (H == null || b(H)) {
            if (z10 && m10 != null) {
                z12 = true;
            }
            if (z11) {
                E(j10, z12);
            } else if (!z12) {
                G();
            }
        } else {
            throw new RejectedExecutionException(this.f175d + " was terminated");
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f178g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c cVar = (c) this.f178g.b(i15);
            if (cVar != null) {
                int e10 = cVar.f181a.e();
                int i16 = b.f179a[cVar.f183c.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e10);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(e10);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (e10 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(e10);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = f170j.get(this);
        return this.f175d + '@' + f0.b(this) + "[Pool Size {core = " + this.f172a + ", max = " + this.f173b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f176e.c() + ", global blocking queue size = " + this.f177f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f172a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final boolean z(c cVar) {
        long j10;
        int h10;
        if (cVar.i() != C) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f169i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            h10 = cVar.h();
            cVar.r(this.f178g.b((int) (2097151 & j10)));
        } while (!f169i.compareAndSet(this, j10, ((2097152 + j10) & -2097152) | ((long) h10)));
        return true;
    }

    public final class c extends Thread {

        /* renamed from: i  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f180i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final n f181a;

        /* renamed from: b  reason: collision with root package name */
        private final kotlin.jvm.internal.y f182b;

        /* renamed from: c  reason: collision with root package name */
        public d f183c;

        /* renamed from: d  reason: collision with root package name */
        private long f184d;

        /* renamed from: e  reason: collision with root package name */
        private long f185e;

        /* renamed from: f  reason: collision with root package name */
        private int f186f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f187g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f181a = new n();
            this.f182b = new kotlin.jvm.internal.y();
            this.f183c = d.DORMANT;
            this.nextParkedWorker = a.C;
            this.f186f = kotlin.random.c.f729a.c();
        }

        private final void b(int i10) {
            if (i10 != 0) {
                a.f170j.addAndGet(a.this, -2097152);
                if (this.f183c != d.TERMINATED) {
                    this.f183c = d.DORMANT;
                }
            }
        }

        private final void c(int i10) {
            if (i10 != 0 && u(d.BLOCKING)) {
                a.this.G();
            }
        }

        private final void d(h hVar) {
            int b10 = hVar.taskContext.b();
            k(b10);
            c(b10);
            a.this.B(hVar);
            b(b10);
        }

        private final h e(boolean z10) {
            boolean z11;
            h o10;
            h o11;
            if (z10) {
                if (m(a.this.f172a * 2) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (o11 = o()) != null) {
                    return o11;
                }
                h g10 = this.f181a.g();
                if (g10 != null) {
                    return g10;
                }
                if (!z11 && (o10 = o()) != null) {
                    return o10;
                }
            } else {
                h o12 = o();
                if (o12 != null) {
                    return o12;
                }
            }
            return v(3);
        }

        private final h f() {
            h h10 = this.f181a.h();
            if (h10 != null) {
                return h10;
            }
            h hVar = (h) a.this.f177f.d();
            if (hVar == null) {
                return v(1);
            }
            return hVar;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f180i;
        }

        private final void k(int i10) {
            this.f184d = 0;
            if (this.f183c == d.PARKING) {
                this.f183c = d.BLOCKING;
            }
        }

        private final boolean l() {
            if (this.nextParkedWorker != a.C) {
                return true;
            }
            return false;
        }

        private final void n() {
            if (this.f184d == 0) {
                this.f184d = System.nanoTime() + a.this.f174c;
            }
            LockSupport.parkNanos(a.this.f174c);
            if (System.nanoTime() - this.f184d >= 0) {
                this.f184d = 0;
                w();
            }
        }

        private final h o() {
            if (m(2) == 0) {
                h hVar = (h) a.this.f176e.d();
                if (hVar != null) {
                    return hVar;
                }
                return (h) a.this.f177f.d();
            }
            h hVar2 = (h) a.this.f177f.d();
            if (hVar2 != null) {
                return hVar2;
            }
            return (h) a.this.f176e.d();
        }

        private final void p() {
            loop0:
            while (true) {
                boolean z10 = false;
                while (!a.this.isTerminated() && this.f183c != d.TERMINATED) {
                    h g10 = g(this.f187g);
                    if (g10 != null) {
                        this.f185e = 0;
                        d(g10);
                    } else {
                        this.f187g = false;
                        if (this.f185e == 0) {
                            t();
                        } else if (!z10) {
                            z10 = true;
                        } else {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f185e);
                            this.f185e = 0;
                        }
                    }
                }
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            long j10;
            if (this.f183c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater a10 = a.f170j;
            do {
                j10 = a10.get(aVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f170j.compareAndSet(aVar, j10, j10 - 4398046511104L));
            this.f183c = d.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                a.this.z(this);
                return;
            }
            f180i.set(this, -1);
            while (l() && f180i.get(this) == -1 && !a.this.isTerminated() && this.f183c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i10) {
            int i11 = (int) (a.f170j.get(a.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int m10 = m(i11);
            a aVar = a.this;
            long j10 = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                m10++;
                if (m10 > i11) {
                    m10 = 1;
                }
                c cVar = (c) aVar.f178g.b(m10);
                if (cVar == null || cVar == this) {
                    int i13 = i10;
                } else {
                    long n10 = cVar.f181a.n(i10, this.f182b);
                    if (n10 == -1) {
                        kotlin.jvm.internal.y yVar = this.f182b;
                        h hVar = (h) yVar.f725a;
                        yVar.f725a = null;
                        return hVar;
                    } else if (n10 > 0) {
                        j10 = Math.min(j10, n10);
                    }
                }
            }
            if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                j10 = 0;
            }
            this.f185e = j10;
            return null;
        }

        private final void w() {
            a aVar = a.this;
            synchronized (aVar.f178g) {
                try {
                    if (!aVar.isTerminated()) {
                        if (((int) (a.f170j.get(aVar) & 2097151)) > aVar.f172a) {
                            if (f180i.compareAndSet(this, -1, 1)) {
                                int i10 = this.indexInArray;
                                q(0);
                                aVar.A(this, i10, 0);
                                int andDecrement = (int) (a.f170j.getAndDecrement(aVar) & 2097151);
                                if (andDecrement != i10) {
                                    Object b10 = aVar.f178g.b(andDecrement);
                                    m.c(b10);
                                    c cVar = (c) b10;
                                    aVar.f178g.c(i10, cVar);
                                    cVar.q(i10);
                                    aVar.A(cVar, andDecrement, i10);
                                }
                                aVar.f178g.c(andDecrement, (Object) null);
                                Unit unit = Unit.f12577a;
                                this.f183c = d.TERMINATED;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final h g(boolean z10) {
            if (s()) {
                return e(z10);
            }
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i10) {
            int i11 = this.f186f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f186f = i14;
            int i15 = i10 - 1;
            if ((i15 & i10) == 0) {
                return i14 & i15;
            }
            return (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void q(int i10) {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.f175d);
            sb2.append("-worker-");
            if (i10 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i10);
            }
            sb2.append(str);
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            boolean z10;
            d dVar2 = this.f183c;
            if (dVar2 == d.CPU_ACQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                a.f170j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f183c = dVar;
            }
            return z10;
        }

        public c(a aVar, int i10) {
            this();
            q(i10);
        }
    }
}
