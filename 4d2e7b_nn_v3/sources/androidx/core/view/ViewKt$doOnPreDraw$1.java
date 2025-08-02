package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ Function1<View, Unit> $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(Function1<? super View, Unit> function1, View view) {
        this.$action = function1;
        this.$this_doOnPreDraw = view;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
