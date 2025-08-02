package kotlinx.coroutines.flow;

import cc.c0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.n;

public abstract class u1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f1082a = new c0("NONE");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f1083b = new c0("PENDING");

    public static final j1 a(Object obj) {
        if (obj == null) {
            obj = n.f1056a;
        }
        return new StateFlowImpl(obj);
    }

    public static final c d(t1 t1Var, CoroutineContext coroutineContext, int i10, c cVar) {
        if (((i10 < 0 || i10 >= 2) && i10 != -2) || cVar != c.DROP_OLDEST) {
            return n1.c(t1Var, coroutineContext, i10, cVar);
        }
        return t1Var;
    }
}
