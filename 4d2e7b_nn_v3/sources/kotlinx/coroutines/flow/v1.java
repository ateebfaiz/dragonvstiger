package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.internal.d;

final class v1 extends d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1084a = AtomicReferenceFieldUpdater.newUpdater(v1.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: d */
    public boolean a(StateFlowImpl stateFlowImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1084a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, u1.f1082a);
        return true;
    }

    public final Object e(kotlin.coroutines.d dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.b(dVar), 1);
        cancellableContinuationImpl.E();
        if (!a.a(f1084a, this, u1.f1082a, cancellableContinuationImpl)) {
            o.a aVar = o.f12592b;
            cancellableContinuationImpl.d(o.b(Unit.f12577a));
        }
        Object A = cancellableContinuationImpl.A();
        if (A == b.c()) {
            e.c(dVar);
        }
        if (A == b.c()) {
            return A;
        }
        return Unit.f12577a;
    }

    /* renamed from: f */
    public kotlin.coroutines.d[] b(StateFlowImpl stateFlowImpl) {
        f1084a.set(this, (Object) null);
        return c.f1052a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1084a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null && obj != u1.f1083b) {
                if (obj == u1.f1082a) {
                    if (a.a(f1084a, this, obj, u1.f1083b)) {
                        return;
                    }
                } else if (a.a(f1084a, this, obj, u1.f1082a)) {
                    o.a aVar = o.f12592b;
                    ((CancellableContinuationImpl) obj).d(o.b(Unit.f12577a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f1084a.getAndSet(this, u1.f1082a);
        m.c(andSet);
        if (andSet == u1.f1083b) {
            return true;
        }
        return false;
    }
}
