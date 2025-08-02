package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function1<View, Unit> $action;
    final /* synthetic */ View $this_doOnAttach;

    public ViewKt$doOnAttach$1(View view, Function1<? super View, Unit> function1) {
        this.$this_doOnAttach = view;
        this.$action = function1;
    }

    public void onViewAttachedToWindow(View view) {
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
