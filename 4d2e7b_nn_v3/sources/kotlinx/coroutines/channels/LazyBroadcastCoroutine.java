package kotlinx.coroutines.channels;

import dc.a;
import kotlin.coroutines.d;

final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    private final d continuation;

    public ReceiveChannel s() {
        ReceiveChannel s10 = M0().s();
        start();
        return s10;
    }

    /* access modifiers changed from: protected */
    public void t0() {
        a.b(this.continuation, this);
    }
}
