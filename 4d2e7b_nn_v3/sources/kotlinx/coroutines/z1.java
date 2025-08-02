package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public final class z1 extends y {

    /* renamed from: a  reason: collision with root package name */
    public static final z1 f1215a = new z1();

    private z1() {
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        c2 c2Var = (c2) coroutineContext.get(c2.f851b);
        if (c2Var != null) {
            c2Var.f852a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    public y limitedParallelism(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
