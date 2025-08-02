package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.DelayKt;

@c(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", l = {415}, m = "invokeSuspend")
final class FlowKt__MigrationKt$delayFlow$1 extends SuspendLambda implements Function2<d, d, Object> {
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__MigrationKt$delayFlow$1(long j10, d dVar) {
        super(2, dVar);
        this.$timeMillis = j10;
    }

    public final d k(Object obj, d dVar) {
        return new FlowKt__MigrationKt$delayFlow$1(this.$timeMillis, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            long j10 = this.$timeMillis;
            this.label = 1;
            if (DelayKt.b(j10, this) == c10) {
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
    public final Object invoke(d dVar, d dVar2) {
        return ((FlowKt__MigrationKt$delayFlow$1) k(dVar, dVar2)).n(Unit.f12577a);
    }
}
