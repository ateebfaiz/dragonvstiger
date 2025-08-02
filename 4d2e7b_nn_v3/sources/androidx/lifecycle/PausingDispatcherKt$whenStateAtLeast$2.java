package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.e;
import kotlinx.coroutines.f1;

@c(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<b0, d, Object> {
    final /* synthetic */ Function2<b0, d, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, d dVar) {
        super(2, dVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = function2;
    }

    public final d k(Object obj, d dVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, dVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object n(Object obj) {
        LifecycleController lifecycleController;
        Object c10 = b.c();
        int i10 = this.label;
        if (i10 == 0) {
            p.b(obj);
            f1 f1Var = (f1) ((b0) this.L$0).getCoroutineContext().get(f1.f964r);
            if (f1Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, f1Var);
                try {
                    Function2<b0, d, Object> function2 = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = e.c(pausingDispatcher, function2, this);
                    if (obj == c10) {
                        return c10;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i10 == 1) {
            lifecycleController = (LifecycleController) this.L$0;
            try {
                p.b(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.finish();
        return obj;
    }

    /* renamed from: u */
    public final Object invoke(b0 b0Var, d dVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) k(b0Var, dVar)).n(Unit.f12577a);
    }
}
