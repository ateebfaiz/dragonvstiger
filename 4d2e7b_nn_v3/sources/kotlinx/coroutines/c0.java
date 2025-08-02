package kotlinx.coroutines;

import cc.e;
import dc.b;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ScopeCoroutine;

public abstract class c0 {
    public static final b0 a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(f1.f964r) == null) {
            coroutineContext = coroutineContext.plus(k1.b((f1) null, 1, (Object) null));
        }
        return new e(coroutineContext);
    }

    public static final Object b(Function2 function2, d dVar) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(dVar.getContext(), dVar);
        Object b10 = b.b(scopeCoroutine, scopeCoroutine, function2);
        if (b10 == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.e.c(dVar);
        }
        return b10;
    }
}
