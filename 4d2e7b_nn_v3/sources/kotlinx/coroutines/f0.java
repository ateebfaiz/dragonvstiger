package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.internal.DispatchedContinuation;

public abstract class f0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(d dVar) {
        Object obj;
        if (dVar instanceof DispatchedContinuation) {
            return dVar.toString();
        }
        try {
            o.a aVar = o.f12592b;
            obj = o.b(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            o.a aVar2 = o.f12592b;
            obj = o.b(p.a(th));
        }
        Throwable d10 = o.d(obj);
        String str = obj;
        if (d10 != null) {
            str = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) str;
    }
}
