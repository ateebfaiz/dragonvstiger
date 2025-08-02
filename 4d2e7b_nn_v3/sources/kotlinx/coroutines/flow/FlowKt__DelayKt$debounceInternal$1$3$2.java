package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlin.p;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.internal.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {242}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<g, d, Object> {
    final /* synthetic */ d $downstream;
    final /* synthetic */ y $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$2(y yVar, d dVar, d dVar2) {
        super(2, dVar2);
        this.$lastValue = yVar;
        this.$downstream = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return u(((g) obj).k(), (d) obj2);
    }

    public final d k(Object obj, d dVar) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, dVar);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public final Object n(Object obj) {
        y yVar;
        y yVar2;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            Object k10 = ((g) this.L$0).k();
            yVar = this.$lastValue;
            boolean z10 = k10 instanceof g.c;
            if (!z10) {
                yVar.f725a = k10;
            }
            d dVar = this.$downstream;
            if (z10) {
                Throwable e10 = g.e(k10);
                if (e10 == null) {
                    Object obj2 = yVar.f725a;
                    if (obj2 != null) {
                        if (obj2 == n.f1056a) {
                            obj2 = null;
                        }
                        this.L$0 = k10;
                        this.L$1 = yVar;
                        this.label = 1;
                        if (dVar.i(obj2, this) == c10) {
                            return c10;
                        }
                        yVar2 = yVar;
                    }
                    yVar.f725a = n.f1058c;
                } else {
                    throw e10;
                }
            }
            return Unit.f12577a;
        } else if (i10 == 1) {
            yVar2 = (y) this.L$1;
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        yVar = yVar2;
        yVar.f725a = n.f1058c;
        return Unit.f12577a;
    }

    public final Object u(Object obj, d dVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) k(g.b(obj), dVar)).n(Unit.f12577a);
    }
}
