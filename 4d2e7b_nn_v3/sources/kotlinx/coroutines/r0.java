package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import cc.i0;
import cc.j0;
import cc.q;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlinx.coroutines.i0;

public abstract class r0 extends s0 implements i0 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1119d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1120e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1121f;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    private final class a extends c {

        /* renamed from: c  reason: collision with root package name */
        private final CancellableContinuation f1122c;

        public a(long j10, CancellableContinuation cancellableContinuation) {
            super(j10);
            this.f1122c = cancellableContinuation;
        }

        public void run() {
            this.f1122c.q(r0.this, Unit.f12577a);
        }

        public String toString() {
            return super.toString() + this.f1122c;
        }
    }

    private static final class b extends c {

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f1124c;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.f1124c = runnable;
        }

        public void run() {
            this.f1124c.run();
        }

        public String toString() {
            return super.toString() + this.f1124c;
        }
    }

    public static abstract class c implements Runnable, Comparable, m0, j0 {
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f1125a;

        /* renamed from: b  reason: collision with root package name */
        private int f1126b = -1;

        public c(long j10) {
            this.f1125a = j10;
        }

        public i0 a() {
            Object obj = this._heap;
            if (obj instanceof i0) {
                return (i0) obj;
            }
            return null;
        }

        public void c(i0 i0Var) {
            if (this._heap != u0.f1195a) {
                this._heap = i0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public void d(int i10) {
            this.f1126b = i10;
        }

        public final void dispose() {
            d dVar;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj != u0.f1195a) {
                        if (obj instanceof d) {
                            dVar = (d) obj;
                        } else {
                            dVar = null;
                        }
                        if (dVar != null) {
                            dVar.g(this);
                        }
                        this._heap = u0.f1195a;
                        Unit unit = Unit.f12577a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: e */
        public int compareTo(c cVar) {
            int i10 = ((this.f1125a - cVar.f1125a) > 0 ? 1 : ((this.f1125a - cVar.f1125a) == 0 ? 0 : -1));
            if (i10 > 0) {
                return 1;
            }
            if (i10 < 0) {
                return -1;
            }
            return 0;
        }

        public final int f(long j10, d dVar, r0 r0Var) {
            synchronized (this) {
                if (this._heap == u0.f1195a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (r0Var.X()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.f1127c = j10;
                        } else {
                            long j11 = cVar.f1125a;
                            if (j11 - j10 < 0) {
                                j10 = j11;
                            }
                            if (j10 - dVar.f1127c > 0) {
                                dVar.f1127c = j10;
                            }
                        }
                        long j12 = this.f1125a;
                        long j13 = dVar.f1127c;
                        if (j12 - j13 < 0) {
                            this.f1125a = j13;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean g(long j10) {
            if (j10 - this.f1125a >= 0) {
                return true;
            }
            return false;
        }

        public int getIndex() {
            return this.f1126b;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f1125a + ']';
        }
    }

    public static final class d extends i0 {

        /* renamed from: c  reason: collision with root package name */
        public long f1127c;

        public d(long j10) {
            this.f1127c = j10;
        }
    }

    static {
        Class<r0> cls = r0.class;
        Class<Object> cls2 = Object.class;
        f1119d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        f1120e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        f1121f = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    private final void T() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1119d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f1119d, this, (Object) null, u0.f1196b)) {
                    return;
                }
            } else if (obj instanceof q) {
                ((q) obj).d();
                return;
            } else if (obj != u0.f1196b) {
                q qVar = new q(8, true);
                m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f1119d, this, obj, qVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable U() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1119d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof q) {
                m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                q qVar = (q) obj;
                Object j10 = qVar.j();
                if (j10 != q.f100h) {
                    return (Runnable) j10;
                }
                androidx.concurrent.futures.a.a(f1119d, this, obj, qVar.i());
            } else if (obj == u0.f1196b) {
                return null;
            } else {
                if (androidx.concurrent.futures.a.a(f1119d, this, obj, (Object) null)) {
                    m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean W(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1119d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (X()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f1119d, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof q) {
                m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                q qVar = (q) obj;
                int a10 = qVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    androidx.concurrent.futures.a.a(f1119d, this, obj, qVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else if (obj == u0.f1196b) {
                return false;
            } else {
                q qVar2 = new q(8, true);
                m.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f1119d, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean X() {
        if (f1121f.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void a0() {
        c cVar;
        b.a();
        long nanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f1120e.get(this);
            if (dVar != null && (cVar = (c) dVar.i()) != null) {
                Q(nanoTime, cVar);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.r0$d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int d0(long r4, kotlinx.coroutines.r0.c r6) {
        /*
            r3 = this;
            boolean r0 = r3.X()
            if (r0 == 0) goto L_0x0008
            r4 = 1
            return r4
        L_0x0008:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f1120e
            java.lang.Object r1 = r0.get(r3)
            kotlinx.coroutines.r0$d r1 = (kotlinx.coroutines.r0.d) r1
            if (r1 != 0) goto L_0x0025
            kotlinx.coroutines.r0$d r1 = new kotlinx.coroutines.r0$d
            r1.<init>(r4)
            r2 = 0
            androidx.concurrent.futures.a.a(r0, r3, r2, r1)
            java.lang.Object r0 = r0.get(r3)
            kotlin.jvm.internal.m.c(r0)
            r1 = r0
            kotlinx.coroutines.r0$d r1 = (kotlinx.coroutines.r0.d) r1
        L_0x0025:
            int r4 = r6.f(r4, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.r0.d0(long, kotlinx.coroutines.r0$c):int");
    }

    private final void f0(boolean z10) {
        f1121f.set(this, z10 ? 1 : 0);
    }

    private final boolean g0(c cVar) {
        c cVar2;
        d dVar = (d) f1120e.get(this);
        if (dVar != null) {
            cVar2 = (c) dVar.e();
        } else {
            cVar2 = null;
        }
        if (cVar2 == cVar) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long J() {
        c cVar;
        if (super.J() == 0) {
            return 0;
        }
        Object obj = f1119d.get(this);
        if (obj != null) {
            if (obj instanceof q) {
                if (!((q) obj).g()) {
                    return 0;
                }
            } else if (obj == u0.f1196b) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            } else {
                return 0;
            }
        }
        d dVar = (d) f1120e.get(this);
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j10 = cVar.f1125a;
        b.a();
        return l.d(j10 - System.nanoTime(), 0);
    }

    public void V(Runnable runnable) {
        if (W(runnable)) {
            R();
        } else {
            g0.f1085g.V(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean Y() {
        if (!N()) {
            return false;
        }
        d dVar = (d) f1120e.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f1119d.get(this);
        if (obj != null) {
            if (obj instanceof q) {
                return ((q) obj).g();
            }
            if (obj != u0.f1196b) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long Z() {
        /*
            r9 = this;
            boolean r0 = r9.O()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f1120e
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.r0$d r0 = (kotlinx.coroutines.r0.d) r0
            if (r0 == 0) goto L_0x0049
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0049
            kotlinx.coroutines.b.a()
            long r3 = java.lang.System.nanoTime()
        L_0x0020:
            monitor-enter(r0)
            cc.j0 r5 = r0.b()     // Catch:{ all -> 0x0038 }
            r6 = 0
            if (r5 != 0) goto L_0x002a
            monitor-exit(r0)
            goto L_0x0042
        L_0x002a:
            kotlinx.coroutines.r0$c r5 = (kotlinx.coroutines.r0.c) r5     // Catch:{ all -> 0x0038 }
            boolean r7 = r5.g(r3)     // Catch:{ all -> 0x0038 }
            r8 = 0
            if (r7 == 0) goto L_0x003a
            boolean r5 = r9.W(r5)     // Catch:{ all -> 0x0038 }
            goto L_0x003b
        L_0x0038:
            r1 = move-exception
            goto L_0x0047
        L_0x003a:
            r5 = r8
        L_0x003b:
            if (r5 == 0) goto L_0x0041
            cc.j0 r6 = r0.h(r8)     // Catch:{ all -> 0x0038 }
        L_0x0041:
            monitor-exit(r0)
        L_0x0042:
            kotlinx.coroutines.r0$c r6 = (kotlinx.coroutines.r0.c) r6
            if (r6 != 0) goto L_0x0020
            goto L_0x0049
        L_0x0047:
            monitor-exit(r0)
            throw r1
        L_0x0049:
            java.lang.Runnable r0 = r9.U()
            if (r0 == 0) goto L_0x0053
            r0.run()
            return r1
        L_0x0053:
            long r0 = r9.J()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.r0.Z():long");
    }

    /* access modifiers changed from: protected */
    public final void b0() {
        f1119d.set(this, (Object) null);
        f1120e.set(this, (Object) null);
    }

    public final void c0(long j10, c cVar) {
        int d02 = d0(j10, cVar);
        if (d02 != 0) {
            if (d02 == 1) {
                Q(j10, cVar);
            } else if (d02 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (g0(cVar)) {
            R();
        }
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        V(runnable);
    }

    /* access modifiers changed from: protected */
    public final m0 e0(long j10, Runnable runnable) {
        long d10 = u0.d(j10);
        if (d10 >= 4611686018427387903L) {
            return p1.f1110a;
        }
        b.a();
        long nanoTime = System.nanoTime();
        b bVar = new b(d10 + nanoTime, runnable);
        c0(nanoTime, bVar);
        return bVar;
    }

    public void j(long j10, CancellableContinuation cancellableContinuation) {
        long d10 = u0.d(j10);
        if (d10 < 4611686018427387903L) {
            b.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(d10 + nanoTime, cancellableContinuation);
            c0(nanoTime, aVar);
            j.a(cancellableContinuation, aVar);
        }
    }

    public void shutdown() {
        w1.f1199a.b();
        f0(true);
        T();
        do {
        } while (Z() <= 0);
        a0();
    }

    public m0 w(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return i0.a.a(this, j10, runnable, coroutineContext);
    }
}
