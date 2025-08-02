package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.m;

final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final q0 eventLoop;

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        if (!m.b(Thread.currentThread(), this.blockedThread)) {
            Thread thread = this.blockedThread;
            b.a();
            LockSupport.unpark(thread);
        }
    }

    /* access modifiers changed from: protected */
    public boolean h0() {
        return true;
    }
}
