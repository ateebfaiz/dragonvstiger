package kotlinx.coroutines.sync;

import cc.a0;
import cc.z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.channels.h;

public class c implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1183c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1184d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1185e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1186f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1187g;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f1188a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1 f1189b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* synthetic */ class a extends j implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1190a = new a();

        a() {
            super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final d c(long j10, d dVar) {
            return SemaphoreKt.h(j10, dVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c(((Number) obj).longValue(), (d) obj2);
        }
    }

    /* synthetic */ class b extends j implements Function2 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1191a = new b();

        b() {
            super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final d c(long j10, d dVar) {
            return SemaphoreKt.h(j10, dVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c(((Number) obj).longValue(), (d) obj2);
        }
    }

    static {
        Class<c> cls = c.class;
        Class<Object> cls2 = Object.class;
        f1183c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        f1184d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f1185e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f1186f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f1187g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    static /* synthetic */ Object f(c cVar, d dVar) {
        if (cVar.j() > 0) {
            return Unit.f12577a;
        }
        Object g10 = cVar.g(dVar);
        if (g10 == kotlin.coroutines.intrinsics.b.c()) {
            return g10;
        }
        return Unit.f12577a;
    }

    private final Object g(d dVar) {
        CancellableContinuationImpl b10 = kotlinx.coroutines.j.b(kotlin.coroutines.intrinsics.b.b(dVar));
        try {
            if (!h(b10)) {
                e(b10);
            }
            Object A = b10.A();
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                e.c(dVar);
            }
            if (A == kotlin.coroutines.intrinsics.b.c()) {
                return A;
            }
            return Unit.f12577a;
        } catch (Throwable th) {
            b10.N();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final boolean h(b2 b2Var) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1185e;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f1186f.getAndIncrement(this);
        a aVar = a.f1190a;
        long f10 = andIncrement / ((long) SemaphoreKt.f1182f);
        loop0:
        while (true) {
            c10 = cc.c.c(dVar, f10, aVar);
            if (a0.c(c10)) {
                break;
            }
            z b10 = a0.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f113c >= b10.f113c) {
                    break loop0;
                } else if (b10.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            }
        }
        d dVar2 = (d) a0.b(c10);
        int f11 = (int) (andIncrement % ((long) SemaphoreKt.f1182f));
        if (h.a(dVar2.r(), f11, (Object) null, b2Var)) {
            b2Var.f(dVar2, f11);
            return true;
        }
        if (!h.a(dVar2.r(), f11, SemaphoreKt.f1178b, SemaphoreKt.f1179c)) {
            return false;
        }
        if (b2Var instanceof CancellableContinuation) {
            m.d(b2Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation) b2Var).t(Unit.f12577a, this.f1189b);
        } else if (b2Var instanceof kotlinx.coroutines.selects.j) {
            ((kotlinx.coroutines.selects.j) b2Var).g(Unit.f12577a);
        } else {
            throw new IllegalStateException(("unexpected: " + b2Var).toString());
        }
        return true;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void i() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f1187g
            int r1 = r0.get(r3)
            int r2 = r3.f1188a
            if (r1 <= r2) goto L_0x0010
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.c.i():void");
    }

    private final int j() {
        int andDecrement;
        do {
            andDecrement = f1187g.getAndDecrement(this);
        } while (andDecrement > this.f1188a);
        return andDecrement;
    }

    private final boolean m(Object obj) {
        if (obj instanceof CancellableContinuation) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object l10 = cancellableContinuation.l(Unit.f12577a, (Object) null, this.f1189b);
            if (l10 == null) {
                return false;
            }
            cancellableContinuation.D(l10);
            return true;
        } else if (obj instanceof kotlinx.coroutines.selects.j) {
            return ((kotlinx.coroutines.selects.j) obj).c(this, Unit.f12577a);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    private final boolean n() {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1183c;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f1184d.getAndIncrement(this);
        long f10 = andIncrement / ((long) SemaphoreKt.f1182f);
        b bVar = b.f1191a;
        loop0:
        while (true) {
            c10 = cc.c.c(dVar, f10, bVar);
            if (a0.c(c10)) {
                break;
            }
            z b10 = a0.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f113c >= b10.f113c) {
                    break loop0;
                } else if (b10.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            }
        }
        d dVar2 = (d) a0.b(c10);
        dVar2.b();
        int i10 = (dVar2.f113c > f10 ? 1 : (dVar2.f113c == f10 ? 0 : -1));
        if (i10 > 0) {
            return false;
        }
        int f11 = (int) (andIncrement % ((long) SemaphoreKt.f1182f));
        Object andSet = dVar2.r().getAndSet(f11, SemaphoreKt.f1178b);
        if (andSet == null) {
            int d10 = SemaphoreKt.f1177a;
            for (int i11 = 0; i11 < d10; i11++) {
                if (dVar2.r().get(f11) == SemaphoreKt.f1179c) {
                    return true;
                }
            }
            return !h.a(dVar2.r(), f11, SemaphoreKt.f1178b, SemaphoreKt.f1180d);
        } else if (andSet == SemaphoreKt.f1181e) {
            return false;
        } else {
            return m(andSet);
        }
    }

    public Object a(d dVar) {
        return f(this, dVar);
    }

    /* access modifiers changed from: protected */
    public final void e(CancellableContinuation cancellableContinuation) {
        while (j() <= 0) {
            m.d(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (h((b2) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.t(Unit.f12577a, this.f1189b);
    }

    public int k() {
        return Math.max(f1187g.get(this), 0);
    }

    public boolean l() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1187g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f1188a) {
                i();
            } else if (i10 <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f1187g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f1188a
            if (r0 >= r1) goto L_0x0014
            if (r0 < 0) goto L_0x000d
            return
        L_0x000d:
            boolean r0 = r3.n()
            if (r0 == 0) goto L_0x0000
            return
        L_0x0014:
            r3.i()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r2 = r3.f1188a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.c.release():void");
    }
}
