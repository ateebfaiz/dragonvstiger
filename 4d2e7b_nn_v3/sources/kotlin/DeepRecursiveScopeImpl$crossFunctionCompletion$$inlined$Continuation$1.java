package kotlin;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import vb.n;

public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements d {
    final /* synthetic */ d $cont$inlined;
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ n $currentFunction$inlined;
    final /* synthetic */ DeepRecursiveScopeImpl this$0;

    public void d(Object obj) {
        this.this$0.function = this.$currentFunction$inlined;
        this.this$0.cont = this.$cont$inlined;
        this.this$0.result = obj;
    }

    public CoroutineContext getContext() {
        return this.$context;
    }
}
