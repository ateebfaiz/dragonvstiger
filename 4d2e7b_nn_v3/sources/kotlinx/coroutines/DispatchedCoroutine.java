package kotlinx.coroutines;

import cc.i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.ScopeCoroutine;

public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, d dVar) {
        super(coroutineContext, dVar);
    }

    private final boolean N0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decision$FU;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean O0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _decision$FU;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    /* access modifiers changed from: protected */
    public void I0(Object obj) {
        if (!N0()) {
            i.c(b.b(this.uCont), w.a(obj, this.uCont), (Function1) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        I0(obj);
    }

    public final Object M0() {
        if (O0()) {
            return b.c();
        }
        Object h10 = m1.h(c0());
        if (!(h10 instanceof s)) {
            return h10;
        }
        throw ((s) h10).f1129a;
    }
}
