package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import vb.n;

@c(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", l = {306}, m = "invokeSuspend")
final class FlowKt__MigrationKt$onErrorReturn$2 extends SuspendLambda implements n {
    final /* synthetic */ Object $fallback;
    final /* synthetic */ Function1<Throwable, Boolean> $predicate;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__MigrationKt$onErrorReturn$2(Function1 function1, Object obj, d dVar) {
        super(3, dVar);
        this.$predicate = function1;
        this.$fallback = obj;
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            d dVar = (d) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                Object obj2 = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (dVar.i(obj2, this) == c10) {
                    return c10;
                }
            } else {
                throw th;
            }
        } else if (i10 == 1) {
            p.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f12577a;
    }

    /* renamed from: u */
    public final Object e(d dVar, Throwable th, d dVar2) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.$predicate, this.$fallback, dVar2);
        flowKt__MigrationKt$onErrorReturn$2.L$0 = dVar;
        flowKt__MigrationKt$onErrorReturn$2.L$1 = th;
        return flowKt__MigrationKt$onErrorReturn$2.n(Unit.f12577a);
    }
}
