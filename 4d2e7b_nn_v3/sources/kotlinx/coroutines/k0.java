package kotlinx.coroutines;

import cc.g0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.internal.DispatchedContinuation;

public abstract class k0 {
    public static final void a(j0 j0Var, int i10) {
        boolean z10;
        d e10 = j0Var.e();
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !(e10 instanceof DispatchedContinuation) || b(i10) != b(j0Var.resumeMode)) {
            d(j0Var, e10, z10);
            return;
        }
        y yVar = ((DispatchedContinuation) e10).dispatcher;
        CoroutineContext context = e10.getContext();
        if (yVar.isDispatchNeeded(context)) {
            yVar.dispatch(context, j0Var);
        } else {
            e(j0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final void d(j0 j0Var, d dVar, boolean z10) {
        Object h10;
        UndispatchedCoroutine undispatchedCoroutine;
        Object k10 = j0Var.k();
        Throwable g10 = j0Var.g(k10);
        if (g10 != null) {
            o.a aVar = o.f12592b;
            h10 = p.a(g10);
        } else {
            o.a aVar2 = o.f12592b;
            h10 = j0Var.h(k10);
        }
        Object b10 = o.b(h10);
        if (z10) {
            m.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
            d dVar2 = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            CoroutineContext context = dVar2.getContext();
            Object c10 = g0.c(context, obj);
            if (c10 != g0.f66a) {
                undispatchedCoroutine = x.g(dVar2, context, c10);
            } else {
                undispatchedCoroutine = null;
            }
            try {
                dispatchedContinuation.continuation.d(b10);
                Unit unit = Unit.f12577a;
            } finally {
                if (undispatchedCoroutine == null || undispatchedCoroutine.M0()) {
                    g0.a(context, c10);
                }
            }
        } else {
            dVar.d(b10);
        }
    }

    private static final void e(j0 j0Var) {
        q0 a10 = w1.f1199a.a();
        if (a10.M()) {
            a10.I(j0Var);
            return;
        }
        a10.K(true);
        try {
            d(j0Var, j0Var.e(), true);
            do {
            } while (a10.O());
        } catch (Throwable th) {
            a10.G(true);
            throw th;
        }
        a10.G(true);
    }
}
