package kotlinx.coroutines;

import cc.i;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlinx.coroutines.internal.DispatchedContinuation;

public abstract class d2 {
    public static final Object a(d dVar) {
        DispatchedContinuation dispatchedContinuation;
        Object obj;
        CoroutineContext context = dVar.getContext();
        j1.f(context);
        d b10 = b.b(dVar);
        if (b10 instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) b10;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation == null) {
            obj = Unit.f12577a;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.p(context, Unit.f12577a);
            } else {
                c2 c2Var = new c2();
                CoroutineContext plus = context.plus(c2Var);
                Unit unit = Unit.f12577a;
                dispatchedContinuation.p(plus, unit);
                if (c2Var.f852a) {
                    if (i.d(dispatchedContinuation)) {
                        obj = b.c();
                    } else {
                        obj = unit;
                    }
                }
            }
            obj = b.c();
        }
        if (obj == b.c()) {
            e.c(dVar);
        }
        if (obj == b.c()) {
            return obj;
        }
        return Unit.f12577a;
    }
}
