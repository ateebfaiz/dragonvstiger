package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.m;

abstract /* synthetic */ class s {
    public static final Object a(c cVar, d dVar) {
        Object a10 = cVar.a(m.f1055a, dVar);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }

    public static final Object b(c cVar, Function2 function2, d dVar) {
        Object f10 = e.f(t.b(e.x(cVar, function2), 0, (c) null, 2, (Object) null), dVar);
        if (f10 == b.c()) {
            return f10;
        }
        return Unit.f12577a;
    }

    public static final Object c(d dVar, c cVar, d dVar2) {
        e.m(dVar);
        Object a10 = cVar.a(dVar, dVar2);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }
}
