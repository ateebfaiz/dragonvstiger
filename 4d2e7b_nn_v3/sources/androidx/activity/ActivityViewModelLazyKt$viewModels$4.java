package androidx.activity;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

public final class ActivityViewModelLazyKt$viewModels$4 extends n implements Function0<CreationExtras> {
    final /* synthetic */ Function0<CreationExtras> $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$4(Function0<? extends CreationExtras> function0, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = function0;
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            kotlin.jvm.functions.Function0<androidx.lifecycle.viewmodel.CreationExtras> r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.activity.ComponentActivity r0 = r1.$this_viewModels
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ActivityViewModelLazyKt$viewModels$4.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
