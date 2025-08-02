package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlinx.coroutines.internal.DispatchedContinuation;

public abstract class j {
    public static final void a(CancellableContinuation cancellableContinuation, m0 m0Var) {
        cancellableContinuation.j(new n0(m0Var));
    }

    public static final CancellableContinuationImpl b(d dVar) {
        if (!(dVar instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(dVar, 1);
        }
        CancellableContinuationImpl n10 = ((DispatchedContinuation) dVar).n();
        if (n10 != null) {
            if (!n10.O()) {
                n10 = null;
            }
            if (n10 != null) {
                return n10;
            }
        }
        return new CancellableContinuationImpl(dVar, 2);
    }
}
