package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;

public final class TransitionKt$doOnEnd$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onEnd;

    public TransitionKt$doOnEnd$$inlined$addListener$default$1(Function1 function1) {
        this.$onEnd = function1;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.$onEnd.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
