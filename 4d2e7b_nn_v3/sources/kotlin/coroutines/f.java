package kotlin.coroutines;

import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;

public abstract class f {
    public static final void a(Function2 function2, Object obj, d dVar) {
        m.f(function2, "<this>");
        m.f(dVar, "completion");
        d b10 = b.b(b.a(function2, obj, dVar));
        o.a aVar = o.f12592b;
        b10.d(o.b(Unit.f12577a));
    }
}
