package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

abstract /* synthetic */ class k1 {
    public static final q a(f1 f1Var) {
        return new i1(f1Var);
    }

    public static /* synthetic */ q b(f1 f1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f1Var = null;
        }
        return j1.a(f1Var);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        f1 f1Var = (f1) coroutineContext.get(f1.f964r);
        if (f1Var != null) {
            f1Var.b(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        j1.c(coroutineContext, cancellationException);
    }

    public static final m0 e(f1 f1Var, m0 m0Var) {
        return f1Var.v(new o0(m0Var));
    }

    public static final void f(CoroutineContext coroutineContext) {
        f1 f1Var = (f1) coroutineContext.get(f1.f964r);
        if (f1Var != null) {
            j1.g(f1Var);
        }
    }

    public static final void g(f1 f1Var) {
        if (!f1Var.a()) {
            throw f1Var.n();
        }
    }

    public static final f1 h(CoroutineContext coroutineContext) {
        f1 f1Var = (f1) coroutineContext.get(f1.f964r);
        if (f1Var != null) {
            return f1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }
}
