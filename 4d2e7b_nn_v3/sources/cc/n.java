package cc;

import kotlin.jvm.internal.m;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f90a = new c0("CONDITION_FALSE");

    public static final Object a() {
        return f90a;
    }

    public static final o b(Object obj) {
        x xVar;
        o oVar;
        if (obj instanceof x) {
            xVar = (x) obj;
        } else {
            xVar = null;
        }
        if (xVar != null && (oVar = xVar.f111a) != null) {
            return oVar;
        }
        m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (o) obj;
    }
}
