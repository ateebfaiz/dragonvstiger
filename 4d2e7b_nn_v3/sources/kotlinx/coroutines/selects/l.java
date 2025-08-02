package kotlinx.coroutines.selects;

import kotlin.o;
import kotlin.p;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.y;

public abstract class l {
    /* access modifiers changed from: private */
    public static final void c(CancellableContinuation cancellableContinuation, Object obj) {
        y yVar = (y) cancellableContinuation.getContext().get(y.Key);
        if (yVar != null) {
            cancellableContinuation.q(yVar, obj);
        } else {
            cancellableContinuation.d(o.b(obj));
        }
    }

    /* access modifiers changed from: private */
    public static final void d(CancellableContinuation cancellableContinuation, Throwable th) {
        y yVar = (y) cancellableContinuation.getContext().get(y.Key);
        if (yVar != null) {
            cancellableContinuation.o(yVar, th);
            return;
        }
        o.a aVar = o.f12592b;
        cancellableContinuation.d(o.b(p.a(th)));
    }
}
