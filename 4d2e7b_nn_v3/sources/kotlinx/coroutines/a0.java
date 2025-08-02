package kotlinx.coroutines;

import cc.g;
import kotlin.b;
import kotlin.coroutines.CoroutineContext;

public abstract class a0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            z zVar = (z) coroutineContext.get(z.f1213q);
            if (zVar != null) {
                zVar.B(coroutineContext, th);
            } else {
                g.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            g.a(coroutineContext, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        b.a(runtimeException, th);
        return runtimeException;
    }
}
