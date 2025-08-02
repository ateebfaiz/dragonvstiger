package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;

public final class TransitionKt$doOnPause$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onPause;

    public TransitionKt$doOnPause$$inlined$addListener$default$1(Function1 function1) {
        this.$onPause = function1;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
        this.$onPause.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
