package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;

@c(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
final class UndispatchedContextCollector$emitRef$1 extends SuspendLambda implements Function2<Object, d, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.d $downstream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UndispatchedContextCollector$emitRef$1(kotlinx.coroutines.flow.d dVar, d dVar2) {
        super(2, dVar2);
        this.$downstream = dVar;
    }

    public final d k(Object obj, d dVar) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.$downstream, dVar);
        undispatchedContextCollector$emitRef$1.L$0 = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            Object obj2 = this.L$0;
            kotlinx.coroutines.flow.d dVar = this.$downstream;
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
    public final Object invoke(Object obj, d dVar) {
        return ((UndispatchedContextCollector$emitRef$1) k(obj, dVar)).n(Unit.f12577a);
    }
}
