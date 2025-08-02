package ec;

import cc.l;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.y;

final class m extends y {

    /* renamed from: a  reason: collision with root package name */
    public static final m f214a = new m();

    private m() {
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        c.f197g.H(runnable, l.f213h, false);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        c.f197g.H(runnable, l.f213h, true);
    }

    public y limitedParallelism(int i10) {
        l.a(i10);
        if (i10 >= l.f209d) {
            return this;
        }
        return super.limitedParallelism(i10);
    }
}
