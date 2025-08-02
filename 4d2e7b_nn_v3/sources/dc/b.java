package dc;

import cc.g0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.s;
import kotlinx.coroutines.y1;

public abstract class b {
    public static final void a(Function2 function2, Object obj, d dVar) {
        CoroutineContext context;
        Object c10;
        d a10 = e.a(dVar);
        try {
            context = dVar.getContext();
            c10 = g0.c(context, (Object) null);
            Object invoke = ((Function2) c0.e(function2, 2)).invoke(obj, a10);
            g0.a(context, c10);
            if (invoke != kotlin.coroutines.intrinsics.b.c()) {
                a10.d(o.b(invoke));
            }
        } catch (Throwable th) {
            o.a aVar = o.f12592b;
            a10.d(o.b(p.a(th)));
        }
    }

    public static final Object b(ScopeCoroutine scopeCoroutine, Object obj, Function2 function2) {
        Object obj2;
        try {
            obj2 = ((Function2) c0.e(function2, 2)).invoke(obj, scopeCoroutine);
        } catch (Throwable th) {
            obj2 = new s(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj2 == kotlin.coroutines.intrinsics.b.c()) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        Object l02 = scopeCoroutine.l0(obj2);
        if (l02 == m1.f1100b) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (!(l02 instanceof s)) {
            return m1.h(l02);
        }
        throw ((s) l02).f1129a;
    }

    public static final Object c(ScopeCoroutine scopeCoroutine, Object obj, Function2 function2) {
        Object obj2;
        try {
            obj2 = ((Function2) c0.e(function2, 2)).invoke(obj, scopeCoroutine);
        } catch (Throwable th) {
            obj2 = new s(th, false, 2, (DefaultConstructorMarker) null);
        }
        if (obj2 == kotlin.coroutines.intrinsics.b.c()) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        Object l02 = scopeCoroutine.l0(obj2);
        if (l02 == m1.f1100b) {
            return kotlin.coroutines.intrinsics.b.c();
        }
        if (l02 instanceof s) {
            Throwable th2 = ((s) l02).f1129a;
            if (!(th2 instanceof y1) || ((y1) th2).f1212a != scopeCoroutine) {
                throw th2;
            } else if (obj2 instanceof s) {
                throw ((s) obj2).f1129a;
            }
        } else {
            obj2 = m1.h(l02);
        }
        return obj2;
    }
}
