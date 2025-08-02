package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ViewKt$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Function1<View, Unit> $action;
    final /* synthetic */ View $this_doOnDetach;

    public ViewKt$doOnDetach$1(View view, Function1<? super View, Unit> function1) {
        this.$this_doOnDetach = view;
        this.$action = function1;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }
}
