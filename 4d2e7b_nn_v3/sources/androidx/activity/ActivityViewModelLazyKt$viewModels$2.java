package androidx.activity;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;

public final class ActivityViewModelLazyKt$viewModels$2 extends n implements Function0<CreationExtras> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final CreationExtras invoke() {
        return this.$this_viewModels.getDefaultViewModelCreationExtras();
    }
}
