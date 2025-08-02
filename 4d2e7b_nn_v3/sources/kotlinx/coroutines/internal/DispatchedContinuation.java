package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import cc.c0;
import cc.g0;
import cc.i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.t;
import kotlinx.coroutines.w;
import kotlinx.coroutines.w1;
import kotlinx.coroutines.y;

public final class DispatchedContinuation<T> extends j0 implements b, d {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object _state = i.f74a;
    public final d continuation;
    public final Object countOrElement = g0.b(getContext());
    public final y dispatcher;

    public DispatchedContinuation(y yVar, d dVar) {
        super(-1);
        this.dispatcher = yVar;
        this.continuation = dVar;
    }

    private final CancellableContinuationImpl r() {
        Object obj = _reusableCancellableContinuation$FU.get(this);
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    public void b(Object obj, Throwable th) {
        if (obj instanceof t) {
            ((t) obj).f1194b.invoke(th);
        }
    }

    public b c() {
        d dVar = this.continuation;
        if (dVar instanceof b) {
            return (b) dVar;
        }
        return null;
    }

    public void d(Object obj) {
        CoroutineContext context;
        Object c10;
        CoroutineContext context2 = this.continuation.getContext();
        Object d10 = w.d(obj, (Function1) null, 1, (Object) null);
        if (this.dispatcher.isDispatchNeeded(context2)) {
            this._state = d10;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context2, this);
            return;
        }
        q0 a10 = w1.f1199a.a();
        if (a10.M()) {
            this._state = d10;
            this.resumeMode = 0;
            a10.I(this);
            return;
        }
        a10.K(true);
        try {
            context = getContext();
            c10 = g0.c(context, this.countOrElement);
            this.continuation.d(obj);
            Unit unit = Unit.f12577a;
            g0.a(context, c10);
            do {
            } while (a10.O());
        } catch (Throwable th) {
            a10.G(true);
            throw th;
        }
        a10.G(true);
    }

    public d e() {
        return this;
    }

    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public Object k() {
        Object obj = this._state;
        this._state = i.f74a;
        return obj;
    }

    public final void m() {
        do {
        } while (_reusableCancellableContinuation$FU.get(this) == i.f75b);
    }

    public final CancellableContinuationImpl n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                _reusableCancellableContinuation$FU.set(this, i.f75b);
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (a.a(_reusableCancellableContinuation$FU, this, obj, i.f75b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != i.f75b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void p(CoroutineContext coroutineContext, Object obj) {
        this._state = obj;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    public final boolean s() {
        if (_reusableCancellableContinuation$FU.get(this) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + f0.c(this.continuation) + ']';
    }

    public final boolean u(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0 c0Var = i.f75b;
            if (m.b(obj, c0Var)) {
                if (a.a(_reusableCancellableContinuation$FU, this, c0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(_reusableCancellableContinuation$FU, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void v() {
        m();
        CancellableContinuationImpl r10 = r();
        if (r10 != null) {
            r10.v();
        }
    }

    public final Throwable w(CancellableContinuation cancellableContinuation) {
        c0 c0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _reusableCancellableContinuation$FU;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0Var = i.f75b;
            if (obj != c0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(_reusableCancellableContinuation$FU, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!a.a(_reusableCancellableContinuation$FU, this, c0Var, cancellableContinuation));
        return null;
    }
}
