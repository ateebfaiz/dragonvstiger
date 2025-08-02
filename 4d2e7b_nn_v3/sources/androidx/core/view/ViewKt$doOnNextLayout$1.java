package androidx.core.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public final class ViewKt$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ Function1<View, Unit> $action;

    public ViewKt$doOnNextLayout$1(Function1<? super View, Unit> function1) {
        this.$action = function1;
    }

    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
