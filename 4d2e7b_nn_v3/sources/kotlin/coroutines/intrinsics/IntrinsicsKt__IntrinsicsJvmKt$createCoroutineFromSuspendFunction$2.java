package kotlin.coroutines.intrinsics;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.p;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {
    final /* synthetic */ Function1<d, Object> $block;
    private int label;

    /* access modifiers changed from: protected */
    public Object n(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            this.label = 1;
            p.b(obj);
            return this.$block.invoke(this);
        } else if (i10 == 1) {
            this.label = 2;
            p.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
