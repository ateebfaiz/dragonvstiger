package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

public abstract class b1 {
    /* access modifiers changed from: private */
    public static final Object b(CoroutineContext coroutineContext, Function0 function0) {
        x1 x1Var;
        try {
            x1Var = new x1(j1.h(coroutineContext));
            x1Var.d();
            Object invoke = function0.invoke();
            x1Var.a();
            return invoke;
        } catch (InterruptedException e10) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e10);
        } catch (Throwable th) {
            x1Var.a();
            throw th;
        }
    }
}
