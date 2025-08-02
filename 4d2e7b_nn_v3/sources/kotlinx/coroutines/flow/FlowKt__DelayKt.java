package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;

abstract /* synthetic */ class FlowKt__DelayKt {
    public static final ReceiveChannel a(b0 b0Var, long j10, long j11) {
        if (j10 < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j10 + " ms").toString());
        } else if (j11 >= 0) {
            return ProduceKt.d(b0Var, (CoroutineContext) null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j11, j10, (d) null), 1, (Object) null);
        } else {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j11 + " ms").toString());
        }
    }

    public static /* synthetic */ ReceiveChannel b(b0 b0Var, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        return e.r(b0Var, j10, j11);
    }
}
