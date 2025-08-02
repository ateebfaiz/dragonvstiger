package kotlinx.coroutines.flow;

import cc.c0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.internal.g;

public abstract class n1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f1066a = new c0("NO_VALUE");

    public static final c c(m1 m1Var, CoroutineContext coroutineContext, int i10, c cVar) {
        if ((i10 == 0 || i10 == -3) && cVar == c.SUSPEND) {
            return m1Var;
        }
        return new g(m1Var, coroutineContext, i10, cVar);
    }

    /* access modifiers changed from: private */
    public static final Object d(Object[] objArr, long j10) {
        return objArr[((int) j10) & (objArr.length - 1)];
    }

    /* access modifiers changed from: private */
    public static final void e(Object[] objArr, long j10, Object obj) {
        objArr[((int) j10) & (objArr.length - 1)] = obj;
    }
}
