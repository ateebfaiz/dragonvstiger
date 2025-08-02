package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import cc.c0;
import cc.z;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.b;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.internal.DispatchedContinuation;

public class CancellableContinuationImpl<T> extends j0 implements CancellableContinuation<T>, b, b2 {
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$FU;
    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _parentHandle;
    private volatile Object _state = c.f849a;
    private final CoroutineContext context;
    private final d delegate;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        _decisionAndIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public CancellableContinuationImpl(d dVar, int i10) {
        super(i10);
        this.delegate = dVar;
        this.context = dVar.getContext();
    }

    private final String C() {
        Object B = B();
        if (B instanceof q1) {
            return "Active";
        }
        if (B instanceof k) {
            return "Cancelled";
        }
        return "Completed";
    }

    private final m0 F() {
        f1 f1Var = (f1) getContext().get(f1.f964r);
        if (f1Var == null) {
            return null;
        }
        m0 d10 = f1.a.d(f1Var, true, false, new l(this), 2, (Object) null);
        a.a(_parentHandle$FU, this, (Object) null, d10);
        return d10;
    }

    private final void G(Object obj) {
        boolean z10;
        Object obj2 = obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof c)) {
                if (obj3 instanceof g) {
                    z10 = true;
                } else {
                    z10 = obj3 instanceof z;
                }
                if (z10) {
                    K(obj2, obj3);
                } else if (obj3 instanceof s) {
                    s sVar = (s) obj3;
                    if (!sVar.b()) {
                        K(obj2, obj3);
                    }
                    if (obj3 instanceof k) {
                        Throwable th = null;
                        if (!(obj3 instanceof s)) {
                            sVar = null;
                        }
                        if (sVar != null) {
                            th = sVar.f1129a;
                        }
                        if (obj2 instanceof g) {
                            n((g) obj2, th);
                            return;
                        }
                        m.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        r((z) obj2, th);
                        return;
                    }
                    return;
                } else if (obj3 instanceof r) {
                    r rVar = (r) obj3;
                    if (rVar.f1115b != null) {
                        K(obj2, obj3);
                    }
                    if (!(obj2 instanceof z)) {
                        m.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        g gVar = (g) obj2;
                        if (rVar.c()) {
                            n(gVar, rVar.f1118e);
                            return;
                        }
                        if (a.a(_state$FU, this, obj3, r.b(rVar, (Object) null, gVar, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(obj2 instanceof z)) {
                    m.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (a.a(_state$FU, this, obj3, new r(obj3, (g) obj2, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (a.a(_state$FU, this, obj3, obj2)) {
                return;
            }
        }
    }

    private final boolean I() {
        if (k0.c(this.resumeMode)) {
            d dVar = this.delegate;
            m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((DispatchedContinuation) dVar).s()) {
                return true;
            }
        }
        return false;
    }

    private final g J(Function1 function1) {
        if (function1 instanceof g) {
            return (g) function1;
        }
        return new c1(function1);
    }

    private final void K(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void P(Object obj, int i10, Function1 function1) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof q1) {
            } else {
                if (obj2 instanceof k) {
                    k kVar = (k) obj2;
                    if (kVar.c()) {
                        if (function1 != null) {
                            p(function1, kVar.f1129a);
                            return;
                        }
                        return;
                    }
                }
                m(obj);
                throw new f();
            }
        } while (!a.a(_state$FU, this, obj2, R((q1) obj2, obj, i10, function1, (Object) null)));
        w();
        x(i10);
    }

    static /* synthetic */ void Q(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i10, Function1 function1, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.P(obj, i10, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object R(q1 q1Var, Object obj, int i10, Function1 function1, Object obj2) {
        g gVar;
        if (obj instanceof s) {
            return obj;
        }
        if (!k0.b(i10) && obj2 == null) {
            return obj;
        }
        if (function1 == null && !(q1Var instanceof g) && obj2 == null) {
            return obj;
        }
        if (q1Var instanceof g) {
            gVar = (g) q1Var;
        } else {
            gVar = null;
        }
        return new r(obj, gVar, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    private final boolean S() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decisionAndIndex$FU.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    private final c0 T(Object obj, Object obj2, Function1 function1) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof q1) {
            } else if (!(obj3 instanceof r) || obj2 == null || ((r) obj3).f1117d != obj2) {
                return null;
            } else {
                return i.f1090a;
            }
        } while (!a.a(_state$FU, this, obj3, R((q1) obj3, obj, this.resumeMode, function1, obj2)));
        w();
        return i.f1090a;
    }

    private final boolean U() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decisionAndIndex$FU.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    private final Void m(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void r(z zVar, Throwable th) {
        int i10 = _decisionAndIndex$FU.get(this) & 536870911;
        if (i10 != 536870911) {
            try {
                zVar.o(i10, th, getContext());
            } catch (Throwable th2) {
                CoroutineContext context2 = getContext();
                a0.a(context2, new v("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    private final boolean u(Throwable th) {
        if (!I()) {
            return false;
        }
        d dVar = this.delegate;
        m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation) dVar).u(th);
    }

    private final void w() {
        if (!I()) {
            v();
        }
    }

    private final void x(int i10) {
        if (!S()) {
            k0.a(this, i10);
        }
    }

    private final m0 z() {
        return (m0) _parentHandle$FU.get(this);
    }

    public final Object A() {
        f1 f1Var;
        boolean I = I();
        if (U()) {
            if (z() == null) {
                F();
            }
            if (I) {
                N();
            }
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (I) {
            N();
        }
        Object B = B();
        if (B instanceof s) {
            throw ((s) B).f1129a;
        } else if (!k0.b(this.resumeMode) || (f1Var = (f1) getContext().get(f1.f964r)) == null || f1Var.a()) {
            return h(B);
        } else {
            CancellationException n10 = f1Var.n();
            b(B, n10);
            throw n10;
        }
    }

    public final Object B() {
        return _state$FU.get(this);
    }

    public void D(Object obj) {
        x(this.resumeMode);
    }

    public void E() {
        m0 F = F();
        if (F != null && H()) {
            F.dispose();
            _parentHandle$FU.set(this, p1.f1110a);
        }
    }

    public boolean H() {
        return !(B() instanceof q1);
    }

    /* access modifiers changed from: protected */
    public String L() {
        return "CancellableContinuation";
    }

    public final void M(Throwable th) {
        if (!u(th)) {
            s(th);
            w();
        }
    }

    public final void N() {
        DispatchedContinuation dispatchedContinuation;
        Throwable w10;
        d dVar = this.delegate;
        if (dVar instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) dVar;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null && (w10 = dispatchedContinuation.w(this)) != null) {
            v();
            s(w10);
        }
    }

    public final boolean O() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (!(obj instanceof r) || ((r) obj).f1117d == null) {
            _decisionAndIndex$FU.set(this, 536870911);
            atomicReferenceFieldUpdater.set(this, c.f849a);
            return true;
        }
        v();
        return false;
    }

    public boolean a() {
        return B() instanceof q1;
    }

    public void b(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof q1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof s)) {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (!rVar.c()) {
                        Throwable th2 = th;
                        if (a.a(_state$FU, this, obj2, r.b(rVar, (Object) null, (g) null, (Function1) null, (Object) null, th, 15, (Object) null))) {
                            rVar.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    Throwable th3 = th;
                    if (a.a(_state$FU, this, obj2, new r(obj2, (g) null, (Function1) null, (Object) null, th, 14, (DefaultConstructorMarker) null))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public b c() {
        d dVar = this.delegate;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public void d(Object obj) {
        Q(this, w.c(obj, this), this.resumeMode, (Function1) null, 4, (Object) null);
    }

    public final d e() {
        return this.delegate;
    }

    public void f(z zVar, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decisionAndIndex$FU;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        G(zVar);
    }

    public Throwable g(Object obj) {
        Throwable g10 = super.g(obj);
        if (g10 != null) {
            return g10;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.context;
    }

    public Object h(Object obj) {
        if (obj instanceof r) {
            return ((r) obj).f1114a;
        }
        return obj;
    }

    public void j(Function1 function1) {
        G(J(function1));
    }

    public Object k() {
        return B();
    }

    public Object l(Object obj, Object obj2, Function1 function1) {
        return T(obj, obj2, function1);
    }

    public final void n(g gVar, Throwable th) {
        try {
            gVar.h(th);
        } catch (Throwable th2) {
            CoroutineContext context2 = getContext();
            a0.a(context2, new v("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public void o(y yVar, Throwable th) {
        DispatchedContinuation dispatchedContinuation;
        int i10;
        d dVar = this.delegate;
        y yVar2 = null;
        if (dVar instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) dVar;
        } else {
            dispatchedContinuation = null;
        }
        s sVar = new s(th, false, 2, (DefaultConstructorMarker) null);
        if (dispatchedContinuation != null) {
            yVar2 = dispatchedContinuation.dispatcher;
        }
        if (yVar2 == yVar) {
            i10 = 4;
        } else {
            i10 = this.resumeMode;
        }
        Q(this, sVar, i10, (Function1) null, 4, (Object) null);
    }

    public final void p(Function1 function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context2 = getContext();
            a0.a(context2, new v("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public void q(y yVar, Object obj) {
        DispatchedContinuation dispatchedContinuation;
        int i10;
        d dVar = this.delegate;
        y yVar2 = null;
        if (dVar instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) dVar;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            yVar2 = dispatchedContinuation.dispatcher;
        }
        if (yVar2 == yVar) {
            i10 = 4;
        } else {
            i10 = this.resumeMode;
        }
        Q(this, obj, i10, (Function1) null, 4, (Object) null);
    }

    public boolean s(Throwable th) {
        Object obj;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z10 = false;
            if (!(obj instanceof q1)) {
                return false;
            }
            if ((obj instanceof g) || (obj instanceof z)) {
                z10 = true;
            }
        } while (!a.a(_state$FU, this, obj, new k(this, th, z10)));
        q1 q1Var = (q1) obj;
        if (q1Var instanceof g) {
            n((g) obj, th);
        } else if (q1Var instanceof z) {
            r((z) obj, th);
        }
        w();
        x(this.resumeMode);
        return true;
    }

    public void t(Object obj, Function1 function1) {
        P(obj, this.resumeMode, function1);
    }

    public String toString() {
        return L() + '(' + f0.c(this.delegate) + "){" + C() + "}@" + f0.b(this);
    }

    public final void v() {
        m0 z10 = z();
        if (z10 != null) {
            z10.dispose();
            _parentHandle$FU.set(this, p1.f1110a);
        }
    }

    public Throwable y(f1 f1Var) {
        return f1Var.n();
    }
}
