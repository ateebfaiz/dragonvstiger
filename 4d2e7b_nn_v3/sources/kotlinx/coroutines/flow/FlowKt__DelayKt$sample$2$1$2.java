package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.flow.internal.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", l = {299}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements Function2<Unit, d, Object> {
    final /* synthetic */ d $downstream;
    final /* synthetic */ y $lastValue;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2$1$2(y yVar, d dVar, d dVar2) {
        super(2, dVar2);
        this.$lastValue = yVar;
        this.$downstream = dVar;
    }

    public final d k(Object obj, d dVar) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            y yVar = this.$lastValue;
            Object obj2 = yVar.f725a;
            if (obj2 == null) {
                return Unit.f12577a;
            }
            yVar.f725a = null;
            d dVar = this.$downstream;
            if (obj2 == n.f1056a) {
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
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object invoke(Unit unit, d dVar) {
        return ((FlowKt__DelayKt$sample$2$1$2) k(unit, dVar)).n(Unit.f12577a);
    }
}
