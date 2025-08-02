package androidx.activity.contextaware;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.n;

final class ContextAwareKt$withContextAvailable$2$1 extends n implements Function1<Throwable, Unit> {
    final /* synthetic */ ContextAwareKt$withContextAvailable$2$listener$1 $listener;
    final /* synthetic */ ContextAware $this_withContextAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(ContextAware contextAware, ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1) {
        super(1);
        this.$this_withContextAvailable = contextAware;
        this.$listener = contextAwareKt$withContextAvailable$2$listener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f12577a;
    }

    public final void invoke(Throwable th) {
        this.$this_withContextAvailable.removeOnContextAvailableListener(this.$listener);
    }
}
