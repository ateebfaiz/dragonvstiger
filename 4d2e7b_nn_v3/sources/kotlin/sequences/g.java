package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;

public abstract class g {
    public abstract Object c(Object obj, d dVar);

    public abstract Object e(Iterator it, d dVar);

    public final Object f(Sequence sequence, d dVar) {
        Object e10 = e(sequence.iterator(), dVar);
        if (e10 == b.c()) {
            return e10;
        }
        return Unit.f12577a;
    }
}
