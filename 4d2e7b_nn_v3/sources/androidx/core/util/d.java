package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.o;

final class d extends AtomicBoolean implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.coroutines.d f15135a;

    public d(kotlin.coroutines.d dVar) {
        super(false);
        this.f15135a = dVar;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d dVar = this.f15135a;
            o.a aVar = o.f12592b;
            dVar.d(o.b(Unit.f12577a));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
