package androidx.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ Function1<OnBackPressedCallback, Unit> $onBackPressed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnBackPressedDispatcherKt$addCallback$callback$1(boolean z10, Function1<? super OnBackPressedCallback, Unit> function1) {
        super(z10);
        this.$onBackPressed = function1;
    }

    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
