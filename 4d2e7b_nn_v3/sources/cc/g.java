package cc;

import kotlin.b;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.z;

public abstract class g {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        for (z B : f.a()) {
            try {
                B.B(coroutineContext, th);
            } catch (Throwable th2) {
                f.b(a0.b(th, th2));
            }
        }
        try {
            b.a(th, new h(coroutineContext));
        } catch (Throwable unused) {
        }
        f.b(th);
    }
}
