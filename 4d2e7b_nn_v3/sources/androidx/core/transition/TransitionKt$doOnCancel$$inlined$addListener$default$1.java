package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;

public final class TransitionKt$doOnCancel$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onCancel;

    public TransitionKt$doOnCancel$$inlined$addListener$default$1(Function1 function1) {
        this.$onCancel = function1;
    }

    public void onTransitionCancel(Transition transition) {
        this.$onCancel.invoke(transition);
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
