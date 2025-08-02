package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.o;
import kotlin.p;

public abstract class w {
    public static final Object a(Object obj, d dVar) {
        if (!(obj instanceof s)) {
            return o.b(obj);
        }
        o.a aVar = o.f12592b;
        return o.b(p.a(((s) obj).f1129a));
    }

    public static final Object b(Object obj, Function1 function1) {
        Throwable d10 = o.d(obj);
        if (d10 != null) {
            return new s(d10, false, 2, (DefaultConstructorMarker) null);
        }
        if (function1 != null) {
            return new t(obj, function1);
        }
        return obj;
    }

    public static final Object c(Object obj, CancellableContinuation cancellableContinuation) {
        Throwable d10 = o.d(obj);
        if (d10 == null) {
            return obj;
        }
        return new s(d10, false, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
