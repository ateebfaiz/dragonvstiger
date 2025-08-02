package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public interface f1 extends CoroutineContext.Element {

    /* renamed from: r  reason: collision with root package name */
    public static final b f964r = b.f965a;

    public static final class a {
        public static /* synthetic */ void a(f1 f1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                f1Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object b(f1 f1Var, Object obj, Function2 function2) {
            return CoroutineContext.Element.a.a(f1Var, obj, function2);
        }

        public static CoroutineContext.Element c(f1 f1Var, CoroutineContext.b bVar) {
            return CoroutineContext.Element.a.b(f1Var, bVar);
        }

        public static /* synthetic */ m0 d(f1 f1Var, boolean z10, boolean z11, Function1 function1, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                if ((i10 & 2) != 0) {
                    z11 = true;
                }
                return f1Var.m(z10, z11, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(f1 f1Var, CoroutineContext.b bVar) {
            return CoroutineContext.Element.a.c(f1Var, bVar);
        }

        public static CoroutineContext f(f1 f1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.a.d(f1Var, coroutineContext);
        }
    }

    public static final class b implements CoroutineContext.b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f965a = new b();

        private b() {
        }
    }

    m E(o oVar);

    boolean a();

    void b(CancellationException cancellationException);

    f1 getParent();

    boolean isCancelled();

    Object k(d dVar);

    m0 m(boolean z10, boolean z11, Function1 function1);

    CancellationException n();

    boolean start();

    m0 v(Function1 function1);
}
