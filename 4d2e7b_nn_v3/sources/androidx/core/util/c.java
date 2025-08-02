package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.coroutines.d;
import kotlin.o;

final class c extends AtomicBoolean implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    private final d f15134a;

    public c(d dVar) {
        super(false);
        this.f15134a = dVar;
    }

    public void accept(Object obj) {
        if (compareAndSet(false, true)) {
            this.f15134a.d(o.b(obj));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
