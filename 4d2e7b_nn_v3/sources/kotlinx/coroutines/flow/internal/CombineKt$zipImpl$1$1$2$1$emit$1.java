package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1;

@c(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1", f = "Combine.kt", l = {128}, m = "emit")
final class CombineKt$zipImpl$1$1$2$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1$2$1$emit$1(CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1 r12, d dVar) {
        super(dVar);
        this.this$0 = r12;
    }

    public final Object n(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((Object) null, this);
    }
}
