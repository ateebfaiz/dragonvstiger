package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;

public final class TransitionKt$doOnResume$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 $onResume;

    public TransitionKt$doOnResume$$inlined$addListener$default$1(Function1 function1) {
        this.$onResume = function1;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
        this.$onResume.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
    }
}
