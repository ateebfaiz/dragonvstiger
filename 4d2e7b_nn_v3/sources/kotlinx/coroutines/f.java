package kotlinx.coroutines;

import cc.g0;
import dc.a;
import dc.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.e;
import kotlin.coroutines.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.internal.ScopeCoroutine;

abstract /* synthetic */ class f {
    public static final f1 a(b0 b0Var, CoroutineContext coroutineContext, d0 d0Var, Function2 function2) {
        AbstractCoroutine abstractCoroutine;
        CoroutineContext e10 = x.e(b0Var, coroutineContext);
        if (d0Var.c()) {
            abstractCoroutine = new LazyStandaloneCoroutine(e10, function2);
        } else {
            abstractCoroutine = new StandaloneCoroutine(e10, true);
        }
        abstractCoroutine.L0(d0Var, abstractCoroutine, function2);
        return abstractCoroutine;
    }

    public static /* synthetic */ f1 b(b0 b0Var, CoroutineContext coroutineContext, d0 d0Var, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = g.f679a;
        }
        if ((i10 & 2) != 0) {
            d0Var = d0.DEFAULT;
        }
        return e.a(b0Var, coroutineContext, d0Var, function2);
    }

    /* JADX INFO: finally extract failed */
    public static final Object c(CoroutineContext coroutineContext, Function2 function2, d dVar) {
        Object obj;
        CoroutineContext context = dVar.getContext();
        CoroutineContext d10 = x.d(context, coroutineContext);
        j1.f(d10);
        if (d10 == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(d10, dVar);
            obj = b.b(scopeCoroutine, scopeCoroutine, function2);
        } else {
            e.b bVar = e.f677p;
            if (m.b(d10.get(bVar), context.get(bVar))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(d10, dVar);
                CoroutineContext context2 = undispatchedCoroutine.getContext();
                Object c10 = g0.c(context2, (Object) null);
                try {
                    Object b10 = b.b(undispatchedCoroutine, undispatchedCoroutine, function2);
                    g0.a(context2, c10);
                    obj = b10;
                } catch (Throwable th) {
                    g0.a(context2, c10);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(d10, dVar);
                a.d(function2, dispatchedCoroutine, dispatchedCoroutine, (Function1) null, 4, (Object) null);
                obj = dispatchedCoroutine.M0();
            }
        }
        if (obj == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.e.c(dVar);
        }
        return obj;
    }
}
