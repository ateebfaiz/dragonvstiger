package androidx.lifecycle;

import d.a;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;

public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        m.f(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, u1.b((f1) null, 1, (Object) null).plus(l0.c().G()));
        } while (!a.a(lifecycle.getInternalScopeRef(), (Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}
