package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.c;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.t1;

final class s extends SharedFlowImpl implements t1 {
    public s(int i10) {
        super(1, Integer.MAX_VALUE, c.DROP_OLDEST);
        f(Integer.valueOf(i10));
    }

    public final boolean Z(int i10) {
        boolean f10;
        synchronized (this) {
            f10 = f(Integer.valueOf(((Number) M()).intValue() + i10));
        }
        return f10;
    }
}
