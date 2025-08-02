package androidx.core.os;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ Function0<Unit> $action;

    public HandlerKt$postDelayed$runnable$1(Function0<Unit> function0) {
        this.$action = function0;
    }

    public final void run() {
        this.$action.invoke();
    }
}
