package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;

@c(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {356}, m = "invokeSuspend")
final class LifecycleCoroutineScope$launchWhenStarted$1 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Function2<b0, d, Object> $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, Function2 function2, d dVar) {
        super(2, dVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = function2;
    }

    public final d k(Object obj, d dVar) {
        return new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, dVar);
    }

    public final Object n(Object obj) {
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
            Function2<b0, d, Object> function2 = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, (Function2<? super b0, ? super d, ? extends Object>) function2, (d) this) == c10) {
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
        return ((LifecycleCoroutineScope$launchWhenStarted$1) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
