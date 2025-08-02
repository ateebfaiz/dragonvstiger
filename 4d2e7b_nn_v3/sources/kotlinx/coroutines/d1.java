package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class d1 extends h1 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f922f = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e  reason: collision with root package name */
    private final Function1 f923e;

    public d1(Function1 function1) {
        this.f923e = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.f12577a;
    }

    public void s(Throwable th) {
        if (f922f.compareAndSet(this, 0, 1)) {
            this.f923e.invoke(th);
        }
    }
}
