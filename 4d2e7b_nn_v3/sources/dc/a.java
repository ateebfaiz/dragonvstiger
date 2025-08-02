package dc;

import cc.i;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.p;

public abstract class a {
    private static final void a(d dVar, Throwable th) {
        o.a aVar = o.f12592b;
        dVar.d(o.b(p.a(th)));
        throw th;
    }

    public static final void b(d dVar, d dVar2) {
        try {
            d b10 = b.b(dVar);
            o.a aVar = o.f12592b;
            i.c(b10, o.b(Unit.f12577a), (Function1) null, 2, (Object) null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final void c(Function2 function2, Object obj, d dVar, Function1 function1) {
        try {
            d b10 = b.b(b.a(function2, obj, dVar));
            o.a aVar = o.f12592b;
            i.b(b10, o.b(Unit.f12577a), function1);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(Function2 function2, Object obj, d dVar, Function1 function1, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        c(function2, obj, dVar, function1);
    }
}
