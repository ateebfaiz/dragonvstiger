package kotlinx.coroutines;

import cc.n;
import cc.o;
import cc.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.f1;

public class JobSupport implements f1, o, r1 {
    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private volatile Object _parentHandle;
    private volatile Object _state;

    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        /* access modifiers changed from: protected */
        public String L() {
            return "AwaitContinuation";
        }

        public Throwable y(f1 f1Var) {
            Throwable f10;
            Object c02 = this.job.c0();
            if ((c02 instanceof b) && (f10 = ((b) c02).f()) != null) {
                return f10;
            }
            if (c02 instanceof s) {
                return ((s) c02).f1129a;
            }
            return f1Var.n();
        }
    }

    private static final class a extends l1 {

        /* renamed from: e  reason: collision with root package name */
        private final JobSupport f837e;

        /* renamed from: f  reason: collision with root package name */
        private final b f838f;

        /* renamed from: g  reason: collision with root package name */
        private final n f839g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f840h;

        public a(JobSupport jobSupport, b bVar, n nVar, Object obj) {
            this.f837e = jobSupport;
            this.f838f = bVar;
            this.f839g = nVar;
            this.f840h = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.f12577a;
        }

        public void s(Throwable th) {
            this.f837e.S(this.f838f, this.f839g, this.f840h);
        }
    }

    private static final class b implements z0 {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f841b;

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f842c;

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f843d;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final o1 f844a;

        static {
            Class<b> cls = b.class;
            f841b = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
            Class<Object> cls2 = Object.class;
            f842c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
            f843d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
        }

        public b(o1 o1Var, boolean z10, Throwable th) {
            this.f844a = o1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList d() {
            return new ArrayList(4);
        }

        private final Object e() {
            return f843d.get(this);
        }

        private final void l(Object obj) {
            f843d.set(this, obj);
        }

        public boolean a() {
            if (f() == null) {
                return true;
            }
            return false;
        }

        public final void b(Throwable th) {
            Throwable f10 = f();
            if (f10 == null) {
                m(th);
            } else if (th != f10) {
                Object e10 = e();
                if (e10 == null) {
                    l(th);
                } else if (e10 instanceof Throwable) {
                    if (th != e10) {
                        ArrayList d10 = d();
                        d10.add(e10);
                        d10.add(th);
                        l(d10);
                    }
                } else if (e10 instanceof ArrayList) {
                    ((ArrayList) e10).add(th);
                } else {
                    throw new IllegalStateException(("State is " + e10).toString());
                }
            }
        }

        public o1 c() {
            return this.f844a;
        }

        public final Throwable f() {
            return (Throwable) f842c.get(this);
        }

        public final boolean g() {
            if (f() != null) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            if (f841b.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean i() {
            if (e() == m1.f1103e) {
                return true;
            }
            return false;
        }

        public final List j(Throwable th) {
            ArrayList arrayList;
            Object e10 = e();
            if (e10 == null) {
                arrayList = d();
            } else if (e10 instanceof Throwable) {
                ArrayList d10 = d();
                d10.add(e10);
                arrayList = d10;
            } else if (e10 instanceof ArrayList) {
                arrayList = (ArrayList) e10;
            } else {
                throw new IllegalStateException(("State is " + e10).toString());
            }
            Throwable f10 = f();
            if (f10 != null) {
                arrayList.add(0, f10);
            }
            if (th != null && !m.b(th, f10)) {
                arrayList.add(th);
            }
            l(m1.f1103e);
            return arrayList;
        }

        public final void k(boolean z10) {
            f841b.set(this, z10 ? 1 : 0);
        }

        public final void m(Throwable th) {
            f842c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + c() + ']';
        }
    }

    public static final class c extends o.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JobSupport f845d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f846e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(o oVar, JobSupport jobSupport, Object obj) {
            super(oVar);
            this.f845d = jobSupport;
            this.f846e = obj;
        }

        /* renamed from: f */
        public Object d(o oVar) {
            if (this.f845d.c0() == this.f846e) {
                return null;
            }
            return n.a();
        }
    }

    static {
        Class<JobSupport> cls = JobSupport.class;
        Class<Object> cls2 = Object.class;
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public JobSupport(boolean z10) {
        p0 p0Var;
        if (z10) {
            p0Var = m1.f1105g;
        } else {
            p0Var = m1.f1104f;
        }
        this._state = p0Var;
    }

    public static /* synthetic */ CancellationException B0(JobSupport jobSupport, Throwable th, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return jobSupport.A0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean D0(z0 z0Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(_state$FU, this, z0Var, m1.g(obj))) {
            return false;
        }
        r0((Throwable) null);
        s0(obj);
        R(z0Var, obj);
        return true;
    }

    private final boolean E0(z0 z0Var, Throwable th) {
        o1 a02 = a0(z0Var);
        if (a02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(_state$FU, this, z0Var, new b(a02, false, th))) {
            return false;
        }
        p0(a02, th);
        return true;
    }

    private final Object F0(Object obj, Object obj2) {
        if (!(obj instanceof z0)) {
            return m1.f1099a;
        }
        if ((!(obj instanceof p0) && !(obj instanceof l1)) || (obj instanceof n) || (obj2 instanceof s)) {
            return G0((z0) obj, obj2);
        }
        if (D0((z0) obj, obj2)) {
            return obj2;
        }
        return m1.f1101c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        if (r2 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        p0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        r8 = V(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006f, code lost:
        if (r8 == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0075, code lost:
        if (H0(r1, r8, r9) == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0079, code lost:
        return kotlinx.coroutines.m1.f1100b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007e, code lost:
        return U(r1, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object G0(kotlinx.coroutines.z0 r8, java.lang.Object r9) {
        /*
            r7 = this;
            kotlinx.coroutines.o1 r0 = r7.a0(r8)
            if (r0 != 0) goto L_0x000b
            cc.c0 r8 = kotlinx.coroutines.m1.f1101c
            return r8
        L_0x000b:
            boolean r1 = r8 instanceof kotlinx.coroutines.JobSupport.b
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r8
            kotlinx.coroutines.JobSupport$b r1 = (kotlinx.coroutines.JobSupport.b) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$b r1 = new kotlinx.coroutines.JobSupport$b
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.y r3 = new kotlin.jvm.internal.y
            r3.<init>()
            monitor-enter(r1)
            boolean r4 = r1.h()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0031
            cc.c0 r8 = kotlinx.coroutines.m1.f1099a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r8
        L_0x002f:
            r8 = move-exception
            goto L_0x007f
        L_0x0031:
            r4 = 1
            r1.k(r4)     // Catch:{ all -> 0x002f }
            if (r1 == r8) goto L_0x0045
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = _state$FU     // Catch:{ all -> 0x002f }
            boolean r5 = androidx.concurrent.futures.a.a(r5, r7, r8, r1)     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x0045
            cc.c0 r8 = kotlinx.coroutines.m1.f1101c     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r8
        L_0x0045:
            boolean r5 = r1.g()     // Catch:{ all -> 0x002f }
            boolean r6 = r9 instanceof kotlinx.coroutines.s     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x0051
            r6 = r9
            kotlinx.coroutines.s r6 = (kotlinx.coroutines.s) r6     // Catch:{ all -> 0x002f }
            goto L_0x0052
        L_0x0051:
            r6 = r2
        L_0x0052:
            if (r6 == 0) goto L_0x0059
            java.lang.Throwable r6 = r6.f1129a     // Catch:{ all -> 0x002f }
            r1.b(r6)     // Catch:{ all -> 0x002f }
        L_0x0059:
            java.lang.Throwable r6 = r1.f()     // Catch:{ all -> 0x002f }
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0061
            r2 = r6
        L_0x0061:
            r3.f725a = r2     // Catch:{ all -> 0x002f }
            kotlin.Unit r3 = kotlin.Unit.f12577a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x006b
            r7.p0(r0, r2)
        L_0x006b:
            kotlinx.coroutines.n r8 = r7.V(r8)
            if (r8 == 0) goto L_0x007a
            boolean r8 = r7.H0(r1, r8, r9)
            if (r8 == 0) goto L_0x007a
            cc.c0 r8 = kotlinx.coroutines.m1.f1100b
            return r8
        L_0x007a:
            java.lang.Object r8 = r7.U(r1, r9)
            return r8
        L_0x007f:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.G0(kotlinx.coroutines.z0, java.lang.Object):java.lang.Object");
    }

    private final boolean H(Object obj, o1 o1Var, l1 l1Var) {
        int r10;
        c cVar = new c(l1Var, this, obj);
        do {
            r10 = o1Var.m().r(l1Var, o1Var, cVar);
            if (r10 == 1) {
                return true;
            }
        } while (r10 != 2);
        return false;
    }

    private final boolean H0(b bVar, n nVar, Object obj) {
        while (f1.a.d(nVar.f1106e, false, false, new a(this, bVar, nVar, obj), 1, (Object) null) == p1.f1110a) {
            nVar = o0(nVar);
            if (nVar == null) {
                return false;
            }
        }
        return true;
    }

    private final void I(Throwable th, List list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th2 = (Throwable) it.next();
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    kotlin.b.a(th, th2);
                }
            }
        }
    }

    private final Object N(Object obj) {
        Object F0;
        do {
            Object c02 = c0();
            if (!(c02 instanceof z0) || ((c02 instanceof b) && ((b) c02).h())) {
                return m1.f1099a;
            }
            F0 = F0(c02, new s(T(obj), false, 2, (DefaultConstructorMarker) null));
        } while (F0 == m1.f1101c);
        return F0;
    }

    private final boolean O(Throwable th) {
        if (h0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        m b02 = b0();
        if (b02 == null || b02 == p1.f1110a) {
            return z10;
        }
        if (b02.b(th) || z10) {
            return true;
        }
        return false;
    }

    private final void R(z0 z0Var, Object obj) {
        s sVar;
        m b02 = b0();
        if (b02 != null) {
            b02.dispose();
            x0(p1.f1110a);
        }
        Throwable th = null;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            th = sVar.f1129a;
        }
        if (z0Var instanceof l1) {
            try {
                ((l1) z0Var).s(th);
            } catch (Throwable th2) {
                e0(new v("Exception in completion handler " + z0Var + " for " + this, th2));
            }
        } else {
            o1 c10 = z0Var.c();
            if (c10 != null) {
                q0(c10, th);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void S(b bVar, n nVar, Object obj) {
        n o02 = o0(nVar);
        if (o02 == null || !H0(bVar, o02, obj)) {
            J(U(bVar, obj));
        }
    }

    private final Throwable T(Object obj) {
        boolean z10;
        if (obj == null) {
            z10 = true;
        } else {
            z10 = obj instanceof Throwable;
        }
        if (z10) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new g1(P(), (Throwable) null, this);
            }
            return th;
        }
        m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((r1) obj).A();
    }

    private final Object U(b bVar, Object obj) {
        s sVar;
        Throwable th;
        boolean g10;
        Throwable X;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            th = sVar.f1129a;
        } else {
            th = null;
        }
        synchronized (bVar) {
            g10 = bVar.g();
            List j10 = bVar.j(th);
            X = X(bVar, j10);
            if (X != null) {
                I(X, j10);
            }
        }
        if (!(X == null || X == th)) {
            obj = new s(X, false, 2, (DefaultConstructorMarker) null);
        }
        if (X != null && (O(X) || d0(X))) {
            m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((s) obj).b();
        }
        if (!g10) {
            r0(X);
        }
        s0(obj);
        androidx.concurrent.futures.a.a(_state$FU, this, bVar, m1.g(obj));
        R(bVar, obj);
        return obj;
    }

    private final n V(z0 z0Var) {
        n nVar;
        if (z0Var instanceof n) {
            nVar = (n) z0Var;
        } else {
            nVar = null;
        }
        if (nVar != null) {
            return nVar;
        }
        o1 c10 = z0Var.c();
        if (c10 != null) {
            return o0(c10);
        }
        return null;
    }

    private final Throwable W(Object obj) {
        s sVar;
        if (obj instanceof s) {
            sVar = (s) obj;
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.f1129a;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable X(kotlinx.coroutines.JobSupport.b r5, java.util.List r6) {
        /*
            r4 = this;
            boolean r0 = r6.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0017
            kotlinx.coroutines.g1 r5 = new kotlinx.coroutines.g1
            java.lang.String r6 = r4.P()
            r5.<init>(r6, r1, r4)
            return r5
        L_0x0017:
            return r1
        L_0x0018:
            r5 = r6
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r0 = r5.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            boolean r3 = r3 instanceof java.util.concurrent.CancellationException
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x001f
            goto L_0x0034
        L_0x0033:
            r2 = r1
        L_0x0034:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == 0) goto L_0x0039
            return r2
        L_0x0039:
            r0 = 0
            java.lang.Object r6 = r6.get(r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            boolean r0 = r6 instanceof kotlinx.coroutines.y1
            if (r0 == 0) goto L_0x0061
            java.util.Iterator r5 = r5.iterator()
        L_0x0048:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r5.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == r6) goto L_0x0048
            boolean r2 = r2 instanceof kotlinx.coroutines.y1
            if (r2 == 0) goto L_0x0048
            r1 = r0
        L_0x005c:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0061
            return r1
        L_0x0061:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.X(kotlinx.coroutines.JobSupport$b, java.util.List):java.lang.Throwable");
    }

    private final o1 a0(z0 z0Var) {
        o1 c10 = z0Var.c();
        if (c10 != null) {
            return c10;
        }
        if (z0Var instanceof p0) {
            return new o1();
        }
        if (z0Var instanceof l1) {
            v0((l1) z0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + z0Var).toString());
    }

    private final boolean i0() {
        Object c02;
        do {
            c02 = c0();
            if (!(c02 instanceof z0)) {
                return false;
            }
        } while (y0(c02) < 0);
        return true;
    }

    private final Object j0(d dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.b.b(dVar), 1);
        cancellableContinuationImpl.E();
        j.a(cancellableContinuationImpl, v(new s1(cancellableContinuationImpl)));
        Object A = cancellableContinuationImpl.A();
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            e.c(dVar);
        }
        if (A == kotlin.coroutines.intrinsics.b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        p0(((kotlinx.coroutines.JobSupport.b) r2).c(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return kotlinx.coroutines.m1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object k0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.c0()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.b
            if (r3 == 0) goto L_0x0052
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$b r3 = (kotlinx.coroutines.JobSupport.b) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.i()     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            cc.c0 r7 = kotlinx.coroutines.m1.f1102d     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r7 = move-exception
            goto L_0x0050
        L_0x001c:
            r3 = r2
            kotlinx.coroutines.JobSupport$b r3 = (kotlinx.coroutines.JobSupport.b) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.g()     // Catch:{ all -> 0x001a }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0033
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            java.lang.Throwable r1 = r6.T(r7)     // Catch:{ all -> 0x001a }
        L_0x002d:
            r7 = r2
            kotlinx.coroutines.JobSupport$b r7 = (kotlinx.coroutines.JobSupport.b) r7     // Catch:{ all -> 0x001a }
            r7.b(r1)     // Catch:{ all -> 0x001a }
        L_0x0033:
            r7 = r2
            kotlinx.coroutines.JobSupport$b r7 = (kotlinx.coroutines.JobSupport.b) r7     // Catch:{ all -> 0x001a }
            java.lang.Throwable r7 = r7.f()     // Catch:{ all -> 0x001a }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003f
            r0 = r7
        L_0x003f:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.JobSupport$b r2 = (kotlinx.coroutines.JobSupport.b) r2
            kotlinx.coroutines.o1 r7 = r2.c()
            r6.p0(r7, r0)
        L_0x004b:
            cc.c0 r7 = kotlinx.coroutines.m1.f1099a
            return r7
        L_0x0050:
            monitor-exit(r2)
            throw r7
        L_0x0052:
            boolean r3 = r2 instanceof kotlinx.coroutines.z0
            if (r3 == 0) goto L_0x00a3
            if (r1 != 0) goto L_0x005c
            java.lang.Throwable r1 = r6.T(r7)
        L_0x005c:
            r3 = r2
            kotlinx.coroutines.z0 r3 = (kotlinx.coroutines.z0) r3
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x0070
            boolean r2 = r6.E0(r3, r1)
            if (r2 == 0) goto L_0x0002
            cc.c0 r7 = kotlinx.coroutines.m1.f1099a
            return r7
        L_0x0070:
            kotlinx.coroutines.s r3 = new kotlinx.coroutines.s
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.F0(r2, r3)
            cc.c0 r4 = kotlinx.coroutines.m1.f1099a
            if (r3 == r4) goto L_0x0088
            cc.c0 r2 = kotlinx.coroutines.m1.f1101c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0088:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a3:
            cc.c0 r7 = kotlinx.coroutines.m1.f1102d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.k0(java.lang.Object):java.lang.Object");
    }

    private final l1 m0(Function1 function1, boolean z10) {
        l1 l1Var = null;
        if (z10) {
            if (function1 instanceof h1) {
                l1Var = (h1) function1;
            }
            if (l1Var == null) {
                l1Var = new d1(function1);
            }
        } else {
            if (function1 instanceof l1) {
                l1Var = (l1) function1;
            }
            if (l1Var == null) {
                l1Var = new e1(function1);
            }
        }
        l1Var.u(this);
        return l1Var;
    }

    private final n o0(o oVar) {
        while (oVar.n()) {
            oVar = oVar.m();
        }
        while (true) {
            oVar = oVar.l();
            if (!oVar.n()) {
                if (oVar instanceof n) {
                    return (n) oVar;
                }
                if (oVar instanceof o1) {
                    return null;
                }
            }
        }
    }

    private final void p0(o1 o1Var, Throwable th) {
        r0(th);
        Object k10 = o1Var.k();
        m.d(k10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        v vVar = null;
        for (o oVar = (o) k10; !m.b(oVar, o1Var); oVar = oVar.l()) {
            if (oVar instanceof h1) {
                l1 l1Var = (l1) oVar;
                try {
                    l1Var.s(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        kotlin.b.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        Unit unit = Unit.f12577a;
                    }
                }
            }
        }
        if (vVar != null) {
            e0(vVar);
        }
        O(th);
    }

    private final void q0(o1 o1Var, Throwable th) {
        Object k10 = o1Var.k();
        m.d(k10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        v vVar = null;
        for (o oVar = (o) k10; !m.b(oVar, o1Var); oVar = oVar.l()) {
            if (oVar instanceof l1) {
                l1 l1Var = (l1) oVar;
                try {
                    l1Var.s(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        kotlin.b.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        Unit unit = Unit.f12577a;
                    }
                }
            }
        }
        if (vVar != null) {
            e0(vVar);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.y0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void u0(kotlinx.coroutines.p0 r3) {
        /*
            r2 = this;
            kotlinx.coroutines.o1 r0 = new kotlinx.coroutines.o1
            r0.<init>()
            boolean r1 = r3.a()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.y0 r1 = new kotlinx.coroutines.y0
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.u0(kotlinx.coroutines.p0):void");
    }

    private final void v0(l1 l1Var) {
        l1Var.g(new o1());
        androidx.concurrent.futures.a.a(_state$FU, this, l1Var, l1Var.l());
    }

    private final int y0(Object obj) {
        if (obj instanceof p0) {
            if (((p0) obj).a()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(_state$FU, this, obj, m1.f1105g)) {
                return -1;
            }
            t0();
            return 1;
        } else if (!(obj instanceof y0)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(_state$FU, this, obj, ((y0) obj).c())) {
                return -1;
            }
            t0();
            return 1;
        }
    }

    private final String z0(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.g()) {
                return "Cancelling";
            }
            if (bVar.h()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof z0) {
            if (((z0) obj).a()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof s) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    public CancellationException A() {
        Throwable th;
        Object c02 = c0();
        CancellationException cancellationException = null;
        if (c02 instanceof b) {
            th = ((b) c02).f();
        } else if (c02 instanceof s) {
            th = ((s) c02).f1129a;
        } else if (!(c02 instanceof z0)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + c02).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new g1("Parent job is " + z0(c02), th, this);
    }

    /* access modifiers changed from: protected */
    public final CancellationException A0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = P();
            }
            cancellationException = new g1(str, th, this);
        }
        return cancellationException;
    }

    public final String C0() {
        return n0() + '{' + z0(c0()) + '}';
    }

    public final m E(o oVar) {
        m0 d10 = f1.a.d(this, true, false, new n(oVar), 2, (Object) null);
        m.d(d10, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (m) d10;
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
    }

    public final boolean K(Throwable th) {
        return L(th);
    }

    public final boolean L(Object obj) {
        Object a10 = m1.f1099a;
        if (Z() && (a10 = N(obj)) == m1.f1100b) {
            return true;
        }
        if (a10 == m1.f1099a) {
            a10 = k0(obj);
        }
        if (a10 == m1.f1099a || a10 == m1.f1100b) {
            return true;
        }
        if (a10 == m1.f1102d) {
            return false;
        }
        J(a10);
        return true;
    }

    public void M(Throwable th) {
        L(th);
    }

    /* access modifiers changed from: protected */
    public String P() {
        return "Job was cancelled";
    }

    public boolean Q(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!L(th) || !Y()) {
            return false;
        }
        return true;
    }

    public boolean Y() {
        return true;
    }

    public boolean Z() {
        return false;
    }

    public boolean a() {
        Object c02 = c0();
        if (!(c02 instanceof z0) || !((z0) c02).a()) {
            return false;
        }
        return true;
    }

    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new g1(P(), (Throwable) null, this);
        }
        M(cancellationException);
    }

    public final m b0() {
        return (m) _parentHandle$FU.get(this);
    }

    public final Object c0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).a(this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean d0(Throwable th) {
        return false;
    }

    public void e0(Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public final void f0(f1 f1Var) {
        if (f1Var == null) {
            x0(p1.f1110a);
            return;
        }
        f1Var.start();
        m E = f1Var.E(this);
        x0(E);
        if (g0()) {
            E.dispose();
            x0(p1.f1110a);
        }
    }

    public Object fold(Object obj, Function2 function2) {
        return f1.a.b(this, obj, function2);
    }

    public final boolean g0() {
        return !(c0() instanceof z0);
    }

    public CoroutineContext.Element get(CoroutineContext.b bVar) {
        return f1.a.c(this, bVar);
    }

    public final CoroutineContext.b getKey() {
        return f1.f964r;
    }

    public f1 getParent() {
        m b02 = b0();
        if (b02 != null) {
            return b02.getParent();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean h0() {
        return false;
    }

    public final boolean isCancelled() {
        Object c02 = c0();
        if ((c02 instanceof s) || ((c02 instanceof b) && ((b) c02).g())) {
            return true;
        }
        return false;
    }

    public final Object k(d dVar) {
        if (!i0()) {
            j1.f(dVar.getContext());
            return Unit.f12577a;
        }
        Object j02 = j0(dVar);
        if (j02 == kotlin.coroutines.intrinsics.b.c()) {
            return j02;
        }
        return Unit.f12577a;
    }

    public final Object l0(Object obj) {
        Object F0;
        do {
            F0 = F0(c0(), obj);
            if (F0 == m1.f1099a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, W(obj));
            }
        } while (F0 == m1.f1101c);
        return F0;
    }

    public final m0 m(boolean z10, boolean z11, Function1 function1) {
        s sVar;
        l1 m02 = m0(function1, z10);
        while (true) {
            Object c02 = c0();
            if (c02 instanceof p0) {
                p0 p0Var = (p0) c02;
                if (!p0Var.a()) {
                    u0(p0Var);
                } else if (androidx.concurrent.futures.a.a(_state$FU, this, c02, m02)) {
                    return m02;
                }
            } else {
                Throwable th = null;
                if (c02 instanceof z0) {
                    o1 c10 = ((z0) c02).c();
                    if (c10 == null) {
                        m.d(c02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        v0((l1) c02);
                    } else {
                        m0 m0Var = p1.f1110a;
                        if (z10 && (c02 instanceof b)) {
                            synchronized (c02) {
                                try {
                                    th = ((b) c02).f();
                                    if (th != null) {
                                        if ((function1 instanceof n) && !((b) c02).h()) {
                                        }
                                        Unit unit = Unit.f12577a;
                                    }
                                    if (H(c02, c10, m02)) {
                                        if (th == null) {
                                            return m02;
                                        }
                                        m0Var = m02;
                                        Unit unit2 = Unit.f12577a;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z11) {
                                function1.invoke(th);
                            }
                            return m0Var;
                        } else if (H(c02, c10, m02)) {
                            return m02;
                        }
                    }
                } else {
                    if (z11) {
                        if (c02 instanceof s) {
                            sVar = (s) c02;
                        } else {
                            sVar = null;
                        }
                        if (sVar != null) {
                            th = sVar.f1129a;
                        }
                        function1.invoke(th);
                    }
                    return p1.f1110a;
                }
            }
        }
    }

    public CoroutineContext minusKey(CoroutineContext.b bVar) {
        return f1.a.e(this, bVar);
    }

    public final CancellationException n() {
        Object c02 = c0();
        if (c02 instanceof b) {
            Throwable f10 = ((b) c02).f();
            if (f10 != null) {
                CancellationException A0 = A0(f10, f0.a(this) + " is cancelling");
                if (A0 != null) {
                    return A0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (c02 instanceof z0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (c02 instanceof s) {
            return B0(this, ((s) c02).f1129a, (String) null, 1, (Object) null);
        } else {
            return new g1(f0.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public String n0() {
        return f0.a(this);
    }

    public final void p(r1 r1Var) {
        L(r1Var);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return f1.a.f(this, coroutineContext);
    }

    /* access modifiers changed from: protected */
    public void r0(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void s0(Object obj) {
    }

    public final boolean start() {
        int y02;
        do {
            y02 = y0(c0());
            if (y02 == 0) {
                return false;
            }
        } while (y02 != 1);
        return true;
    }

    /* access modifiers changed from: protected */
    public void t0() {
    }

    public String toString() {
        return C0() + '@' + f0.b(this);
    }

    public final m0 v(Function1 function1) {
        return m(false, true, function1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w0(kotlinx.coroutines.l1 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.c0()
            boolean r1 = r0 instanceof kotlinx.coroutines.l1
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            kotlinx.coroutines.p0 r2 = kotlinx.coroutines.m1.f1105g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.z0
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.z0 r0 = (kotlinx.coroutines.z0) r0
            kotlinx.coroutines.o1 r0 = r0.c()
            if (r0 == 0) goto L_0x0027
            r4.o()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.w0(kotlinx.coroutines.l1):void");
    }

    public final void x0(m mVar) {
        _parentHandle$FU.set(this, mVar);
    }
}
