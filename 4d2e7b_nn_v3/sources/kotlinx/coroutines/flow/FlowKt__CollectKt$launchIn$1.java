package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
final class FlowKt__CollectKt$launchIn$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ c $this_launchIn;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__CollectKt$launchIn$1(c cVar, d dVar) {
        super(2, dVar);
        this.$this_launchIn = cVar;
    }

    public final d k(Object obj, d dVar) {
        return new FlowKt__CollectKt$launchIn$1(this.$this_launchIn, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            c cVar = this.$this_launchIn;
            this.label = 1;
            if (e.f(cVar, this) == c10) {
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
    public final Object invoke(b0 b0Var, d dVar) {
        return ((FlowKt__CollectKt$launchIn$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
