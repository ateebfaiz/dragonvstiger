package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.r0;

public abstract class s0 extends q0 {
    /* access modifiers changed from: protected */
    public abstract Thread P();

    /* access modifiers changed from: protected */
    public void Q(long j10, r0.c cVar) {
        g0.f1085g.c0(j10, cVar);
    }

    /* access modifiers changed from: protected */
    public final void R() {
        Thread P = P();
        if (Thread.currentThread() != P) {
            b.a();
            LockSupport.unpark(P);
        }
    }
}
