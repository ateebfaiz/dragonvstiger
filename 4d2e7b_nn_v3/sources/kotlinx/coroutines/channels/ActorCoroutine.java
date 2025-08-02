package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.v0;

class ActorCoroutine<E> extends ChannelCoroutine<E> implements b0, ReceiveChannel {
    /* access modifiers changed from: protected */
    public boolean d0(Throwable th) {
        a0.a(getContext(), th);
        return true;
    }

    /* access modifiers changed from: protected */
    public void r0(Throwable th) {
        e N0 = N0();
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = v0.a(f0.a(this) + " was cancelled", th);
            }
        }
        N0.b(cancellationException);
    }
}
