package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import kotlin.time.a;
import kotlinx.coroutines.y1;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", l = {}, m = "invokeSuspend")
final class FlowKt__DelayKt$timeoutInternal$1$1$2 extends SuspendLambda implements Function1<d, Object> {
    final /* synthetic */ long $timeout;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$timeoutInternal$1$1$2(long j10, d dVar) {
        super(1, dVar);
        this.$timeout = j10;
    }

    public final Object n(Object obj) {
        b.c();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        p.b(obj);
        throw new y1("Timed out waiting for " + a.w(this.$timeout));
    }

    public final d u(d dVar) {
        return new FlowKt__DelayKt$timeoutInternal$1$1$2(this.$timeout, dVar);
    }

    /* renamed from: v */
    public final Object invoke(d dVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$2) u(dVar)).n(Unit.f12577a);
    }
}
