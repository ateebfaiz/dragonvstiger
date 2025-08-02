package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.d;
import kotlin.o;

final class a extends AtomicBoolean implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    private final d f15133a;

    public a(d dVar) {
        super(false);
        this.f15133a = dVar;
    }

    public void accept(Object obj) {
        if (compareAndSet(false, true)) {
            this.f15133a.d(o.b(obj));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
