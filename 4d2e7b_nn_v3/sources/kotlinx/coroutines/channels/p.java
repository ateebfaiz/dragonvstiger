package kotlinx.coroutines.channels;

import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;

public interface p {

    public static final class a {
        public static /* synthetic */ boolean a(p pVar, Throwable th, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    th = null;
                }
                return pVar.r(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean r(Throwable th);

    void u(Function1 function1);

    Object w(Object obj);

    Object x(Object obj, d dVar);

    boolean y();
}
