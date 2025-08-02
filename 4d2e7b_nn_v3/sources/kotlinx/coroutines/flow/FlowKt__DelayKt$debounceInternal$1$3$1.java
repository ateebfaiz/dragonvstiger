package kotlinx.coroutines.flow;

import cc.c0;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.flow.internal.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {232}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<d, Object> {
    final /* synthetic */ d $downstream;
    final /* synthetic */ y $lastValue;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$1(d dVar, y yVar, d dVar2) {
        super(1, dVar2);
        this.$downstream = dVar;
        this.$lastValue = yVar;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            d dVar = this.$downstream;
            c0 c0Var = n.f1056a;
            Object obj2 = this.$lastValue.f725a;
            if (obj2 == c0Var) {
                obj2 = null;
            }
            this.label = 1;
            if (dVar.i(obj2, this) == c10) {
                return c10;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue.f725a = null;
        return Unit.f12577a;
    }

    public final d u(d dVar) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, dVar);
    }

    /* renamed from: v */
    public final Object invoke(d dVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) u(dVar)).n(Unit.f12577a);
    }
}
