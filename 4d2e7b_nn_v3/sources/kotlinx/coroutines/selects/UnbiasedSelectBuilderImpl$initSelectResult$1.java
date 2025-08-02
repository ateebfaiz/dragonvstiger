package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", l = {71}, m = "invokeSuspend")
final class UnbiasedSelectBuilderImpl$initSelectResult$1 extends SuspendLambda implements Function2<b0, d, Object> {
    int label;
    final /* synthetic */ n this$0;

    UnbiasedSelectBuilderImpl$initSelectResult$1(n nVar, d dVar) {
        super(2, dVar);
    }

    public final d k(Object obj, d dVar) {
        return new UnbiasedSelectBuilderImpl$initSelectResult$1((n) null, dVar);
    }

    public final Object n(Object obj) {
        b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            this.label = 1;
            throw null;
        } else if (i10 == 1) {
            try {
                p.b(obj);
                l.c(n.C((n) null), obj);
                return Unit.f12577a;
            } catch (Throwable th) {
                l.d(n.C((n) null), th);
                return Unit.f12577a;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((UnbiasedSelectBuilderImpl$initSelectResult$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
